package com.util.thread.concurrentPackage.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * µÈ´ýÒ»¸ö CyclicBarrier
 * Created by Administrator on 2016/12/5 0005.
 */
public class CyclicBarrierExample {
    static CyclicBarrier barrier = new CyclicBarrier(2);
    public static void main(String args[]){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    barrier.await();
                    System.out.println("t1 run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    barrier.await();
                    System.out.println("t2 run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
