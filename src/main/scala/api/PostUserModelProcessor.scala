package api

import io.writer.DSWriter
import io.writer.DSWriter.writeJson
import modeller.ModellerSchema.PostsModellerSchema
import modeller.{PostsModeller, UserModeller}
import org.apache.spark.sql.Dataset

import scala.collection.parallel.immutable.ParVector

trait PostUserModelProcessor {

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
