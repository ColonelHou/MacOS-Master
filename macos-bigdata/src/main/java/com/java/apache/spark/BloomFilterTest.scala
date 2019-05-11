package com.java.apache.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by colonelhou on 2019/5/3.
  * 布隆过虑器
  * 计算连续两天同时登录用户数
  * m: 布隆过虑器的大小
  * k: hash函数的个数
  * p: 失误率
  */
object BloomFilterTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    /*
    val df = spark.range(100000000)
    val filter1 = df.stat.bloomFilter("id", 1000, 0.9)
    println(filter1.mightContain(998))
    */

    // 第一步: 查出昨天所有用户id, 创建布隆过虑器
    val yesterdayDF = spark.sql(
      """select al.user_id from access_log al
        where al.his = date_format(date_sub(current_date, 1), 'yyyy-MM-dd') and al.user_id is not null
      """.stripMargin)
    val bf = yesterdayDF.stat.bloomFilter("user_id", 200000, 0.01) // 布隆过滤器
    // 第二步: 把昨天的所有用户id进行广播
    val bfBc = spark.sparkContext.broadcast(bf) // 广播变量

    // 第三步: 在前天所有用户id中 迭代, 如果在昨天结果集中有就过虑出, 再用distinct, 统计出连续两天登录的用户数
    val repeatAccessNum = spark.sql(
      """
        |select
        |    al.user_id
        |from access_log al
        |where al.his = date_format(date_sub(current_date, 2), 'yyyy-MM-dd')
        |and up.user_id is not null
      """.stripMargin).filter((row) => {
      bfBc.value.mightContainString(row.getString(0))
    }).distinct().count()
  }

}
