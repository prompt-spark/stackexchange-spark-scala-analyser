package io

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class CommentsXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      CommentsXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/Comments.xml")
        .columns
        .length shouldBe 6
    }
  }
}
