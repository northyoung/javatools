package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 * �����ж�
 *
 * ����߳��ڵ���sleep��������ǰ���жϣ���ô���жϳ�Ϊ�����жϣ������ڸյ���sleep��������ʱ�������׳�InterruptedException�쳣��
 *
 * ����ģʽ�£�main�߳��ж����������˽��жϱ�־������Thread���ڲ���־������Ϊtrue�⣬
 * û�������κ�Ӱ�졣�̱߳��ж��ˣ���main�߳���Ȼ���У�main�̼߳�������ʵʱʱ�ӣ�����
 * ��try�飬һ������sleep�������������ͻ�ע�⵽�����жϵĴ��ڣ����׳�InterruptException
 * ������ִ����ת��catch�飬����ӡ���̱߳��жϵ���Ϣ����󣬼��㲢��ӡ��ʱ���
 */
public class PendingInterrupt {

    public static void main(String[] args){
        if(args.length > 0 ){
            Thread.currentThread().interrupt();
        }
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("was not interrupt");
        } catch (InterruptedException e) {
            System.out.println("was interrupt");
            e.printStackTrace();
        }
        //����ʱ��
        System.out.println("elapsedTime = " + (System.currentTimeMillis() - startTime));
    }
}
