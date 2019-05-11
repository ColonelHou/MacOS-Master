



##### HA原理
```markdown
# QJM/QuromJournal Manager(Paxos一致性算法实现)

# 过程 : Active把editLog-txid与上次要连续(携带epoch编号给JN对比,只有>=才行并更新)
        写入QJM(共2n+1, 写入n+1算成功), Standby过来读取;
        保持与Active同步, DN同时向Standby汇报;

# 优势: 1. 不需要额外配置高可用存储系统
       2. 消除单点故障SPOF
       3. JN不会因一台慢影响所有, 也不会因为增加JN影响性能(NN->JN是并行的)

# DN怎么知道新NN? : NN状态变后向DN发送自己状态和序号(递增)

# Hadoop在每台NN上部署ZKFC(zkFailoverController)
# ZKFC功能:
           1. 监控NN是否健康和可用
           2. 会话管理: zkfc会把ActiveNN注册到znode临时节点,NN挂掉znode删除,
                       Standby会得到znode这把锁,升级为主; 原Active启来后
                       发现已有锁, 把自己置为Standby
           3. Master选举: 谁先占了znode锁, 谁就是主

# DN fencing: DN只能接收一个NN命令
# 客户端fencing: 确保只有一个NN接收客户端请求

```

##### QJM设计

##### Hadoop Federation(水平拆分NN)
```markdown
# 问题: 单Active使HDFS扩展和性能上有瓶颈; 集群过大, NN使用内存可能要上百G
        (1G存100万个块, 64T左右)
1. 每个NN定义存储池, 有个单独id; 每个DN都为所有存储池提供服务
2. DN会向所有NN汇报本地存储情况
```

##### 脑裂
```markdown
# 指在一个高可用（HA）系统中，当联系着的两个节点断开联系时，本来为一个整体的系统，分裂为两个独立节点，这时两个节点开始争抢共享资源，结果会导致系统混乱，数据损坏。
```





