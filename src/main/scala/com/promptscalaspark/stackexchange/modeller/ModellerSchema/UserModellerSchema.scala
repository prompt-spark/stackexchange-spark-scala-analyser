package com.promptscalaspark.stackexchange.modeller.ModellerSchema

object UserModellerSchema {

  case class UserBadgesModelData(
      id: Long,
      userId: Long,
      badgeName: String,
      badgeDate: String,
      aboutMe: String,
      accountId: Long,
      creationDate: String,
      displayName: String,
      downVotes: Long,
      lastAccessDate: String,
      location: String,
      profileImageUrl: String,
      reputation: Long,
      upVotes: Long,
      value: String,
      websiteUrl: String
  )

  case class UserPostModeldata(
      id: Long,
      creationDate: String,
      displayName: String,
      downVotes: Long,
      userId: Long,
      location: String,
      reputation: Long,
      upVotes: Long,
      views: Long,
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      favoriteCount: Long,
      postId: Long,
      lastActivityDate: String,
      lastEditDate: String,
      lastEditorDisplayName: String,
      lastEditorUserId: Long,
      ownerDisplayName: String,
      ownerUserId: Long, //same as UserId
      parentId: Long,
      postTypeId: Long,
      score: Long,
      tags: String,
      title: String
  )

  case class UserCommentsVotesdata(
      id: Long,
      userId: Long,
      userDisplayName: String,
      postId: Long,
      text: String,
      score: Long,
      creationDate: String,
      aboutMe: String,
      accountId: Long,
      displayName: String,
      downVotes: Long,
      lastAccessDate: String,
      location: String,
      profileImageUrl: String,
      reputation: Long,
      upVotes: Long,
      vALUE: String,
      views: Long,
      websiteUrl: String
  )

}
