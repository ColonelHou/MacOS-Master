package com.java.apache.spark.drools

import org.apache.spark.sql.SparkSession
import org.kie.api.io.ResourceType
import org.kie.internal.utils.KieHelper

/**
  * Created by colonelhou on 2019/5/3.
  * 读取文件时需要 把pom.xml中引入的guava注掉
  */
case class ProductTrading(amount: BigDecimal, level: String)

object ProductTrading {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("NewUVDemo").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val drl = spark.sparkContext.textFile("/Users/colonelhou/Documents/company/wksp/MacOS-JAVA/src/main/java/com/java/apache/spark/drools/product.drl")
    val drlBroadcast = spark.sparkContext.broadcast(drl).value.collect()

    val jim = ProductTrading(1200, "jim")
    val lily = ProductTrading(500, "lily")
    val lucy = ProductTrading(90, "lucy")
    val john = ProductTrading(120, "john")
    val users = List(jim, lily, lucy, john)

    val rdd = spark.sparkContext.parallelize(users, 2) //.map(p => (p.amount, p.level))
    val last = rdd.mapPartitions(
      (partition) => {
        val kieHelper = new KieHelper
        kieHelper.addContent(drlBroadcast.toString, ResourceType.DRL) // 加载规则
        val kieBase = kieHelper.build()
        val kieSession = kieBase.newKieSession
        for (i <- partition) {
          kieSession.insert(new ProductTrading(i.amount, i.level)) // 插入值
          val x = kieSession.fireAllRules() // 触发规则执行
          println("x ====> " + x)
        }
        kieSession.destroy()




        var result = List[String]()
        while (partition.hasNext) {
          result ::= partition.next().toString
        }
        result.iterator
      }
    )

  }
}
