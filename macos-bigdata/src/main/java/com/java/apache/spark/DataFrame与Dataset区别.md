



##### Dataset 与 DataFrame区别
```markdown
# RDD 优势: 编译时类型检测
      缺点: 序列化性能开销
      
# DataFrame: 优势: schema 和offheap
             缺点: 非类型安全 运行时反射
           
# Dataset: 优势: 结合上面两个优点 新的概念Encoder; 面向对象, 性能好很多
           缺点:
```