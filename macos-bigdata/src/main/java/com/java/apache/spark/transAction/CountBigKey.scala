package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

import scala.util.Random

/**
  * Created by colonelhou on 2019/4/27.
  * 单词个数统计的数据倾斜解决办法:
  * 1. 第一步 map使用随时数
  * 2. 第二步 聚合
  * 3. 第三步 去掉前缀随机数 再 聚合
  *
  * https://www.cnblogs.com/tongxupeng/p/10259553.html
  */
object CountBigKey {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().appName("聚合key分区不均")
      .master("local[2]").getOrCreate()
    val sc = sparkSession.sparkContext
    sc.setLogLevel("ERROR")
//    sc.setLogLevel("DEBUG")
    val data = sc.parallelize(List("hello", "hello", "hello", "hello", "hello", "hello", "hello", "hello", "hello", "abc", "hello"), 2)
//    val rdd = data.flatMap(_.split("\n")).map((_, 1)).partitionBy(new MyPartitioner)
    val rdd = data.flatMap(_.split("\n")).map(x => (Random.nextInt(5) + "_" + x, 1))
    val cnt = rdd.reduceByKey(_+_)

    ////////////////////
    ////////////////////


    val xx = cnt.map(x => {
      val word = x._1
      val cnt = x._2
      val old = word.split("_")(1)
      (old, cnt)
    }).reduceByKey(_+_)
//    rdd.foreach(println)
    println(cnt.toString())
    println("++++++++++++++++++++++++")
    xx.foreach(println)

    Thread.sleep(1000 * 60 * 5)

  }
}
