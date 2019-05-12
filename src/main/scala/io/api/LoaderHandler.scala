package io.api

import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.{col, lit}

object LoaderHandler {

  def colMatcher(optionalCols: Set[String], mainDFCols: Set[String]): List[Column] = {
    mainDFCols.toList.map {
      case x if optionalCols.contains(x) => col(x)
      case x => lit(null).as(x)
    }
  }

}
