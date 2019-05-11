package com.java.apache.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/22.
  * 倒排索引实现
  */
object NewAddUserOfMonthDemo {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val rdd1 = spark.sparkContext.parallelize(
      Array(
        ("2017-01-01", "a"), ("2017-01-01", "b"), ("2017-01-01", "c"),
        ("2017-01-02", "a"), ("2017-01-02", "b"), ("2017-01-02", "d"),
        ("2017-01-03", "b"), ("2017-01-03", "e"), ("2017-01-03", "f")))
    //倒排
    val rdd2 = rdd1.map(kv => (kv._2, kv._1))
    rdd2.foreach(println)
    println("---------------")
    //倒排后的key分组
    val rdd3 = rdd2.groupByKey()
    rdd3.foreach(println)
    println("---------------")
    //取最小时间
    val rdd4 = rdd3.map(kv => (kv._2.min, kv._1))
    rdd4.foreach(println)
    println("++++++++++每日新增用户列表") // (2017-01-01,CompactBuffer(a, b, c))
    rdd4.groupByKey().foreach(println)
    println("---------------")
    rdd4.countByKey().foreach(println)
  }

}
