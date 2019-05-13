/*
 * Copyright © 2019 Abhishek Verma (abhishekv3007@gmail.com)
 *
 *                    GNU AFFERO GENERAL PUBLIC LICENSE
 *                       Version 3, 19 November 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *                            Preamble
 *
 *   The GNU Affero General Public License is a free, copyleft license for
 * software and other kinds of works, specifically designed to ensure
 * cooperation with the community in the case of network server software.
 *
 *   The licenses for most software and other practical works are designed
 * to take away your freedom to share and change the works.  By contrast,
 * our General Public Licenses are intended to guarantee your freedom to
 * share and change all versions of a program--to make sure it remains free
 * software for all its users.
 */

package io.ioSchema

object StackExchangeInputSchema {

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
                              PostHistoryTypeId: Long,
                              Id: Long,
                              RevisionGUID: String,
                              CreationDate: String,
                              UserId: Long,
                              UserDisplayName: String,
                              Comment: Option[String],
                              Text: String,
                              PostId: Long,
                              VALUE: String,
                              CloseReasonId: Option[String]
                            )

  case class PostLinksData(
                            CreationDate: String,
                            Id: Long,
                            LinkTypeId: Long,
                            PostId: Long,
                            RelatedPostId: Long,
                            VALUE: String
                          )

  case class VotesData(
                        BountyAmount: Option[Long],
                        CreationDate: String,
                        Id: Long,
                        PostId: Long,
                        UserId: Option[Long],
                        VALUE: String,
                        VoteTypeId: Long
                      )

  case class UsersData(
                        AboutMe: String,
                        AccountId: Long,
                        CreationDate: String,
                        DisplayName: String,
                        DownVotes: Long,
                        Id: Long,
                        LastAccessDate: String,
                        Location: String,
                        ProfileImageUrl: String,
                        Reputation: Long,
                        UpVotes: Long,
                        VALUE: String,
                        Views: Long,
                        WebsiteUrl: String
                      )

  case class TagsData(
                       Count: Long,
                       ExcerptPostId: Long,
                       Id: Long,
                       TagName: String,
                       VALUE: String,
                       WikiPostId: Long
                     )

  case class PostData(
                       AcceptedAnswerId: Long ,
                       AnswerCount: Long ,
                       Body: String ,
                       ClosedDate: String ,
                       CommentCount: Long ,
                       CommunityOwnedDate: String ,
                       CreationDate: String ,
                       FavoriteCount: Long ,
                       Id: Long ,
                       LastActivityDate: String ,
                       LastEditDate: String ,
                       LastEditorDisplayName: String ,
                       LastEditorUserId: Long ,
                       OwnerDisplayName: String ,
                       OwnerUserId: Long ,
                       ParentId: Long ,
                       PostTypeId: Long ,
                       Score: Long ,
                       Tags: String ,
                       Title: String ,
                       VALUE: String ,
                       ViewCount: Long
                     )

}
