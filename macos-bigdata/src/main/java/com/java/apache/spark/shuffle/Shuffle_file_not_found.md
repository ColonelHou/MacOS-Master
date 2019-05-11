



##### 重新执行一次就好了

```markdown
# 原因: executor 的jvm进程内存不够用了; 可能在GC,（STW）, 下一个stage去上一个拉取
       不到出现shuffle file not found
       
# 解决: 1. 增加重试次数, 默认是3 次
       2. 每次重试时间, 默认是5秒钟
```