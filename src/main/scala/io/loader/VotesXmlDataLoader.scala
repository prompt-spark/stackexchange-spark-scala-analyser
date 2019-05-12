package io.loader

import io.StackExchangeIODataSchema.StackExchangeInputSchema.VotesData
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode}
import org.apache.spark.sql.{Dataset, SparkSession}

object VotesXmlDataLoader {
  def loadVotesDS(votesXmlPath: String): Dataset[VotesData] = {

    val sparkConf = new SparkConf()
      .setAppName("stackExchange-spark-analyzer")
      .set("spark.driver.allowMultipleContexts", "true")

    val spark =
      SparkSession
        .builder()
        .config(sparkConf)
        .master("local[*]")
        .getOrCreate()

    val votesRawDF = spark.read.option("rowTag", "votes").format("xml")
      .load(votesXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structVotesDF = votesRawDF.select("col.*")

    val renamedVotesDF = structVotesDF.toDF(
      structVotesDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    val votesDataset: Dataset[VotesData] =
      renamedVotesDF
        .as[VotesData]

    votesDataset
  }

}
