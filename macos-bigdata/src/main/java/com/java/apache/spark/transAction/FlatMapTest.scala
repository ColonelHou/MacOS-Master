package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/7.
  */

import org.apache.spark.sql.SparkSession

object FlatMapTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("FlatMapTest").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val sc = spark.sparkContext
    val rdd = sc.parallelize(List("hello world", "my name is colonel"), 2)
    // +++++++++hello world
    // +++++++++my name is colonel
    rdd.flatMap(p => {
      println("+++++++++" + p.toString)
      p
    }).count()
  }
}
