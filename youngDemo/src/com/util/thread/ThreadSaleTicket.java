package com.util.thread;

public class ThreadSaleTicket {
	public static void main(String args[]){
		TicketSale ticket = new TicketSale();
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		Thread t4 = new Thread(ticket);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class TicketSale implements Runnable {
	
	private int num = 100;
	Object obj = new Object();
	@Override
	public void run() {
		while(true){
			 synchronized (obj) {
				if(num>0){
					try{Thread.sleep(10);}catch(InterruptedException e){};
					System.out.println(Thread.currentThread().getName()+"..."+num--);	
				} else {
					System.out.println(Thread.currentThread().getName()+"...线程已经退出");
					break;
				}
			}
		}
	}
}