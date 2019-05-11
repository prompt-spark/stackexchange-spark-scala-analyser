package io

import org.SparkSpec
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

class UsersXmlDataLoaderSpec
    extends FunSpec
    with SparkSpec
    with GivenWhenThen
    with Matchers {

  describe("Column Numbers") {

    it("should check all the column numbers") {
      UsersXmlDataLoader
        .main(
          "/home/xargus/Documents/MyGit/sparkProj/src/main/resources/data/Users.xml")
        .columns
        .length shouldBe 1
    }
  }
}
