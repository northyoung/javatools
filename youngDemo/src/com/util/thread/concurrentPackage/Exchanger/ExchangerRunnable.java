package com.util.thread.concurrentPackage.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class ExchangerRunnable implements Runnable {
    Exchanger exchanger = null;
    Object    object    = null;
    public ExchangerRunnable(Exchanger exchanger, Object a) {
        this.exchanger = exchanger;
        this.object = a;
    }
    @Override
    public void run() {
        Object previous = this.object;
        try {
            this.object = this.exchanger.exchange(this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                Thread.currentThread().getName() +
                        " exchanged " + previous + " for " + this.object
        );
    }
}
