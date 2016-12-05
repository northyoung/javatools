package com.util.thread.concurrentPackage.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ö´ÐÐÆ÷·þÎñ
 * Created by Administrator on 2016/12/5 0005.
 */
public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable(){
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
    }

}
