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
        .loadTagsDS(
          "/home/xargus/Documents/stackexchange-me/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/Tags.xml")
        .columns
        .length shouldBe 6
    }
  }
}
