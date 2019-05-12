package io.loader

import io.StackExchangeIODataSchema.StackExchangeInputSchema.PostHistoryData
import io.api.LoaderHandler
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

    val commentRawDF = spark.read.option("rowTag", "posthistory").format("xml")
      .load(postXmlPath).select(explode(col("row")))

    import spark.implicits._
    val structCommentRawDF = commentRawDF.select("col.*")

    val renamedCommentDF = structCommentRawDF.toDF(
      structCommentRawDF
        .columns
        .map(x => x.replaceAll("_", "")): _*)

    val optionalColumnDF = spark.sparkContext.parallelize(List("option-default-value"
    )).toDF("CloseReasonId")
    //CloseReasonId="test-field"

    val renamedCommentDFCols = renamedCommentDF.columns.toSet
    val optionalColumnCols = optionalColumnDF.columns.toSet

    val unionCols = renamedCommentDFCols ++ optionalColumnCols

    val postHistoryDataset: Dataset[PostHistoryData] =
      renamedCommentDF
        .select(LoaderHandler.colMatcher(renamedCommentDFCols, unionCols): _*)
        .union(optionalColumnDF.select(LoaderHandler.colMatcher(optionalColumnCols, unionCols): _*))
        .as[PostHistoryData]

    //postHistoryDataset.select(countDistinct("CloseReasonId")).show()
    postHistoryDataset
  }




}
