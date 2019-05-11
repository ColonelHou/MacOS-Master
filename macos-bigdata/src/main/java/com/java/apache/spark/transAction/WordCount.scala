package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/7.
  */

import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("WordCount").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val sc = spark.sparkContext
    val rdd = sc.parallelize(List("my name is colonel", "what's your name ?", "how are you"))
    def add(x: Int, y: Int) : Int = x + y
    val x = rdd.flatMap(_.split("\\s+")).map(x => (x, 1)).reduceByKey(add)
    x.collect().map( x => {
      println(x._1 + " ---> " + x._2)
    })
  }
}
