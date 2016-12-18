package com.util.thread.concurrentPackage.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * ±ÕËø
 * Created by Administrator on 2016/12/2 0002.
 */
public class CountDownLatchExample {
    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Customer customer = new Customer(countDownLatch);
        Pruductor productor = new Pruductor(countDownLatch);

        Thread thread1 = new Thread(customer);
        Thread thread2 = new Thread(productor);

        thread1.start();
        thread2.start();
    }
}

class Customer implements Runnable {
    private CountDownLatch countDownLatch;
    public Customer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("countDownLatch already done;");
    }
}

class Pruductor implements Runnable {
    private CountDownLatch countDownLatch;
    public Pruductor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("countDown1 already done;");
            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println("countDown2 already done;");
            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println("countDown3 already done;");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
