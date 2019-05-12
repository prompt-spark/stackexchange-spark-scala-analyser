package io

import io.StackExchangeDataSchema.StackExchangeSchema.PostHistoryData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object PostHistoryXmlDataLoader {
  def loadPostHistoryDS(postXmlPath: String): Dataset[PostHistoryData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val postHistoryMappedColnames = Seq("PostHistoryID",
      "PostHistoryTypeId",
      "PostId",
      "RevisionGUID",
      "CreationDate",
      "UserId","UserDisplayName","Comment","Text","CloseReasonId")

    val commentRawDF = spark.read.option("rowTag", "posthistory").format("xml").load(postXmlPath)

    import spark.implicits._

    val postHistoryDataset: Dataset[PostHistoryData] = commentRawDF
      .select(explode(col("row")))
      .select("col._Id",
        "col._PostHistoryTypeId",
        "col._PostId",
        "col._RevisionGUID",
        "col._CreationDate",
        "col._UserId","col._UserDisplayName","col._Comment","col._Text"
        ,"col._CloseReasonId")
      .toDF(postHistoryMappedColnames: _*)
      .as[PostHistoryData]

    postHistoryDataset
  }
}
