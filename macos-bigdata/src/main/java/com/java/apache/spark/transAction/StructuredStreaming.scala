package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/26.
  */
object StructuredStreaming {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("StructuredNetworkWordCount").master("local[2]")
      .getOrCreate()
    import spark.implicits._

    val lines = spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()
    val words = lines.as[String].flatMap(_.split(" "))
    val wordCounts = words.groupBy("value").count()
    println(wordCounts.count())
    val query = wordCounts.writeStream.outputMode("complete").format("console").start()
    query.awaitTermination()

  }
}
