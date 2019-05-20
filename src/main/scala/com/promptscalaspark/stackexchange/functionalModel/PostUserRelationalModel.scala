package com.promptscalaspark.stackexchange.functionalModel

import com.promptscalaspark.stackexchange.functionalModel.FunctionalModelSchema.userPostVotesCountData
import com.promptscalaspark.stackexchange.modeller.{PostsModeller, UserModeller}
import org.apache.spark.sql.{Dataset, Encoders}
import org.apache.spark.sql.functions._

trait PostUserRelationalModel {

  def userPostVotesCount(
      inputPath: String): Dataset[userPostVotesCountData] = {

    val postComments = PostsModeller
      .postComments(inputPath)
      .withColumnRenamed("postId", "commentsPostId")
      .cache()
    val userVotes = UserModeller
      .userCommentsVotes(inputPath)
      .withColumnRenamed("score", "commentsScore")
      .cache()

    val userPostVotesCountDs = postComments
      .join(userVotes, postComments.col("userId") === userVotes.col("userId"))
      .select("ownerUserId", "postId", "views", "reputation", "commentsScore")
      .groupBy("views", "reputation")
      .agg(count("postId"), count("ownerUserId"), max(col("commentsScore")))
      .withColumnRenamed("count(postId)", "countPostId")
      .withColumnRenamed("count(ownerUserId)", "countUserId")
      .withColumnRenamed("max(commentsScore)", "maxCommentsScore")

    userPostVotesCountDs.as[userPostVotesCountData](Encoders.product)
  }

}
