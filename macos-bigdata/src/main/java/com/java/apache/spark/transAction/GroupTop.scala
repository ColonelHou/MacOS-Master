package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/28.
  */
object GroupTop {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val data = sc.parallelize(List(
      "deptA,a,9",
      "deptA,aa,234",
      "deptA,ab,1299",
      "deptA,ae,59",
      "deptA,at,79",
      "deptA,au,99",
      "deptB,al,119",
      "deptB,b,59",
      "deptB,bb,29",
      "deptB,be,99",
      "deptB,bg,19"), 2)
    val rdd = data.map(x => {
      val yy = x.split(",")
      (yy(0), (yy(1), yy(2)))
    }).groupByKey() // (deptA,CompactBuffer((a, 9), (aa,234), (ab,1299), (ae,59), (at,79), (au,99)))
    rdd.map(xx => {
      val dept = xx._1
      val scoreList = xx._2.toList.sortWith(_._2.toInt > _._2.toInt).take(3)
      (dept, scoreList)
    }).foreach(println)


  }

}
