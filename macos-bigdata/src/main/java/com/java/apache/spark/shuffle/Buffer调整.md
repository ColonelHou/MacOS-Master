##### map buffer(32kb) reduce(聚合内存0.2)


#### 调优 => 减少磁盘spill次数
```markdown
# Spark UI上看Shuffle Write/Read读写数量


mapbuffer 每次调整一倍, 64, 128, 看
reduce buffer 每次增加0.1, 
```