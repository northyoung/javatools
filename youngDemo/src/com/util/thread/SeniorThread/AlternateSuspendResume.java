package com.util.thread.SeniorThread;

/**
 * Created by Administrator on 2016/11/6 0006.
 *
 * 挂起和恢复线程
 *
 * 从areValuesEqual（）返回的值有时为true，有时为false。以上代码中，
 * 在设置firstVal之后，但在设置secondVal之前，挂起新线程会产生麻烦，
 * 此时输出的结果会为false（情况1），这段时间不适宜挂起线程，但因为
 * 线程不能控制何时调用它的suspend方法，所以这种情况是不可避免的。
 *
 * 当然，即使线程不被挂起（注释掉挂起和恢复线程的两行代码），如果在
 * main线程中执行asr.areValuesEqual（）进行比较时，恰逢stepOne操作执
 * 行完，而stepTwo操作还没执行，那么得到的结果同样可能是false（情况2）。
 *
 * 下面我们给出不用上述两个方法来实现线程挂起和恢复的策略——设置标志位。
 * 通过该方法实现线程的挂起和恢复有一个很好的地方，就是可以在线程的指定
 * 位置实现线程的挂起和恢复，而不用担心其不确定性。
 */
public class AlternateSuspendResume extends Object implements Runnable {

    private volatile int firstVal;
    private volatile int secondVal;
    //增加标志位，用来实现线程的挂起和恢复
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
            //仅当贤臣挂起时，才运行这行代码
            waitWhileSuspended();

            stepOne(val);
            stepTwo(val);
            val++;

            //仅当线程挂起时，才运行这行代码
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

        //这是一个“繁忙等待”技术的示例。
        //它是非等待条件改变的最佳途径，因为它会不断请求处理器周期地执行检查，
        //更佳的技术是：使用Java的内置“通知-等待”机制
        while ( suspended ) {
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        AlternateSuspendResume asr =
                new AlternateSuspendResume();

        Thread t = new Thread(asr);
        t.start();

        //休眠1秒，让其他线程有机会获得执行
        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        for ( int i = 0; i < 10; i++ ) {
            asr.suspendRequest();

            //让线程有机会注意到挂起请求
            //注意：这里休眠时间一定要大于
            //stepOne操作对firstVal赋值后的休眠时间，即300ms，
            //目的是为了防止在执行asr.areValuesEqual（）进行比较时,
            //恰逢stepOne操作执行完，而stepTwo操作还没执行
            try { Thread.sleep(350); }
            catch ( InterruptedException x ) { }

            System.out.println("dsr.areValuesEqual()=" +
                    asr.areValuesEqual());

            asr.resumeRequest();

            try {
                //线程随机休眠0~2秒
                Thread.sleep(
                        ( long ) (Math.random() * 2000.0) );
            } catch ( InterruptedException x ) {
                //略
            }
        }

        System.exit(0); //退出应用程序
    }
}
