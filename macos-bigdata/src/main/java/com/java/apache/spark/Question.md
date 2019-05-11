
##### 1. HashShuffle -> HashShuffle(consolidation) -> 
         SortShuffle -> SortShuffle(ByPass)
##### 2. Buffer(Map/Reduce) 缓存区太小, 增加IO次数;  
         如果Reduce(Buffer)太大OOM, 程序处理慢（Buffer调小）
##### 3. 未序列化task
##### 4. stage0 fullGC导致文件拉取失败, 增加重试次数 和 每次等待时间
##### 5. yarn-client模式下会导致网卡流量剧增
##### 6. yarn-cluster模式下 where or条件过多导致递归 栈溢出
##### 7. checkpoint rdd.cache() rdd.count会出错=> rdd1 = rdd.cache; rdd1.count
         利: 可靠性; 弊: 写hdfs耗时
##### 8. 数据倾斜 a. 某个task执行慢
         1. 聚合源数据 
         2. 过虑导致倾斜key
         3. 提高reduce并行度（没从根本上解决数据倾斜问题）
         4. 双重聚合, (加随机数,进行第一次聚合; 第二次 去除随机数再聚合)reduceByKey/groupByKey
         5. join, 把小rdd放到executor的blockmanager上
         6. 热点key拆分出来, 和 普通的key分别 与 另一张表join, join完后再union
         7. 两大表
##### Application => jobs(collect/take) => (stage|shuffle)
##### 
##### 
##### 
