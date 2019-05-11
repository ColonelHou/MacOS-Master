        数据包(DN之前是推的动作)
> client -> DN1 -> DN2 -> DN3
        <-      <-      <-
        确认包

##### HDFS写数据流程
```markdown
# client                 -> DistributedFileSyste -> NameNode
     | 
  FSDataOutputStream<DFSOutputStream (文件包放)内部队列>
             |
           client把文件包放到 内部队列
             |
             文件包打成数据包 送到流管理
             |
             数据流管道
             |
            DataNode(持久化)
             | 
             发送 确认包  给客户端（内部队列删除）
             
             
写 过程中节点故障 
       |
      管道关闭(没有Ack的数据包 重新放入内部队列（保证不丢数据）)
       |
       新进入 内部队列 新版本号; 通知NN, 故障DN启来后删除

```