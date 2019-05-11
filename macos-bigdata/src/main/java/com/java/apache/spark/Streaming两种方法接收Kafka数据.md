

##### 基于Receivers的方法
````$xslt
1. 使用Kafka的highLevel API
2. 接收到的数据保存到Spark executors中， 然后由Spark Streaming启动的Job来处理这些数据
3. 会丢数据  => 引入WAL 失败可以从它恢复
4. Kafka中Topic的分区和Spark Streaming生成的RDD中分区不是一个概念。
   所以，在 KafkaUtils.createStream()增加特定主题分区数仅仅是增加一个
   receiver中消费Topic的线程数。并不增加Spark并行处理数据的数量；
````

##### 基于Direct方法o
```$xslt
优点:
  1. 简化并行数, Spark Streaming将会创建和Kafka分区一样的RDD分区个数，而且会从Kafka并行地读取数据
  2. 高效, 写WAL 相当于又复制了一份数据, Direct不需要
```