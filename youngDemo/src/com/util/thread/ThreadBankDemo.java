package com.util.thread;


public class ThreadBankDemo{
	public static void main(String[] args){
		Cus c= new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}

class ThreadBank {
	/**
	 * 多线程典型案例之银行存钱
	 * 要求
	 * ：储户，两个，每个都到银行存钱每次存100，共存三次
	 */
	private int sum;
	public synchronized void add(int num){
		sum = sum + num;
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){}
		System.out.println("sum="+sum);
	}
}

class Cus implements Runnable{
	
	private ThreadBank b = new ThreadBank();
	public void run(){
		for(int x=0;x<3;x++){
			b.add(100);
		}
	}
}

