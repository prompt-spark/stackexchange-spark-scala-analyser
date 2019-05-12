package io.loader

import io.StackExchangeIODataSchema.StackExchangeInputSchema.PostData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object PostXmlDataLoader {
  def loadPostDS(postXmlPath: String): Dataset[PostData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val postRawDF = spark.read.option("rowTag", "posts").format("xml")
      .load(postXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structPostRawDF = postRawDF.select("col.*")

    val renamedPostDF = structPostRawDF.toDF(
      structPostRawDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    val postDataset: Dataset[PostData] =
      renamedPostDF
      .as[PostData]

    postDataset
  }

}
