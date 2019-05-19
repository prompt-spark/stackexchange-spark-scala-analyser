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

package com.promptscalaspark.stackexchange.modeller

import com.promptscalaspark.stackexchange.io.loader.{
  BadgesXmlDataLoader,
  CommentsXmlDataLoader,
  PostXmlDataLoader,
  UsersXmlDataLoader,
  VotesXmlDataLoader
}
import com.promptscalaspark.stackexchange.modeller.ModellerSchema.UserModellerSchema.{
  UserBadgesModelData,
  UserCommentsVotesModelData,
  UserPostModeldata
}
import org.apache.spark.sql.functions.monotonically_increasing_id
import org.apache.spark.sql.{Dataset, Encoders}

object UserModeller {

  def userBadges(path: String): Dataset[UserBadgesModelData] = {

    val user = UsersXmlDataLoader.loadUsersDS(path)
    val badges = BadgesXmlDataLoader.loadBadgeDS(path)

    val userBadgeJoinedDF = user.join(badges,
                                      user.col("Id") ===
                                        badges.col("userId"))

    userBadgeJoinedDF.as[UserBadgesModelData](Encoders.product).cache()

  }

  def userPosts(path: String): Dataset[UserPostModeldata] = {

    val user = UsersXmlDataLoader.loadUsersDS(path)
    val posts =
      PostXmlDataLoader.loadPostDS(path).withColumnRenamed("id", "postId")

    val userPostsJoinedDF = user
      .join(posts,
            user.col("Id") ===
              posts.col("ownerUserId"))
      .drop("Id", "creationDate")
      .withColumn("Id", monotonically_increasing_id)

    userPostsJoinedDF.as[UserPostModeldata](Encoders.product).cache()

  }

  def userCommentsVotes(path: String): Dataset[UserCommentsVotesModelData] = {

    val user = UsersXmlDataLoader.loadUsersDS(path)
    val comments = CommentsXmlDataLoader.loadCommentsDS(path)
    val votes = VotesXmlDataLoader.loadVotesDS(path)

    val userCommentsJoinedDF =
      user.join(comments, comments.col("userId") === user.col("id"))
      .drop("userId","postId")

    val userCommentsVotesJoinedDF =
      votes.join(userCommentsJoinedDF,
                 userCommentsJoinedDF.col("id") === votes.col("userId"))
        .drop("Id", "creationDate")
        .withColumn("Id", monotonically_increasing_id)

    userCommentsVotesJoinedDF.as[UserCommentsVotesModelData](Encoders.product).cache()
  }

}
