package com.util.thread.concurrentPackage.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class Customer implements Runnable {
    protected BlockingQueue queue = null;

    public Customer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
