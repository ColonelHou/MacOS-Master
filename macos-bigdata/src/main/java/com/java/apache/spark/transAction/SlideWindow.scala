package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Duration, Minutes, Seconds, StreamingContext}

/**
  * Created by colonelhou on 2019/4/26.
  */
object SlideWindow {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().appName("Streaming").master("local[5]").getOrCreate()
    val sc = sparksession.sparkContext
    val ssc = new StreamingContext(sc, Seconds(5))
    // 保存二天
    ssc.remember(Minutes(60 * 48))
    val lines = ssc.socketTextStream("localhost", 9999)

    val words = lines.flatMap(_.split(" ")).map(x => (x, 1)).
      reduceByKeyAndWindow((x :Int, y :Int) => x + y, Duration(1000 * 60), Duration(1000 * 10))
    words.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
