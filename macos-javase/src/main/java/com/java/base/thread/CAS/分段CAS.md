

```$xslt
$ LongAdder类与AtomicLong类的区别在于高并发时
  前者将对单一变量的CAS操作分散为对数组cells中多个元素的CAS操作，取值时进行求和；
  而在并发较低时仅对base变量进行CAS操作，与AtomicLong类原理相同
```