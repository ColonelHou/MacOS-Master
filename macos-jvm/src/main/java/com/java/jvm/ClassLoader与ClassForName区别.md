

```$xslt
Class.forName  对类进行了初始化, 静态相关的都执行了
ClassLoader   的loadClass并没有对类进行初始化, 只是把类加载到JVM中


eg: JDBC驱动使用Class.forName是因为 mysql的Driver中有静态块 把驱动注册到DriverManager中
```