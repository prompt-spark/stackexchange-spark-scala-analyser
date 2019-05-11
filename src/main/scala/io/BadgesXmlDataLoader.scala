package io

import io.StackExchangeDataSchema.StackExchangeSchema.BadgeData
import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.SparkConf

object BadgesXmlDataLoader {

  def providerDS(badgeXmlPath: String): Dataset[BadgeData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val badgesRawDF =
      spark.read.option("rowTag", "badges").format("xml").load(badgeXmlPath)

    val badgeMappedColnames = Seq("UserId", "Name", "Class", "Date", "TagBased")

    import spark.implicits._

    val BadgeDataset: Dataset[BadgeData] = badgesRawDF
      .select(explode(col("row")))
      .select("col._UserId",
              "col._Name",
              "col._Class",
              "col._Date",
              "col._TagBased")
      .toDF(badgeMappedColnames: _*)
      .as[BadgeData]

    BadgeDataset
  }
}
