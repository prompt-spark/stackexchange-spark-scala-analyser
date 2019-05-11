package org

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, Suite}

trait SparkSpec extends BeforeAndAfterAll {
  this: Suite =>

  private var _sc: SparkContext = _

  override def beforeAll(): Unit = {
    super.beforeAll()

    val conf = new SparkConf()
      .setMaster("local[*]")
      .setAppName(this.getClass.getSimpleName)

    sparkConfig.foreach { case (k, v) => conf.setIfMissing(k, v) }

    _sc = new SparkContext(conf)
  }

  def sparkConfig: Map[String, String] = Map.empty

  override def afterAll(): Unit = {
    if (_sc != null) {
      _sc.stop()
      _sc = null
    }
    super.afterAll()
  }

  def sc: SparkContext = _sc

}
