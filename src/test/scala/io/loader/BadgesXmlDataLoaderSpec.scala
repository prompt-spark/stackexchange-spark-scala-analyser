package io.loader

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class BadgesXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      BadgesXmlDataLoader
        .loadBadgeDS(
          "/home/xargus/Documents/stackexchange-me/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/Badges.xml")
        .columns
        .length shouldBe 3
    }
  }
}
