package io

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object VotesXmlDataLoader {
  def main(votesXmlPath: String): DataFrame = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    spark.read.option("rowTag", "votes").format("xml").load(votesXmlPath)

  }
}
