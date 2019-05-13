package io.modeller

import modeller.PostsModeller
import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class PostsModellerSpec
  extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      PostsModeller
        .postHistory(
          "/home/xargus/Documents/stackexchange-me/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/Users.xml")
        .columns
        .length shouldBe 14
    }
  }
}
