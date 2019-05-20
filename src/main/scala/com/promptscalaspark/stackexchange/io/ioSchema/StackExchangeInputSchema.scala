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

package com.promptscalaspark.stackexchange.io.ioSchema

object StackExchangeInputSchema {

  case class BadgeData(userId: Long, name: String, date: String)

  case class CommentsData(userId: Long,
                          userDisplayName: String,
                          postId: Long,
                          text: String,
                          score: Long,
                          creationDate: String)

  case class PostHistoryData(
      postHistoryTypeId: Long,
      id: Long,
      revisionGUID: String,
      creationDate: String,
      userId: Long,
      userDisplayName: String,
      comment: Option[String],
      text: String,
      postId: Long,
      value: String,
      closeReasonId: Option[String]
  )

  case class PostLinksData(
      creationDate: String,
      id: Long,
      linkTypeId: Long,
      postId: Long,
      relatedPostId: Long,
      value: String
  )

  case class VotesData(
      bountyAmount: Option[Long],
      creationDate: String,
      id: Long,
      postId: Long,
      userId: Option[Long],
      value: String,
      voteTypeId: Long
  )

  case class UsersData(
      aboutMe: String,
      accountId: Long,
      creationDate: String,
      displayName: String,
      downVotes: Long,
      id: Long,
      lastAccessDate: String,
      location: String,
      profileImageUrl: String,
      reputation: Long,
      upVotes: Long,
      value: String,
      views: Long,
      websiteUrl: String
  )

  case class TagsData(
      count: Long,
      excerptPostId: Long,
      id: Long,
      tagName: String,
      value: String,
      wikiPostId: Long
  )

  case class PostData(
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      creationDate: String,
      favoriteCount: Long,
      id: Long,
      lastActivityDate: String,
      lastEditDate: String,
      lastEditorDisplayName: String,
      lastEditorUserId: Long,
      ownerDisplayName: String,
      ownerUserId: Long,
      parentId: Long,
      postTypeId: Long,
      score: Long,
      tags: String,
      title: String,
      value: String,
      viewCount: Long
  )

}
