package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/6.
  */

import org.apache.spark.sql.SparkSession

object ActiveUserWeek {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("ActiveUserWeek").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val rdd = spark.sparkContext.parallelize(List(
      ("20190506", "iteblog"),
      ("20190507", "iteblog"),
      ("20190508", "iteblog"),
      ("20190508", "iteblog"),
      ("20190506", "very")
    ))
    // (iteblog,3)
    // (very,1)
    rdd.map(x => (x._2, x._1)).countApproxDistinctByKey(0.0001).foreach(println) // .map(x => (x, 1)).reduceByKey(_+_).foreach(println)
    rdd.map(x => (x._2, x._1)).countApproxDistinctByKey(0.0001).filter(x => x._2>2).foreach(println)
    Thread.sleep(100000)
  }
}
