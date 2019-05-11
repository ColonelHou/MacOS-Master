



##### Hash Shuffle(普通机制、consolidation) => 小文件多IO、网络, 数据
##### Sort Shuffle(普通机制、bypass)  => M-task太多也会参生小文件多, R反序列化时间长, 消耗内存 
                                       2.开启排序, map/reduce都要排序
```markdown
比较: 小数据量(hash性能好)1.x前
     大数据量(sort好)    1.x后
```

##### 未经优化的HashShuffleManager(Spark 0.8)
```$xslt
Shuffle Writer
每个Task按key分类(key取hash), 相同的key写入同一个磁盘文件, 个数: 下一个stage的task个数;
写磁盘前先写内存缓冲区中, 缓冲区满后, 才会溢写磁盘;
eg: 未经优化磁盘文件数 => stage1(50个task) stage2(100个task) -> 5000个磁盘文件
Shuffle Read
ShuffleWriter为下一个stage每个task创建了文件, 所以每个task都需要从上一个stage所有task
             拉取数据聚合, 聚合完一批, 再拉下一批放到buffer中聚合 
```

##### 优化后的HashShuffleManager(Spark 0.8.1)
```$xslt
$ 设置 spark.shuffle.consolidateFiles = true
开启consolidation机制后, 出现shuffleFileGroup概念; 
 一个executor上所有task 把key相同的写到缓冲区并溢写一个文件;
eg:  stage1(50个task=10个executor * 5 task), stage2(100个task) 最终 10 * 100 = 1000个文件
```


##### SortShuffleManager运行原理(Spark 1.1, Spark 1.2默认才改为他)
```$xslt
A. 普通运行机制
   数据先写入一个内存数据结构, 如果是reduceByKey算子选HashMap数据结构; 
   如果是join会用Array数据结构; 如果达到临界阀值就溢写(写前sort)磁盘; 
   一个task就重复多次写出多个文件并进行merge, 
   因为下游task要的数据全在这一个文件中, 
   所以会单独写一个索引文件(标识下游各个task数据在文件中的startoffset->endoffset) 
   eg: stage1(50task=10个executor * 5task) stage2(100task)
       最终 只有50个文件
B. bypass运行机制
   触发条件 
     a. shuffle map task数量小于spark.shuffle.sort.bypassMergeThreshold参数的值
     b. 不是聚合类的shuffle算子
   task会为每个下游task都创建一个临时磁盘文件;
   先写入内存缓冲，缓冲写满之后再溢写到磁盘文件;
   磁盘写机制其实跟未经优化的HashShuffleManager是一模一样的，
   因为都要创建数量惊人的磁盘文件, 只是在最后会做一个磁盘文件的合并而已
   与普通SortShuffleManager区别:
   1. 磁盘写机制不同
   2. Shuffle write不需要排序
```

##### Spark 2.0 Hash Based Shuffle退出历史舞台