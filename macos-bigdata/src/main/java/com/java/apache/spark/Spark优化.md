
##### 开发调优篇
```$xslt
1. 避免创建重复的RDD
2. 尽可能复用同一个RDD
3. 对多次使用的RDD进行持久化
4. 尽量避免使用shuffle类算子
5. 使用map-side预聚合的shuffle操作
6. 使用高性能的算子 reduceByKey替换groupByKey mapPartitions替代普通map 使用foreachPartitions替代foreach
7. 广播大变量
8. 使用Kryo优化序列化性能
```


##### 资源调优篇
```$xslt
1. num-executors 50~100个左右的Executor进程
2. executor-memory 每个Executor进程的内存设置4G~8G较为合适
3. executor-cores Executor的CPU core数量设置为2~4个较为合适 
4. spark.default.parallelism
5. spark.storage.memoryFraction 持久化少就降低, 作业频繁GC, task执行用户代码内存不够, 同样降
6. spark.shuffle.memoryFraction shuffler多提高, 
```