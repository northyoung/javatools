package com.util.thread.SeniorThread;

import org.junit.internal.runners.statements.RunAfters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/11/5 0005.
 * 线程池
 */
public class ThreadPool {

    public static void main(String[] args){
        //1.固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //2.缓存的线程池
//        ExecutorService threadPool = Executors.newCachedThreadPool(3);
        //3.创建单一线程池（如何实现线程死掉后重启）
        //ExecutorService threadPool = Executors.newSingleThreadPool(3);
        //定时的线程池
        Executors.newScheduledThreadPool(3).schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("bombing");
            };
        },10, TimeUnit.MINUTES);
        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j < 10 ; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "is looping of " + j + " for task of " + task );
                    }
                }
            });
        }
        System.out.println("commit finished!");
        threadPool.shutdown();
    }
}
