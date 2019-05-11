


```$xslt
HashPartitioner  对K-V中K取hash, 再对分区个数取余
RangePartitioner 分区与分区之间是有序(一个分区内比另一个分区肯定大), 但同一个分区是无序的
```

#### 自定义分区
```$xslt
extends Partitioner 
```