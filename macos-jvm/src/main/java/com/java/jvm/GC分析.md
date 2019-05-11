
##### GC 日志
```markdown
                                           GC类型 GC前新生代内存 -> GC后新生代(新生代总内存) gc前堆 -> gc后堆(堆总大小) gc耗时
2016-07-05T10:43:18.093+0800: 25.395: [GC [PSYoungGen: 274931K->10738K(274944K)]      371093K->147186K(450048K), 0.0668480 secs]  
                  gc用户耗时 gc系统耗时  gc实际耗时
          [Times: user=0.17 sys=0.08, real=0.07 secs] 
2016-07-05T10:43:18.160+0800: 25.462: [Full GC [PSYoungGen: 10738K->0K(274944K)] 
            old区                                gc前堆  -> gc后堆 (堆总大小)
          [ParOldGen: 136447K->140379K(302592K)] 147186K->140379K(577536K)
           perm区                                  GC耗时
          [PSPermGen: 85411K->85376K(171008K)], 0.6763541 secs] 
          [Times: user=1.75 sys=0.02, real=0.68 
```