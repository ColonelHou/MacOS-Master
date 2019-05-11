


```$xslt
我用的HIVE版本是0.8，不支持直接的left join写法；


> left outer join
select * from table1 left outer join table2 on(table1.student_no=table2.student_no);

如果右边有多行和左边表对应，就每一行都映射输出；如果右边没有行与左边行对应，就输出左边行，右边表字段为NULL；

> left semi join
select * from table1 left semi join table2 on(table1.student_no=table2.student_no);

只打印出了左边的表中的列，规律是如果主键在右边表中存在，则打印，否则过滤掉了。
```

```$xslt
> 总结: outer 右表没有设置为NULL
        semi 右表没有就过虑掉
```