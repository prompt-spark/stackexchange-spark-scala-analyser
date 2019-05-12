package io.loader

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class TagsXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      TagsXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/Tags.xml")
        .columns
        .length shouldBe 1
    }
  }
}
