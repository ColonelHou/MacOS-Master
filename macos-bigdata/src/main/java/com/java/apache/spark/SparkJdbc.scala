package com.java.apache.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/5/3.
  */
object SparkJdbc {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val df = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://MYSQL_HOST:3306")
      .option("user", "root")
      .option("password", "root")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "")
      .load()
    df.write
      .format("jdbc")
      .option("url", "jdbc:mysql://MYSQL_HOST:3306")
      .option("user", "root")
      .option("password", "root")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "stu")
      .save()
  }

}
