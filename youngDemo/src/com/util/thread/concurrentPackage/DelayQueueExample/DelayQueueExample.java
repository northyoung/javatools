package com.util.thread.concurrentPackage.DelayQueueExample;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        Delayed delayed = new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        };
        delayQueue.put(delayed);
        Delayed element2 = delayQueue.take();
    }
}
