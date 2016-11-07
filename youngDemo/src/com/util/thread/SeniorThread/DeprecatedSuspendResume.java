package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 *  挂起和恢复线程
 *  Thread 的API中包含两个被淘汰的方法，它们用于临时挂起和重启某个线程，
 *  这些方法已经被淘汰，因为它们是不安全的，不稳定的。如果在不合适的时
 *  候挂起线程（比如，锁定共享资源时），此时便可能会发生死锁条件——其
 *  他线程在等待该线程释放锁，但该线程却被挂起了，便会发生死锁。另外，
 *  在长时间计算期间挂起线程也可能导致问题。
 *
 *  从areValuesEqual（）返回的值有时为true，有时为false。以上代码中，在设置
 *  firstVal之后，但在设置secondVal之前，挂起新线程会产生麻烦，此时输出的结
 *  果会为false（情况1），这段时间不适宜挂起线程，但因为线程不能控制何时调用
 *  它的suspend方法，所以这种情况是不可避免的。
 *
 *  当然，即使线程不被挂起（注释掉挂起和恢复线程的两行代码），如果在main线程中执
 *  行asr.areValuesEqual（）进行比较时，恰逢stepOne操作执行完，而stepTwo操作还没
 *  执行，那么得到的结果同样可能是false（情况2）。
 *
 *  总结：线程的挂起和恢复实现的正确方法是：通过设置标志位，让线程在安全的位置挂起
 */

public class DeprecatedSuspendResume extends Object implements Runnable{

    //volatile关键字，表示该变量可能在被一个线程使用的同时，被另一个线程修改
    private volatile int firstVal;
    private volatile int secondVal;

    //判断二者是否相等
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
            Thread.sleep(200);  //再次循环前休眠200毫秒
        }
    }

    //赋值后，休眠300毫秒，从而使线程有机会在stepOne操作和stepTwo操作之间被挂起
    private void stepOne(int newVal) throws InterruptedException{
        firstVal = newVal;
        Thread.sleep(300);  //模拟长时间运行的情况
    }

    private void stepTwo(int newVal){
        secondVal = newVal;
    }

    public static void main(String[] args){
        DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
        Thread t = new Thread(dsr);
        t.start();

        //休眠1秒，让其他线程有机会获得执行
        try {
            Thread.sleep(1000);}
        catch(InterruptedException x){}
        for (int i = 0; i < 10; i++){
            //挂起线程
            t.suspend();
            System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());
            //恢复线程
            t.resume();
            try{
                //线程随机休眠0~2秒
                Thread.sleep((long)(Math.random()*2000.0));
            }catch(InterruptedException x){
                //略
            }
        }
        System.exit(0); //中断应用程序
    }


    /**
     * 终止线程
     * 当调用Thread的start（）方法，执行完run（）方法后，或在run（）方法中return，
     * 线程便会自然消亡。另外Thread API中包含了一个stop（）方法，可以突然终止线程。
     * 但它在JDK1.2后便被淘汰了，因为它可能导致数据对象的崩溃。一个问题是，当线程终
     * 止时，很少有机会执行清理工作；另一个问题是，当在某个线程上调用stop（）方法时
     * ，线程释放它当前持有的所有锁，持有这些锁必定有某种合适的理由——也许是阻止其
     * 他线程访问尚未处于一致性状态的数据，突然释放锁可能使某些对象中的数据处于不一
     * 致状态，而且不会出现数据可能崩溃的任何警告。
     * 终止线程的替代方法：同样是使用标志位，通过控制标志位来终止线程。
     */
}