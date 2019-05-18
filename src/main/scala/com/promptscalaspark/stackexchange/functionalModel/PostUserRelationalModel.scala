package com.promptscalaspark.stackexchange.functionalModel

import com.promptscalaspark.stackexchange.modeller.PostsModeller

import scala.collection.parallel.immutable.ParVector

trait PostUserRelationalModel {

  def userModelProcessors(path: String): Unit = {

    //UserModeller.userBadges(path)
    //UserModeller.userCommentsVotes(path)
    //UserModeller.userPosts(path)
  }

  def postModelProcessors(inputPath: String, outputPath: String): Long = {

    val postComments = PostsModeller.postComments(inputPath).cache()
    val postHistory = PostsModeller.postHistory(inputPath).cache()
    val postLinks = PostsModeller.postLinks(inputPath).cache()
    val postVotes = PostsModeller.postVotes(inputPath).cache()

    val parVector = ParVector(
      (postComments, outputPath + "/Coments"),
      (postHistory, outputPath + "/History"),
      (postLinks, outputPath + "/Links"),
      (postVotes, outputPath + "/Votes")
    )

    parVector.foreach{
      case (data,out) => data.write.mode("overwrite").option("header", "true").json(out)
    }

    //DSWriter.parrallelWriter(parVector,outputPath,"parquet")

    postComments.count() +
      postHistory.count() +
      postLinks.count() +
      postVotes.count()
  }

}
