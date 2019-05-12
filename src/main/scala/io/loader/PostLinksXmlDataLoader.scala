package io.loader

import io.StackExchangeIODataSchema.StackExchangeInputSchema.PostLinksData
import io.api.LoaderHandler
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object PostLinksXmlDataLoader {
  def loadPostLinksDS(postXmlPath: String): Dataset[PostLinksData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val postLinksRawDF = spark.read.option("rowTag", "postlinks").format("xml")
      .load(postXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structPostLinksDF = postLinksRawDF.select("col.*")

    val renamedPostLinksDF = structPostLinksDF.toDF(
      structPostLinksDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    renamedPostLinksDF.printSchema()

    val postLinksDataset: Dataset[PostLinksData] =
      renamedPostLinksDF
        .as[PostLinksData]

    postLinksDataset
  }




}
