package com.util.thread;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		Demo d = new Demo();
		Thread thread1 = new Thread(d);
		Thread thread2 = new Thread(d);
		thread1.start();
		thread1.join();		//等待thread1线程结束，加入线程thread2
		thread2.start();
//		thread2.start();
	}
}

class Demo implements Runnable {

	@Override
	public void run() {
		for(int x=0;x<50;x++){
			System.out.println(Thread.currentThread().toString()+"..."+x);
			Thread.yield();
		}
	}
}