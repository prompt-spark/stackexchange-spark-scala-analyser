package api

import modeller.{PostsModeller, UserModeller}

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
