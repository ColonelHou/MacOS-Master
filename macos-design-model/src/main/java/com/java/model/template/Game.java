package com.java.model.template;

/**
 * Created by colonelhou on 2019/4/21.
 */
public abstract class Game {
    abstract void init();
    abstract void start();
    abstract void end();

    public void playGame() {
        init();
        start();
        end();
    }
}
