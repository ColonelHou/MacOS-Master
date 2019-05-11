
```$xslt 
UDF  --> 标准函数 GenericUDF处理复杂类型
UDAF --> 聚合函数(0/x行  到 0/x列)
UDTF --> 生成函数(生成多行或多列)
```

```$xslt
第一种：ADD jars只适应当前会话

第二种: 修改hive-site.xml配置 hive.aux.jars.path

第三种：创建目录HIVE_HOME/auxlib, 把UDF的包放到这个目录下

第四种：环境变量中export HIVE_AUX_JARS_PATH环境变量
```