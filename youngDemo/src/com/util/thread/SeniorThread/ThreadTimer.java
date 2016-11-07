package com.util.thread.SeniorThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/11/4 0004.
 *
 * 定时器 可以支持按照日期进行执行任务
 */
public class ThreadTimer {
    public static void main(String args[]){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        },10000,30000);

        class MyTimerTask extends TimerTask {

            @Override
            public void run() {
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(),2000);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);
    }
}
