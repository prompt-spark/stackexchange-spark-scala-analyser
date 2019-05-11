package io

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class PostHistoryXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      PostHistoryXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/PostHistory.xml")
        .columns
        .length shouldBe 1
    }
  }
}
