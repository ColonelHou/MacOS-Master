package com.java.model.template;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Caimogu extends Game{
    @Override
    void init() {
        System.out.println("采蘑菇是这样初始化.........");
    }

    @Override
    void start() {
        System.out.println("采蘑菇是这样开始的。。。。");
    }

    @Override
    void end() {
        System.out.println("采蘑菇是这样结束的..........");
    }
}
