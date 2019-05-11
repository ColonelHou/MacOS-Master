package com.java.apache.spark

import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * Created by colonelhou on 2019/5/3.
  */
case class User(name: String, age: Long)
object CreateDataset {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    // 汤姆与杰瑞
    val tom = new User("Tom", 21)
    val jerry = new User("Jerry", 18)
    val users = List(tom, jerry)

    // 创建 DataSet
    val ds = spark.createDataset(users)

    // 也可以通过 import spark.implicits._ 隐式将 RDD 转换为 Dataset

    /*   // 创建 RDD
    val rdd = spark.sparkContext.parallelize(users)
    import spark.implicits._
    // 转换为 Dataset
    val ds = rdd.toDS*/

    ds.createOrReplaceTempView("stu")
    spark.sql("select name from stu").foreach( row => (println(row.getString(0))))

//    val ds = spark.read.json("/tmp/users.json").as[User]
//    val ds = spark.read.format("json").load("/tmp/users.json").as[User]
//    ds.write.mode(SaveMode. Overwrite).format("parquet").save("/data/users")


  }

}
