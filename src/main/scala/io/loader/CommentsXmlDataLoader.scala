/*
 * Copyright © 2019 Abhishek Verma (abhishekv3007@gmail.com)
 *
 *                    GNU AFFERO GENERAL PUBLIC LICENSE
 *                       Version 3, 19 November 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *                            Preamble
 *
 *   The GNU Affero General Public License is a free, copyleft license for
 * software and other kinds of works, specifically designed to ensure
 * cooperation with the community in the case of network server software.
 *
 *   The licenses for most software and other practical works are designed
 * to take away your freedom to share and change the works.  By contrast,
 * our General Public Licenses are intended to guarantee your freedom to
 * share and change all versions of a program--to make sure it remains free
 * software for all its users.
 */

package io.loader

import io.ioSchema.StackExchangeInputSchema.CommentsData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object CommentsXmlDataLoader {
  def loadCommentsDS(commentsXmlPath: String): Dataset[CommentsData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val commentsRawDF =
      spark.read
        .option("rowTag", "comments")
        .format("xml")
        .load(commentsXmlPath)

    val commentsMappedColnames = Seq("UserId",
                                     "UserDisplayName",
                                     "PostId",
                                     "Text",
                                     "Score",
                                     "CreationDate")

    import spark.implicits._

    val commentDataset: Dataset[CommentsData] = commentsRawDF
      .select(explode(col("row")))
      .select("col._UserId",
              "col._UserDisplayName",
              "col._PostId",
              "col._Text",
              "col._Score",
              "col._CreationDate")
      .toDF(commentsMappedColnames: _*)
      .as[CommentsData]

    commentDataset
  }
}