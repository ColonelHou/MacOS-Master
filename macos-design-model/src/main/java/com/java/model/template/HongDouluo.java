package com.java.model.template;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class HongDouluo extends Game{
    @Override
    void init() {
        System.out.println("红豆罗是这样初始化.........");
    }

    @Override
    void start() {
        System.out.println("红豆罗是这样开始.........");
    }

    @Override
    void end() {
        System.out.println("红豆罗是这样结束的.........");
    }
}
