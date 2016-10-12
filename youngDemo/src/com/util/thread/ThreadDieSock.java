package com.util.thread;
/**
 * 
 * 一个锁死的示例
 * @author root
 *
 */
public class ThreadDieSock implements Runnable {
	
    private int flag = 1;
    private Object obj1 = new Object(), obj2 = new Object();
    
	public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (obj1) {
                System.out.println("我已经锁定obj1，休息0.5秒后锁定obj2去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (obj2) {
                System.out.println("我已经锁定obj2，休息0.5秒后锁定obj1去！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("0");
                }
            }
        }
    }
	
    public static void main(String[] args) {
        ThreadDieSock run01 = new ThreadDieSock();
        ThreadDieSock run02 = new ThreadDieSock();
        run01.flag = 1;
        run02.flag = 0;
        Thread thread01 = new Thread(run01);
        Thread thread02 = new Thread(run02);
        System.out.println("线程开始喽！");
        thread01.start();
        thread02.start();
    }
    
}


/**
 *死锁：常见情景之一：同步的嵌套。 
 *
 */  
class DeadLockDemo   
{  
    public static void main(String[] args)   
    {  
        Ticket t = new Ticket();  
//      System.out.println("t:"+t);  
  
        Thread t1 = new Thread(t);  
        Thread t2 = new Thread(t);  
  
        t1.start();  
        try{Thread.sleep(10);}catch(InterruptedException e){}  
        t.flag = false;  
        t2.start();  
    }  
}
class Ticket implements Runnable  
{  
    private  int num = 100;  
    Object obj = new Object();  
    boolean flag = true;  
    public void run()  
    {  
  
  
        if(flag)  
            while(true)  
            {  
                synchronized(obj)  
                {  
                    show();   //show中使用了对象的this锁  和 obj 产生了死锁
                }  
            }  
        else  
            while(true)  
                this.show();  
    }  
  
    public synchronized void show()  
    {  
  
        synchronized(obj)  
        {  
            if(num>0)  
            {  
                try{Thread.sleep(10);}catch (InterruptedException e){}  
                  
                System.out.println(Thread.currentThread().getName()+".....sale...."+num--);  
            }  
        }  
    }  
}  
  
  

