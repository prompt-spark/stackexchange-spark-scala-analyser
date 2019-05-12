package io

import io.StackExchangeDataSchema.StackExchangeSchema.PostHistoryData

import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, explode, lit}
import org.apache.spark.sql.{Column, Dataset, SparkSession}

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
        .select(colMatcher(renamedCommentDFCols, unionCols): _*)
        .union(optionalColumnDF.select(colMatcher(optionalColumnCols, unionCols): _*))
        .as[PostHistoryData]

    postHistoryDataset
  }


  def colMatcher(optionalCols: Set[String], mainDFCols: Set[String]): List[Column] = {
    mainDFCols.toList.map {
      case x if optionalCols.contains(x) => col(x)
      case x => lit(null).as(x)
    }
  }


}
