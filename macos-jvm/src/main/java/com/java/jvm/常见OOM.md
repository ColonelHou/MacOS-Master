
##### java.lang.OutOfMemoryError:Java heap space
```markdown
1. 内存泄露
2. 创建对象过多
```
##### java.lang.OutOfMemoryError:Metaspace
```markdown
加载的类太多，常见于Tomcat等容器中
```

##### java.lang.OutOfMemoryError:Permgen space
```markdown
jdk7中，方法区被实现在永久代中，错误原因同上。
永久代非常小，而且不会被回收，很容易溢出，因此，jdk8彻底废除了永久代，
将方法区实现在元数据区。
```

##### java.lang.OutOfMemoryError:Unable to create new native thread
```markdown
1. 线程数：增大线程数限制。
2. 内存资源：调小OS的线程栈、JVM的虚拟机栈。
3. pid：增大pid范围。
```

##### java.lang.OutOfMemoryError:GC overhead limit exceeded
```markdown
默认配置下，如果GC花费了98%的时间，回收的内存都不足2%的话，抛出该异常。
```

##### java.lang.OutOfMemoryError:Out of swap space
```markdown
如果JVM申请的内存大于可用物理内存，操作系统会将内存中的数据交换到磁盘上去（交换区）。
如果交换区空间不足，抛出该异常。
```






