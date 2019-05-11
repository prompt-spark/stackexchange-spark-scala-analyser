package io

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class PostLinksXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      PostLinksXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/PostLinks.xml")
        .columns
        .length shouldBe 1
    }
  }
}
