package io.loader

import io.StackExchangeIODataSchema.StackExchangeInputSchema.UsersData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object UsersXmlDataLoader {
  def loadUsersDS(usersXmlPath: String): Dataset[UsersData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val usersRawDF = spark.read.option("rowTag", "users").format("xml")
      .load(usersXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structUsersDF = usersRawDF.select("col.*")

    val renamedUsersDF = structUsersDF.toDF(
      structUsersDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    val usersDataset: Dataset[UsersData] =
      renamedUsersDF
        .as[UsersData]

    usersDataset
  }

}
