package io.StackExchangeDataSchema

object StackExchangeSchema {

  case class BadgeData(UserId: Long,
                       Name: String,
                       Date: String)

  case class CommentsData(UserId: Long,
                          UserDisplayName: String,
                          PostId: Long,
                          Text: String,
                          Score: Long,
                          CreationDate: String)

  case class PostHistoryData(
                          PostHistoryID:Long,
                          PostHistoryTypeId:Long,
                          PostId: Long,
                          RevisionGUID: String,
                          CreationDate: String,
                          UserId: Long,
                          UserDisplayName: String,
                          Comment: Option[String],
                          Text: String,
                          CloseReasonId:Option[String]
                        )

}
