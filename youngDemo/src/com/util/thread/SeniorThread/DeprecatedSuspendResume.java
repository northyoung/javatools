package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 *  ����ͻָ��߳�
 *  Thread ��API�а�����������̭�ķ���������������ʱ���������ĳ���̣߳�
 *  ��Щ�����Ѿ�����̭����Ϊ�����ǲ���ȫ�ģ����ȶ��ġ�����ڲ����ʵ�ʱ
 *  ������̣߳����磬����������Դʱ������ʱ����ܻᷢ����������������
 *  ���߳��ڵȴ����߳��ͷ����������߳�ȴ�������ˣ���ᷢ�����������⣬
 *  �ڳ�ʱ������ڼ�����߳�Ҳ���ܵ������⡣
 *
 *  ��areValuesEqual�������ص�ֵ��ʱΪtrue����ʱΪfalse�����ϴ����У�������
 *  firstVal֮�󣬵�������secondVal֮ǰ���������̻߳�����鷳����ʱ����Ľ�
 *  ����Ϊfalse�����1�������ʱ�䲻���˹����̣߳�����Ϊ�̲߳��ܿ��ƺ�ʱ����
 *  ����suspend������������������ǲ��ɱ���ġ�
 *
 *  ��Ȼ����ʹ�̲߳�������ע�͵�����ͻָ��̵߳����д��룩�������main�߳���ִ
 *  ��asr.areValuesEqual�������бȽ�ʱ��ǡ��stepOne����ִ���꣬��stepTwo������û
 *  ִ�У���ô�õ��Ľ��ͬ��������false�����2����
 *
 *  �ܽ᣺�̵߳Ĺ���ͻָ�ʵ�ֵ���ȷ�����ǣ�ͨ�����ñ�־λ�����߳��ڰ�ȫ��λ�ù���
 */

public class DeprecatedSuspendResume extends Object implements Runnable{

    //volatile�ؼ��֣���ʾ�ñ��������ڱ�һ���߳�ʹ�õ�ͬʱ������һ���߳��޸�
    private volatile int firstVal;
    private volatile int secondVal;

    //�ж϶����Ƿ����
    public boolean areValuesEqual(){
        return ( firstVal == secondVal);
    }

    public void run() {
        try{
            firstVal = 0;
            secondVal = 0;
            workMethod();
        }catch(InterruptedException x){
            System.out.println("interrupted while in workMethod()");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true){
            stepOne(val);
            stepTwo(val);
            val++;
            Thread.sleep(200);  //�ٴ�ѭ��ǰ����200����
        }
    }

    //��ֵ������300���룬�Ӷ�ʹ�߳��л�����stepOne������stepTwo����֮�䱻����
    private void stepOne(int newVal) throws InterruptedException{
        firstVal = newVal;
        Thread.sleep(300);  //ģ�ⳤʱ�����е����
    }

    private void stepTwo(int newVal){
        secondVal = newVal;
    }

    public static void main(String[] args){
        DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
        Thread t = new Thread(dsr);
        t.start();

        //����1�룬�������߳��л�����ִ��
        try {
            Thread.sleep(1000);}
        catch(InterruptedException x){}
        for (int i = 0; i < 10; i++){
            //�����߳�
            t.suspend();
            System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());
            //�ָ��߳�
            t.resume();
            try{
                //�߳��������0~2��
                Thread.sleep((long)(Math.random()*2000.0));
            }catch(InterruptedException x){
                //��
            }
        }
        System.exit(0); //�ж�Ӧ�ó���
    }


    /**
     * ��ֹ�߳�
     * ������Thread��start����������ִ����run���������󣬻���run����������return��
     * �̱߳����Ȼ����������Thread API�а�����һ��stop��������������ͻȻ��ֹ�̡߳�
     * ������JDK1.2��㱻��̭�ˣ���Ϊ�����ܵ������ݶ���ı�����һ�������ǣ����߳���
     * ֹʱ�������л���ִ������������һ�������ǣ�����ĳ���߳��ϵ���stop��������ʱ
     * ���߳��ͷ�����ǰ���е���������������Щ���ض���ĳ�ֺ��ʵ����ɡ���Ҳ������ֹ��
     * ���̷߳�����δ����һ����״̬�����ݣ�ͻȻ�ͷ�������ʹĳЩ�����е����ݴ��ڲ�һ
     * ��״̬�����Ҳ���������ݿ��ܱ������κξ��档
     * ��ֹ�̵߳����������ͬ����ʹ�ñ�־λ��ͨ�����Ʊ�־λ����ֹ�̡߳�
     */
}