package jobs

import io.ioSchema.StackExchangeInputSchema
import org.apache.hadoop.fs.Path
import modeller.{PostsModeller, UserModeller}
import org.apache.spark.sql.Dataset

trait JobsMediator {
  def userModelProcessors(path: String)= {

    UserModeller.userBadges(path)
    UserModeller.userCommentsVotes(path)
    UserModeller.userPosts(path)
  }

  def postModelProcessors(path: String)= {

    PostsModeller.postComments(path)
    PostsModeller.postHistory(path)
    PostsModeller.postLinks(path)
    PostsModeller.postVotes(path)
  }
}
