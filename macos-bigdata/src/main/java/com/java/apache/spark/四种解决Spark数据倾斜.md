

#####

> 大量不同key的放到一个task上执行
```
$ 可以增加减少shuffle并行度
SET spark.sql.shuffle.partitions=[num_tasks]
spark.default.parallelism
$ 自定义partitioner 将原分配到同一个task上的不同key分散
```

> 大小表Join, 将Reduce端Join 改为 Map端Join
```markdown
$ 通过广播变量, 将小表广播到每一个executor节点上
SET spark.sql.autoBroadcastJoinThreshold=104857600;
? 不适合聚合场景
```

> 两张大表Join
```markdown 
$ Rdd1中分布不均的key单独拿出来 与 分布均匀的RDD2 做join, 
  然后rdd1中剩余的与rdd2 JOIN, 两交结果union
```
