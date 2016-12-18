package com.util.thread.concurrentPackage.PriorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new PriorityBlockingQueue(); //无界的并发队列
        blockingQueue.put("value");
        blockingQueue.take();
    }
}
