package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 * 待决中断
 *
 * 如果线程在调用sleep（）方法前被中断，那么该中断称为待决中断，它会在刚调用sleep（）方法时，立即抛出InterruptedException异常。
 *
 * 这种模式下，main线程中断它自身。除了将中断标志（它是Thread的内部标志）设置为true外，
 * 没有其他任何影响。线程被中断了，但main线程仍然运行，main线程继续监视实时时钟，并进
 * 入try块，一旦调用sleep（）方法，它就会注意到待决中断的存在，并抛出InterruptException
 * 。于是执行跳转到catch块，并打印出线程被中断的信息。最后，计算并打印出时间差
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
        //结束时间
        System.out.println("elapsedTime = " + (System.currentTimeMillis() - startTime));
    }
}
