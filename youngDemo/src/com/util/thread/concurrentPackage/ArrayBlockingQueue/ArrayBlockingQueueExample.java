package com.util.thread.concurrentPackage.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class ArrayBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Customer cust = new Customer(queue);
        Productor prod = new Productor(queue);

        new Thread(cust).start();
        new Thread(prod).start();
    }
}
