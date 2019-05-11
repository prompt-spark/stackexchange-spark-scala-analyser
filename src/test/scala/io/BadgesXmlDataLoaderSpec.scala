package io

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
        .providerDS(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/*/Badges.xml")
        .columns
        .length shouldBe 5
    }
  }
}
