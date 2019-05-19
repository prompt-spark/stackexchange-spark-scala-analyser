package com.promptscalaspark.stackexchange.functionalModel

import com.promptscalaspark.stackexchange.modeller.{PostsModeller, UserModeller}
import org.apache.spark.sql.functions._
import scala.collection.parallel.immutable.ParVector

trait PostUserRelationalModel {

  def userPostVotes(inputPath: String, outputPath: String): Long = {

    val postComments = PostsModeller
      .postComments(inputPath)
      .withColumnRenamed("postId", "commentsPostId")
      .cache()
    val userVotes = UserModeller.userCommentsVotes(inputPath).withColumnRenamed("score", "commentsScore").cache()

    val userPostVotesDs = postComments
      .join(userVotes, postComments.col("userId") === userVotes.col("userId"))
      .select("ownerUserId",
              "postId",
              "views",
              "reputation","commentsScore")
      .groupBy("views","reputation").agg(count("postId")
      ,count("ownerUserId"),max(col("commentsScore")))

    val parVector = ParVector(
      (userPostVotesDs, outputPath + "/userPostVotes"))


    parVector.foreach {
      case (data, out) =>
        data.coalesce(2).write.mode("overwrite").option("header", "true").json(out)
    }

    userPostVotesDs.columns.length
  }

}
