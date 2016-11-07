package com.util.thread.SeniorThread;

import java.util.Objects;

/**
 * Created by Administrator on 2016/11/6 0006.
 * ʹ��interrupt�����ж��߳�
 * ��һ���߳�����ʱ����һ���߳̿��Ե��ö�Ӧ��Thread�����interrupt�����������ж�����
 * �÷���ֻ����Ŀ���߳�������һ����־����ʾ���Ѿ����жϣ����������ء�������Ҫע����ǣ�
 * ���ֻ�ǵ����ĵ���interrupt�����������̲߳�û��ʵ�ʱ��жϣ����������ִ�С�
 */
public class InterruptThread implements Runnable{

    @Override
    public void run(){
        try{
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        }catch(InterruptedException e){
            System.out.println("in run() - interrupted while sleeping");
            //�������ж��쳣�󣬷��ص�run���������˿ڣ�
            //���û��return���̲߳���ʵ�ʱ��жϣ����������ӡ�������Ϣ
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args){
        InterruptThread si = new InterruptThread();
        Thread t = new Thread(si);
        t.start();
        //���߳�����2�룬�Ӷ�ȷ���ղ��������߳��л���ִ��һ��ʱ��
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        //�ж��߳�t
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}
