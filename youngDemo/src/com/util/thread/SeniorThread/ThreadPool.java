package com.util.thread.SeniorThread;

import org.junit.internal.runners.statements.RunAfters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/11/5 0005.
 * �̳߳�
 */
public class ThreadPool {

    public static void main(String[] args){
        //1.�̶���С���̳߳�
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //2.������̳߳�
//        ExecutorService threadPool = Executors.newCachedThreadPool(3);
        //3.������һ�̳߳أ����ʵ���߳�������������
        //ExecutorService threadPool = Executors.newSingleThreadPool(3);
        //��ʱ���̳߳�
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
