package com.java.model.chainRespo.handlerSeg;

/**
 * Created by colonelhou on 2019/5/3.
 */
public abstract class Handler {
    protected Handler next;//继任者

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handlerRequest(int request);
}
