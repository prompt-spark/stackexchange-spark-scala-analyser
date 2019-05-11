package io

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object UsersXmlDataLoader {
  def main(usersXmlPath: String): DataFrame = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    spark.read.option("rowTag", "users").format("xml").load(usersXmlPath)

  }
}
