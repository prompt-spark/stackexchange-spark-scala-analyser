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

package modeller

object modellerSchema {


  case class PostHistoryModelData(
                                   Id: Long,
                                   PostId: Long,
                                   AcceptedAnswerId: Long,
                                   AnswerCount: Long,
                                   Body: String,
                                   ClosedDate: String,
                                   CommentCount: Long,
                                   CommunityOwnedDate: String,
                                   FavoriteCount: Long,
                                   LastActivityDate: String,
                                   LastEditDate: String,
                                   LastEditorDisplayName: String,
                                   LastEditorUserId: Long,
                                   OwnerDisplayName: String,
                                   OwnerUserId: Long,
                                   ParentId: Long,
                                   PostTypeId: Long,
                                   Score: Long,
                                   Tags: String,
                                   Title: String,
                                   ViewCount: Long,
                                   PostHistoryTypeId: Long,
                                   RevisionGUID: String,
                                   UserId: Long,
                                   UserDisplayName: String,
                                   Comment: Option[String],
                                   Text: String,
                                   CloseReasonId: Option[String],
                                   CreationDate: String
                                 )


  case class PostlinksModeller(
                                Id: Long,
                                LinkTypeId: Long,
                                PostId: Long,
                                RelatedPostId: Long,
                                AcceptedAnswerId: Long,
                                AnswerCount: Long,
                                Body: String,
                                ClosedDate: String,
                                CommentCount: Long,
                                CommunityOwnedDate: String,
                                CreationDate: String,
                                FavoriteCount: Long,
                                LastActivityDate: String,
                                LastEditDate: String,
                                LastEditorDisplayName: String,
                                LastEditorUserId: Long,
                                OwnerDisplayName: String,
                                OwnerUserId: Long,
                                ParentId: Long,
                                PostTypeId: Long,
                                Score: Long,
                                Tags: String,
                                Title: String,
                                VALUE: String,
                                ViewCount: Long
                              )

  case class PostCommentsModelData(
                                  Id:Long,
                                    UserId: Long,
                                    UserDisplayName: String,
                                    PostId: Long,
                                    Text: String,
                                    CommentsScore: Long,
                                    CommentsCreationDate: String,
                                    AcceptedAnswerId: Long,
                                    AnswerCount: Long,
                                    Body: String,
                                    ClosedDate: String,
                                    CommentCount: Long,
                                    CommunityOwnedDate: String,
                                    CreationDate: String,
                                    FavoriteCount: Long,
                                    LastActivityDate: String,
                                    LastEditDate: String,
                                    LastEditorDisplayName: String,
                                    LastEditorUserId: Long,
                                    OwnerDisplayName: String,
                                    OwnerUserId: Long,
                                    ParentId: Long,
                                    PostTypeId: Long,
                                    Score: Long,
                                    Tags: String,
                                    Title: String,
                                    VALUE: String,
                                    ViewCount: Long
                                  )

  case class PostVotesModelData(
                                 Id: Long,
                                 BountyAmount: Option[Long],
                                 PostId: Long,
                                 UserId: Option[Long],
                                 VoteTypeId: Long,
                                 AcceptedAnswerId: Long,
                                 AnswerCount: Long,
                                 Body: String,
                                 ClosedDate: String,
                                 CommentCount: Long,
                                 CommunityOwnedDate: String,
                                 CreationDate: String,
                                 FavoriteCount: Long,
                                 LastActivityDate: String,
                                 LastEditDate: String,
                                 LastEditorDisplayName: String,
                                 LastEditorUserId: Long,
                                 OwnerDisplayName: String,
                                 OwnerUserId: Long,
                                 ParentId: Long,
                                 PostTypeId: Long,
                                 Score: Long,
                                 Tags: String,
                                 Title: String,
                                 ViewCount: Long
                               )

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
                                    Id:Long,
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
