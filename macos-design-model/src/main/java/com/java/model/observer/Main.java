package com.java.model.observer;

import java.io.Serializable;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer a = new ObserverA();
        Observer b = new ObserverB();
        subject.regiester(a);
        subject.regiester(b);

        subject.notifyObservers();
    }
}
