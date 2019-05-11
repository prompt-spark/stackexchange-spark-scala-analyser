package io

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class VotesXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      VotesXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/Votes.xml")
        .columns
        .length shouldBe 1
    }
  }
}
