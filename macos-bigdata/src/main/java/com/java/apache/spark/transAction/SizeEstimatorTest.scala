package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/3.
  */

import org.apache.spark.sql.SparkSession
import org.apache.spark.util.SizeEstimator
case class Stu(id:Int, name:String)
object SizeEstimatorTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SizeEstimatorTest").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val u1 = Stu(123, "jim")
    val u2 = Stu(123, "jim")
    val u3 = Stu(123, "jim")
    val u4 = Stu(123, "jim")
    val list = List(u1, u2, u3, u4)
    val rdd = spark.sparkContext.parallelize(list, 2)
    import spark.implicits._
    val size: Long = SizeEstimator.estimate(rdd.toDF())
    println(size)

  }
}
