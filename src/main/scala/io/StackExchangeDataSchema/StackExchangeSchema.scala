package io.StackExchangeDataSchema

object StackExchangeSchema {

  case class BadgeData(UserId: Long,
                       Name: String,
                       Class: Long,
                       Date: String,
                       TagBased: Boolean)

  case class CommentsData(UserId: Long,
                          UserDisplayName: String,
                          PostId: Long,
                          Text: String,
                          Score: Long,
                          CreationDate: String)

}
