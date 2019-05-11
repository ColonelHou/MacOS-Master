package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}

/**
  * Created by colonelhou on 2019/4/26.
  * 滑动窗口, 每隔10秒统计最近60秒的搜索url
  */
object Streaming {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().appName("Streaming").master("local[5]").getOrCreate()
    val sc = sparksession.sparkContext
    val ssc = new StreamingContext(sc, Seconds(5))
    // 保存二天
    ssc.remember(Minutes(60 * 48))
    val lines = ssc.socketTextStream("localhost", 9999)

    val words = lines.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    words.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
