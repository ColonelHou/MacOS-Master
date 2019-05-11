package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/7.
  */

import java.util.Random

import org.apache.spark.sql.SparkSession

/**
  * 100个map
  * 每个map生成10000个数字的数组,
  * reducebykey 最终还是100
  *
  * 生成 1000MB的数据
  */
object GroupByTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GroupByTest").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val sc = spark.sparkContext
    var numMappers = 100
    var numKVPairs = 10000
    var valSize = 1000
    var numReducers = 36


    val rdd = sc.parallelize(0 until numMappers, numMappers)
    val rdd1 = rdd.flatMap { p =>
      val ranGen = new Random()
      var arr1 = new Array[(Int, Array[Byte])](numKVPairs) // 一万个
      println("++++++++++++" + p.toString())
      for (i <- 0 until numKVPairs) { // 一万次
        val byteArr = new Array[Byte](valSize) // 一千以内
        ranGen.nextBytes(byteArr)
//        arr1(i) = (ranGen.nextInt(Int.MaxValue), byteArr) // k->v 1-10000=>随机一千内数
        arr1(i) = (i, byteArr) // k->v 1-10000=>随机一千内数
      }
      arr1
    }
//    println(rdd1.take(2))
//    println(rdd1.count())
    println(rdd1.groupByKey(numReducers).toDebugString)
    val x = rdd1.groupByKey(numReducers).count()

//    println(rdd1.groupByKey(numReducers).count())

    Thread.sleep(1000 * 1000)
  }

}
