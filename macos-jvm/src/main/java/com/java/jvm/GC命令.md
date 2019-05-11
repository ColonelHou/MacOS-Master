

##### http://www.importnew.com/16327.html


##### jstat
```markdown
##### 根据端口查出进程id
$ lsof -i tcp:2181
```
##### 查看class加载情况
```
$ jstat -class 21768
```

##### 查看编译情况
```
$ jstat -compiler 21768
```

##### 查看gc情况
```
$ jstat -gc 21768   2000 20(每隔2000ms打印一次, 共打印20次)
C即Capacity 总容量，U即Used 已使用的容量

S0C : survivor0区的总容量
S1C : survivor1区的总容量
S0U : survivor0区已使用的容量
S1C : survivor1区已使用的容量
EC : Eden区的总容量
EU : Eden区已使用的容量
OC : Old区的总容量
OU : Old区已使用的容量
PC 当前perm的容量 (KB)
PU perm的使用 (KB)
YGC : 新生代垃圾回收次数
YGCT : 新生代垃圾回收时间
FGC : 老年代垃圾回收次数
FGCT : 老年代垃圾回收时间
GCT : 垃圾回收总消耗时间
```

##### 堆区使用情况
```
$ jstat -gccapacity 21768
NGCMN : 新生代占用的最小空间
NGCMX : 新生代占用的最大空间
OGCMN : 老年代占用的最小空间
OGCMX : 老年代占用的最大空间
OGC：当前年老代的容量 (KB)
OC：当前年老代的空间 (KB)
PGCMN : perm占用的最小空间
PGCMX : perm占用的最大空间
```

##### 是已使用空间占总空间的百分比
```
$ jstat -gcutil 21768
```

###### 最近两次垃圾回收事件的原因
```
$ jstat -gccause 21768
LGCC：最近垃圾回收的原因
GCC：当前垃圾回收的原因
```

###### 新生代的行为 新生代与其相应的内存空间的统计
```
$ jstat -gcnew / -gcnewcapacity
TT：Tenuring threshold(提升阈值)
MTT：最大的tenuring threshold
DSS：survivor区域大小 (KB)

 NGC:当前年轻代的容量 (KB)
 S0CMX:最大的S0空间 (KB)
 S0C:当前S0空间 (KB)
 ECMX:最大eden空间 (KB)
 EC:当前eden空间 (KB)
```
 
##### 老年代/ 永久代内存空间统计
```
$ jstat -gcold / -gcpermcapacity / -printcompilation
```

### jmap / jhat使用
```markdown
$ jmap -histo 36027

# dump堆到文件,format指定输出格式，live指明是活着的对象,file指定文件名
$ jmap -dump:live,format=b,file=dump.hprof 36344

# http://localhost:7000/访问这个地址可以 查看类实例创建情况
$ jhat dump.hprof
```

### jstack -l pid 使用
```markdown
# 检测死锁, 死循环, 睡眠, 挂起, wait等待状态
```
