package api

import io.writer.DSWriter
import modeller.{PostsModeller, UserModeller}

trait JobsMediator {
  def userModelProcessors(path: String) = {

    //UserModeller.userBadges(path)
    //UserModeller.userCommentsVotes(path)
    //UserModeller.userPosts(path)
  }

  def postModelProcessors(inputPath: String, outputPath: String): Long = {

    val postComments = PostsModeller.postComments(inputPath).cache()
    val postHistory = PostsModeller.postHistory(inputPath).cache()
    val postLinks = PostsModeller.postLinks(inputPath).cache()
    val postVotes = PostsModeller.postVotes(inputPath).cache()

    DSWriter.writeJson(postComments, outputPath + "/Coments")
    DSWriter.writeJson(postHistory, outputPath + "/History")
    DSWriter.writeJson(postLinks, outputPath + "/Links")
    DSWriter.writeJson(postVotes, outputPath + "/Votes")

    postComments.count() + postHistory.count() + postLinks.count() + postVotes
      .count()
  }
}
