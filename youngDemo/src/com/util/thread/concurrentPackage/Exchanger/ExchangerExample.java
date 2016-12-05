package com.util.thread.concurrentPackage.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * 两个线程通过一个 Exchanger 交换对象
 * Created by Administrator on 2016/12/5 0005.
 */
public class ExchangerExample {
    public static void main(String[] args){
        Exchanger exchanger = new Exchanger();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}
