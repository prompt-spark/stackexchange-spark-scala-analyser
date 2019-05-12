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
