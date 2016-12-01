package com.util.thread.concurrentPackage.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class Productor implements Runnable {

    protected BlockingQueue queue = null;

    public Productor(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("obj1");
            Thread.sleep(1000);
            queue.put("obj2");
            Thread.sleep(1000);
            queue.put("obj3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
