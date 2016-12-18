package com.util.thread.concurrentPackage.LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class LinkedBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
        BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);
        bounded.put("Value");
        String value = bounded.take();
        System.out.println(value);
    }
}
