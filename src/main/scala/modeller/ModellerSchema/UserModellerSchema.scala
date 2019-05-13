package modeller.ModellerSchema

object UserModellerSchema {

  case class UserBadgesModelData(
      Id: Long,
      UserId: Long,
      BadgeName: String,
      BadgeDate: String,
      AboutMe: String,
      AccountId: Long,
      CreationDate: String,
      DisplayName: String,
      DownVotes: Long,
      LastAccessDate: String,
      Location: String,
      ProfileImageUrl: String,
      Reputation: Long,
      UpVotes: Long,
      VALUE: String,
      WebsiteUrl: String
  )

  case class UserPostModeldata(
      Id: Long,
      CreationDate: String,
      DisplayName: String,
      DownVotes: Long,
      UserId: Long,
      Location: String,
      Reputation: Long,
      UpVotes: Long,
      Views: Long,
      AcceptedAnswerId: Long,
      AnswerCount: Long,
      Body: String,
      ClosedDate: String,
      CommentCount: Long,
      CommunityOwnedDate: String,
      FavoriteCount: Long,
      PostId: Long,
      LastActivityDate: String,
      LastEditDate: String,
      LastEditorDisplayName: String,
      LastEditorUserId: Long,
      OwnerDisplayName: String,
      OwnerUserId: Long, //same as UserId
      ParentId: Long,
      PostTypeId: Long,
      Score: Long,
      Tags: String,
      Title: String
  )

  case class UserCommentsVotesdata(
      Id: Long,
      UserId: Long,
      UserDisplayName: String,
      PostId: Long,
      Text: String,
      Score: Long,
      CreationDate: String,
      AboutMe: String,
      AccountId: Long,
      DisplayName: String,
      DownVotes: Long,
      LastAccessDate: String,
      Location: String,
      ProfileImageUrl: String,
      Reputation: Long,
      UpVotes: Long,
      VALUE: String,
      Views: Long,
      WebsiteUrl: String
  )

}
