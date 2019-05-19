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

package com.promptscalaspark.stackexchange.modeller.ModellerSchema

object PostsModellerSchema {

  case class PostHistoryModelData(
      id: Long,
      postId: Long,
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      favoriteCount: Long,
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
      viewCount: Long,
      postHistoryTypeId: Long,
      revisionGUID: String,
      userId: Long,
      userDisplayName: String,
      comment: Option[String],
      text: String,
      closeReasonId: Option[String],
      creationDate: String
  )

  case class PostLinksModelData(
      id: Long,
      linkTypeId: Long,
      postId: Long,
      relatedPostId: Long,
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      creationDate: String,
      favoriteCount: Long,
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
      viewCount: Long
  )

  case class PostCommentsModelData(
      id: Long,
      userId: Long,
      userDisplayName: String,
      postId: Long,
      text: String,
      commentScore: Long,
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      creationDate: String,
      favoriteCount: Long,
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

  case class PostVotesModelData(
      id: Long,
      bountyAmount: Option[Long],
      postId: Long,
      userId: Option[Long],
      voteTypeId: Long,
      acceptedAnswerId: Long,
      answerCount: Long,
      body: String,
      closedDate: String,
      commentCount: Long,
      communityOwnedDate: String,
      creationDate: String,
      favoriteCount: Long,
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
      viewCount: Long
  )

}
