package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 * ����ͻָ��߳�
 *
 * ��areValuesEqual�������ص�ֵ��ʱΪtrue����ʱΪfalse�����ϴ����У�
 * ������firstVal֮�󣬵�������secondVal֮ǰ���������̻߳�����鷳��
 * ��ʱ����Ľ����Ϊfalse�����1�������ʱ�䲻���˹����̣߳�����Ϊ
 * �̲߳��ܿ��ƺ�ʱ��������suspend������������������ǲ��ɱ���ġ�
 *
 * ��Ȼ����ʹ�̲߳�������ע�͵�����ͻָ��̵߳����д��룩�������
 * main�߳���ִ��asr.areValuesEqual�������бȽ�ʱ��ǡ��stepOne����ִ
 * ���꣬��stepTwo������ûִ�У���ô�õ��Ľ��ͬ��������false�����2����
 *
 * �������Ǹ���������������������ʵ���̹߳���ͻָ��Ĳ��ԡ������ñ�־λ��
 * ͨ���÷���ʵ���̵߳Ĺ���ͻָ���һ���ܺõĵط������ǿ������̵߳�ָ��
 * λ��ʵ���̵߳Ĺ���ͻָ��������õ����䲻ȷ���ԡ�
 */
public class AlternateSuspendResume extends Object implements Runnable {

    private volatile int firstVal;
    private volatile int secondVal;
    //���ӱ�־λ������ʵ���̵߳Ĺ���ͻָ�
    private volatile boolean suspended;

    public boolean areValuesEqual() {
        return ( firstVal == secondVal );
    }

    public void run() {
        try {
            suspended = false;
            firstVal = 0;
            secondVal = 0;
            workMethod();
        } catch ( InterruptedException x ) {
            System.out.println("interrupted while in workMethod()");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;

        while ( true ) {
            //�����ͳ�����ʱ�����������д���
            waitWhileSuspended();

            stepOne(val);
            stepTwo(val);
            val++;

            //�����̹߳���ʱ�����������д���
            waitWhileSuspended();

            Thread.sleep(200);
        }
    }

    private void stepOne(int newVal)
            throws InterruptedException {

        firstVal = newVal;
        Thread.sleep(300);
    }

    private void stepTwo(int newVal) {
        secondVal = newVal;
    }

    public void suspendRequest() {
        suspended = true;
    }

    public void resumeRequest() {
        suspended = false;
    }

    private void waitWhileSuspended()
            throws InterruptedException {

        //����һ������æ�ȴ���������ʾ����
        //���Ƿǵȴ������ı�����;������Ϊ���᲻�������������ڵ�ִ�м�飬
        //���ѵļ����ǣ�ʹ��Java�����á�֪ͨ-�ȴ�������
        while ( suspended ) {
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        AlternateSuspendResume asr =
                new AlternateSuspendResume();

        Thread t = new Thread(asr);
        t.start();

        //����1�룬�������߳��л�����ִ��
        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        for ( int i = 0; i < 10; i++ ) {
            asr.suspendRequest();

            //���߳��л���ע�⵽��������
            //ע�⣺��������ʱ��һ��Ҫ����
            //stepOne������firstVal��ֵ�������ʱ�䣬��300ms��
            //Ŀ����Ϊ�˷�ֹ��ִ��asr.areValuesEqual�������бȽ�ʱ,
            //ǡ��stepOne����ִ���꣬��stepTwo������ûִ��
            try { Thread.sleep(350); }
            catch ( InterruptedException x ) { }

            System.out.println("dsr.areValuesEqual()=" +
                    asr.areValuesEqual());

            asr.resumeRequest();

            try {
                //�߳��������0~2��
                Thread.sleep(
                        ( long ) (Math.random() * 2000.0) );
            } catch ( InterruptedException x ) {
                //��
            }
        }

        System.exit(0); //�˳�Ӧ�ó���
    }
}
