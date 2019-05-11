package com.java.apache.spark.transAction

/**
  * Created by colonelhou on 2019/5/6.
  */
import org.apache.spark.sql.functions.{collect_list, collect_set}

import org.apache.spark.sql.SparkSession
case class User(id: Int, name: String, price: Int, course:String, age:Int)
object GroupBySum {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GroupBySum").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._
    val rdd = spark.sparkContext.parallelize(
      List(
        (1, "12:01", 100),
        (1, "12:02", 200),
        (1, "12:50", 100),
        (2, "12:50", 100),
        (3, "13:01", 200)
    ))
    val x = Seq(
      User(1, "12:01", 100, "tom", 12),
      User(1, "12:02", 200, "tim", 13),
      User(1, "12:50", 100, "tjm", 15),
      User(2, "12:50", 100, "tom", 12),
      User(3, "13:01", 200, "jim", 17)
    )

//    val dataset = spark.createDataset(x)
//    dataset.createOrReplaceTempView("stu")
//    dataset.select("name").foreach(x => println(x.getString(0)))
//    dataset.groupBy("id", "name").agg("age" -> "sum")



    val df = spark.createDataFrame(x)
    df.printSchema()
//    df.show()
    /**
      * +---+----+-----+
      * | id|name|price|
      * +---+----+-----+
      * |  1|  12|  100|
      * |  1|  12|  200|
      * |  1|  12|  100|
      * |  2|  12|  100|
      * |  3|  13|  200|
      * +---+----+-----+
      */
    val dd = df.map(st => User(st.getInt(0), st.getString(1).split(":")(0),
      st.getInt(2), st.getString(3), st.getInt(4)))
    dd.show
//    dd.groupBy("id", "name").avg("price").show()
//    dd.groupBy("id", "name").sum("price").show()

    /**
      *
      * +---+----+-------------------+--------------------+
      * | id|name|collect_list(price)|collect_list(course)|
      * +---+----+-------------------+--------------------+
      * |  1|  12|    [100, 200, 100]|     [tom, tim, tjm]|
      * |  2|  12|              [100]|               [tom]|
      * |  3|  13|              [200]|               [jim]|
      * +---+----+-------------------+--------------------+
      */
    dd.groupBy("id", "name").agg(collect_list("price"), collect_list("course")) //.show()
    dd.groupBy("id", "name").agg("age" -> "sum", "price" -> "count").show()



  }
}
