package com.java.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colonelhou on 2019/4/21.
 */
public class Subject {

    List<Observer> observers = new ArrayList<>();

    public void regiester(Observer o) {
        observers.add(o);
    }

    public void unRegiester(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
