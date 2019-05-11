package com.java.apache.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/5/3.
  * 基数统计
  * 实现是基于HyperLogLog算法：
  *
  * 基数:一个集合不同值的数目 [a,b,c,d,a]的基数还是4
  */
object HyperLogLogTest {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val rdd = spark.sparkContext.parallelize(Array(("001", "tom"), ("001", "jim"),
      ("002", "lily"), ("002", "lucy"), ("002", "john"), ("002", "john")))
    rdd.map{x => (x._1, x._2)}.foreach(println)
    val x = rdd.map{row => (row._1, row._2)}.countApproxDistinctByKey(0.001)
    // (002,3)
    // (001,2)
    println("++++++++++++++++++")
    x.foreach(println)

  }
}
