package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 * 使用isInterrupted（）方法判断中断状态
 * 可以在Thread对象上调用isInterrupted（）方法来检查任何线程的中断状态。
 * 这里需要注意：线程一旦被中断，isInterrupted（）方法便会返回true，而一旦sleep（）
 * 方法抛出异常，它将清空中断标志，此时isInterrupted（）方法将返回false。
 *
 */
public class InterruptCheck {
    public static void main(String[] args){
        Thread mainThread = Thread.currentThread();
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
        //待决中断，中断自身
        mainThread.interrupt();
        //也可以使用Thread.interrupted（）方法判断中断状态
        //Thread.currentThread().interrupt();
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
        try {
            System.out.println("was NOT interrupted");
            mainThread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
            e.printStackTrace();
        }
        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("isInterrupted: " + mainThread.isInterrupted());
    }
    /**
     * 补充
     *   这里补充下yield和join方法的使用。
     *   join方法用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。
     *   yield可以直接用Thread类调用，yield让出CPU执行权给同等级的线程，如果没有相同级别的线程在等待CPU的执行权，则该线程继续执行。
     */
}
