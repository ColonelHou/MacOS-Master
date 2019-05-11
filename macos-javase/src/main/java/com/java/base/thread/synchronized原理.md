
```$xslt
同步方法和同步代码块底层都是通过monitor来实现同步的。
每个对象都与一个monitor相关联, monitor可以被线程拥有或释放
```

##### 啥是monitor, monitor怎么与对象关联
```$xslt
Java对象与monitor的关联：通过在Java对象头中的mark word中存储了指向monitor的指针。
明白了Java中的管程ObjectMonitor的工作原理，知道了Java语法中的wait/notify/notifyAll方法底层都是调用了ObjectMonitor的方法。
明白了管程的概念，一种程序结构，封装了同步操作，避免直接使用PV信号量。

```


