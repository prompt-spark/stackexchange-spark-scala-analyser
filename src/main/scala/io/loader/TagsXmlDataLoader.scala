package io.loader

import io.ioSchema.StackExchangeInputSchema.TagsData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object TagsXmlDataLoader {
  def loadTagsDS(tagsXmlPath: String): Dataset[TagsData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val tagsRawDF = spark.read.option("rowTag", "tags").format("xml")
      .load(tagsXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structTagsDF = tagsRawDF.select("col.*")

    val renamedTagsDF = structTagsDF.toDF(
      structTagsDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    val tagsDataset: Dataset[TagsData] =
      renamedTagsDF
        .as[TagsData]

    tagsDataset
  }

}
