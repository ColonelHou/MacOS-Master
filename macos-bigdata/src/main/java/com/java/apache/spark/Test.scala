package com.java.apache.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/25.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    val rdd1 = spark.sparkContext.makeRDD(1 to 5, 5)
    val df = spark.emptyDataFrame;
    rdd1.collect()
    rdd1.foreach(println)
    println(rdd1.partitions.size)
  }

}
