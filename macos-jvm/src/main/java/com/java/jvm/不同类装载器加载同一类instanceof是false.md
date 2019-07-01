
> 不同类装载器装载类, 即使是同一个class文件, 结果也是不同的

> ? 为什么要双亲委托(就是解决上面的问题, 同一class文件使用的时候可转换)

```$xslt
ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream stream = getClass().getResourceAsStream(fileName);
                if (stream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[stream.available()];
                    // 将流写入字节数组b中
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
 
                return super.loadClass(name);
            }
        };
        Object obj = classLoader.loadClass("jvm.DifferentClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof DifferentClassLoaderTest);
        // DifferentClassLoaderTest obj = (DifferentClassLoaderTest) classLoader.loadClass("jvm.DifferentClassLoaderTest").newInstance();

```