package com.util.thread.ConsumerAndProducter;

/**
 * Created by sunsy3 on 2015/2/13.
 */


public class MulConcuPro {

    int i = 0; // 生产的面包数量
    int singleFlag = 1; //0 消费状态 1 生产状态

    public synchronized void ProducterFunction() {
        while(singleFlag == 0){
            try{
                wait();
            }catch( InterruptedException e){}
        }
        i++;
        System.out.println("生产代号"+ Thread.currentThread().getName() +":"+i);
        singleFlag = 0;
        notifyAll();
    }

    public synchronized void ConsumerFunction(){
        while(singleFlag == 1){
            try{
                wait();
            }catch( InterruptedException e){}
        }
        i--;
        System.out.println("消费代号"+ Thread.currentThread().getName() +":"+i);
        singleFlag = 1;
        notifyAll();
    }

}

