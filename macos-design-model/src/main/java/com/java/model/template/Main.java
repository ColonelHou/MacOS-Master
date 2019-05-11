package com.java.model.template;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Main {
    public static void main(String[] args) {
        Game caimogu = new Caimogu();
        Game hongdouluo = new HongDouluo();

        caimogu.playGame();
        hongdouluo.playGame();
    }
}
