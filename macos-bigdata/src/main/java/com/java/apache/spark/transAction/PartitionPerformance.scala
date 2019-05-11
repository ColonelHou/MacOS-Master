package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/27.
  * https://www.iteblog.com/archives/1695.html
  */
object PartitionPerformance {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().master("local[2]")
      .appName("通过分区(Partitioning)提高Spark的运行性能")
      .getOrCreate()
    val sc = sparkSession.sparkContext
    sc.setLogLevel("ERROR")
    val n = 10
    val composite = sc.parallelize(2 to n, 8)
      .map(x => (x, (2 to (n / x)))) // {(2 -> {2 to 5}), (3 -> 2 to 3)}
//      .flatMap(kv => kv._2.map(_ * kv._1))

    composite.foreach(println)
//    val prime = sc.parallelize(2 to n, 8).subtract(composite)
//    prime.foreach(println)
  }

}
