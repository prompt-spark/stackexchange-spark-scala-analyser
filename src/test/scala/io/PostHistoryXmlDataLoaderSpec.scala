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
        .loadPostHistoryDS(
          "/home/xargus/Documents/stackexchange-me/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/PostHistory.xml")
        .columns
        .length shouldBe 11
    }
  }
}
