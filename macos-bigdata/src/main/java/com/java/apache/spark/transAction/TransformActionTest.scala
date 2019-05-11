package com.java.apache.spark.transAction

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/4/25.
  */
object TransformActionTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    val sc = spark.sparkContext

    var rdd1 = sc.makeRDD(1 to 6,2)
    var rdd2 = sc.makeRDD(Seq("A","B","C","D","E"), 2)
    val rddZip = rdd1.zip(rdd2)
//    rddZip.foreach(println) // (1,A) (2,B) ... (5,E)  两个rdd分区数必须相等

    val noIndexRdd = rdd2.mapPartitions {
      (x) => {
        var result = List[String]()
        while (x.hasNext) {
          result ::= x.next().toString
        }
        result.iterator
      }
    }
//    noIndexRdd.foreach(println)

    /**
      * mapPartitionsWithIndex 传入的函数是对每个分区进行处理
      */
    val mapPartWithIndex = rdd1.mapPartitionsWithIndex{
      (x, iter)  => {
        var result = List[String]()
        while (iter.hasNext) {
          result ::= ("part_" + x + "|" + iter.next())
        }
        result.iterator
      }
    }
//    mapPartWithIndex.foreach(println)

    /**
      * 对每个分区中两个RDD合并
      */
    val zipParitionRdd = rdd1.zipPartitions(rdd2) {
      (r1, r2) => {
        var result = List[String]()
        while (r1.hasNext && r2.hasNext) {
          result ::= r2.next() + "_" + r1.next()
        }
        result.iterator
      }
    }
//    zipParitionRdd.foreach(println)

    val coalesceRDD = rdd1.coalesce(10, true)
    // 如果x>y,需要先把x分区中的某些个分区合并成一个新的分区,然后最终合并成y个分区,此时,需要把coalesce方法的shuffle设置成false
    rdd1.repartition(10)
//    println(coalesceRDD.partitions.size)
    val coalescRDD2 = coalesceRDD.coalesce(16, false)
//    println(coalescRDD2.partitions.size) // partition不会变大, 因为shuffle设置为false了


    /**
      * 对几个RDD中key相等的value集合到一块
      */
    val data1 = sc.parallelize(List((1, "www"), (2, "bbs")))
    val data2 = sc.parallelize(List((1, "iteblog"), (2, "iteblog"), (3, "very")))
    val data3 = sc.parallelize(List((1, "com"), (2, "com"), (3, "good")))
    val result = data1.cogroup(data2, data3)
//    result.foreach(println)
    val groupByKeyRDD = data1.groupByKey()
//    groupByKeyRDD.foreach(println)



  }

}
