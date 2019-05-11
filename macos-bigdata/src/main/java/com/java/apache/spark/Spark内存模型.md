

```markdown
$ 堆内内存（JVM –executor-memory）

$ 堆外内存 (spark.yarn.executor.memoryOverhead UnSafe) 默认不启动 
          用于JVM自身，字符串, NIO Buffer等开销 
```

##### 为什么有堆外内存
```markdown
# 问题1
$ 默认300M+, 处理大量(几亿，几十亿的)数据会出现问题, 
  spark.yarn.executor.memoryOverhead
  这个参数调整到2G，至少1G(1024M)，甚至说4G

# 问题2
$ Shuffle使用netty框架进行网络传输, netty会申请堆外内存缓存; 
  shuffle时每个Reduce获取Map结果(巨大/1G), 这时会申请堆外内存(有限制),
  此时就出现堆外内存溢出;
$ 以下参数设置不使用堆外内存(设置不用还会出现OutOfMemoryError: Java heap space)
-Dio.netty.noUnsafe=true

# 问题3
$ executor1从executor2中拉取数据时, 2正在GC, 建立不了连接(默认60s) 直接宣告失败
  解决: --conf spark.core.connection.ack.wait.timeout=300
      
```

##### 统一内存模型（存储内存 + 执行内存）= 总 * 0.6
##### 总 = 统一内存模型 + 用户内存 + 保留内存
```markdown
1. 存储内存: 广播、RDD缓存
2. 执行内存: Shuffle中间数据
3. 用户内存: 用户自定义数据结构
4. 保留内存: 默认值为300，一般无需改动, 不用关心
```