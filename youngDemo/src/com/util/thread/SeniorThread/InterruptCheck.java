package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 * ʹ��isInterrupted���������ж��ж�״̬
 * ������Thread�����ϵ���isInterrupted��������������κ��̵߳��ж�״̬��
 * ������Ҫע�⣺�߳�һ�����жϣ�isInterrupted����������᷵��true����һ��sleep����
 * �����׳��쳣����������жϱ�־����ʱisInterrupted��������������false��
 *
 */
public class InterruptCheck {
    public static void main(String[] args){
        Thread mainThread = Thread.currentThread();
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
        //�����жϣ��ж�����
        mainThread.interrupt();
        //Ҳ����ʹ��Thread.interrupted���������ж��ж�״̬
        //Thread.currentThread().interrupt();
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
        try {
            System.out.println("was NOT interrupted");
            mainThread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
            e.printStackTrace();
        }
        //�׳��쳣�󣬻�����жϱ�־������᷵��false
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
    }
    /**
     * ����
     *   ���ﲹ����yield��join������ʹ�á�
     *   join�������̶߳�����ã������һ���߳�A�е�����һ���߳�B��join�������߳�A����ȴ��߳�Bִ����Ϻ���ִ�С�
     *   yield����ֱ����Thread����ã�yield�ó�CPUִ��Ȩ��ͬ�ȼ����̣߳����û����ͬ������߳��ڵȴ�CPU��ִ��Ȩ������̼߳���ִ�С�
     */
}
