package com.java.model.observer;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class ObserverA implements Observer{
    @Override
    public void update() {
        System.out.println("观察者A被通知");
    }
}
