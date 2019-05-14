package api

import modeller.{PostsModeller, UserModeller}

trait JobsMediator {
  def userModelProcessors(path: String)= {

    //UserModeller.userBadges(path)
    //UserModeller.userCommentsVotes(path)
    //UserModeller.userPosts(path)
  }

  def postModelProcessors(path: String): Long = {

   val postComments = PostsModeller.postComments(path).cache()
    val postHistory= PostsModeller.postHistory(path)
    val postLinks=PostsModeller.postLinks(path)
    val postVotes= PostsModeller.postVotes(path)

    postComments.count()+postHistory.count()+postLinks.count()+postVotes.count()
  }
}
