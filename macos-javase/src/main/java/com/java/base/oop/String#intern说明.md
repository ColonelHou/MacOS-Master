


```markdown
jdk7 : 先检测常量池里有没, 如果没有, 就在池中放入"abc"; 
       如果没有, 直接存储堆中的引用
       
String s3 = new String("1") + new String("1"); // 常量池中没有 11
s3.intern(); // 将s3中的字符串”11”放入了常量池中, 没有就存堆中引用
String s4 = "11"; // s4发现常量池中有, 直接返回s3引用 
System.out.println(s3 == s4); // true
# 常量池中没有, 放入

String s3 = new String("1") + new String("1");
String s4 = "11";
s3.intern(); // 发现池中有, 什么都不做
System.out.println(s3 == s4);
# 
```