
#### MapJoin(map阶段完成join) 和 ReduceJoin(reduce阶段完成join)


#### MapJoin
````$xslt
$ 小表 和 大表 的Join场景; 设备一个参数hive.auto.convert.join=true会自动 把大小表转成mapjoin
# 过程
1. 小表 转成 Hashtable的数据结构, 写入本地的文件中, 将该文件加载到DistributeCache里
2. 启动MapTask扫描大表, 将大表中每一条记录与DistributeCache中Hashtable关联
3. MapJoin没有Reduce, 由Map直接输出结果文件, 结果文件数由MapTask个数决定
````