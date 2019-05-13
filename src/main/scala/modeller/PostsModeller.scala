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

package modeller

import io.api.ModellerHandler
import io.loader.{PostHistoryXmlDataLoader, PostXmlDataLoader}
import modeller.ModellerSchema.PostsModellerSchema.PostHistoryModelData
import org.apache.spark.sql.functions.{col, monotonically_increasing_id}
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Encoders

object PostsModeller {

  def postHistory(path: String): Dataset[PostHistoryModelData] = {

    val postHistory = PostHistoryXmlDataLoader
      .loadPostHistoryDS(path)
      .drop("Id", "CreationDate")

    val post = PostXmlDataLoader.loadPostDS(path)

    val postsHistory = post.join(postHistory,
                                 post.col("Id") ===
                                   postHistory.col("PostId"))

    val postsHistoryDS = postsHistory
      .drop("Id")
      .withColumn("Id", monotonically_increasing_id)
      .select(ModellerHandler.getMembers[PostHistoryModelData].map(col): _*)

    postsHistoryDS.as[PostHistoryModelData](Encoders.product)

  }

  def postLinks(path: String) = {}

  def postComments(path: String) = {}

  def postVotes(path: String) = {}

}
