常见的jvm逃逸分析的指令：
-XX:+EliminateLocks开启锁消除（jdk1.8默认开启）
-XX:-EliminateLocks 关闭锁消除
-XX:+EliminateAllocations开启标量替换（jdk1.8默认开启）
-XX:-EliminateAllocations 关闭标量替换
-XX:+DoEscapeAnalysis开启逃逸分析（jdk1.8默认开启）
-XX:-DoEscapeAnalysis 关闭逃逸分析


> 同步消除是什么？
当通过逃逸分析之后，发下某个对象在没有被外部线程所引用的时候，
他的读写竞争也就不存在了，这个时候就可以消除他的同步操作。

> 逃逸分析
指方法创建对象之后，除了在方法体内被引用到之外，还在别处也被引用到了。
由于GC进行对象回收的时候需要判断该对象是否有被引用，因此当相应方法执行完毕后，
由于方法类对象还被外部程序引用，就会导致相应对象无法被GC回收处理，
也就造成了内存逃逸现象

> 逃逸分析会把sync代码优化掉, 此代码是无锁的
> 加锁本质就是在锁对象的对象头中写入当前线程id
```aidl
class SafeCalc {
  long value = 0L;
  long get() {
    synchronized (new Object()) {
      return value;
    }
  }
  void addOne() {
    synchronized (new Object()) {
      value += 1;
    }
  }
}

```
