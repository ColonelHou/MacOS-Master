package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/26.
  */
object JoinTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    val sc = spark.sparkContext
    val visit = sc.parallelize(List(("index.html","1.2.3.4"),
                                    ("about.html","3,4,5,6"),
                                    ("index.html","1.3.3.1"),
                                    ("hello.html","1,2,3,4")),2)
    val page = spark.sparkContext.parallelize(List(("index.html","home"),
                                                   ("about.html","about"),
                                                    ("hi.html","2.3.3.3")),3)
    // 取交集
//    visit.join(page).foreach(println(_))
//    visit.leftOuterJoin(page).foreach(println)
//      visit.rightOuterJoin(page).foreach(println)
//    page.rightOuterJoin(visit).foreach(println)
    visit.fullOuterJoin(page).foreach(println)
  }

}
