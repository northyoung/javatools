package com.util.thread;

public class ThreadProducerConsumer {
	public static void main(String[] args) {
		Resourse resourse = new Resourse();
		Customer customer = new Customer(resourse);
		Producer producer = new Producer(resourse);
		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(producer);
		Thread thread3 = new Thread(customer);
		Thread thread4 = new Thread(customer);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}

class Resourse {
	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void Set(String name){
		if(flag){
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
		this.name = name + count;
		count++;
		System.out.println(Thread.currentThread().getName() + "...生产者..."+this.name);
		flag = true;
		notifyAll();
	}

	public synchronized void Out(){
		if(!flag){
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
		System.out.println(Thread.currentThread().getName() + "...消费者..."+this.name);
		flag = false;
		notifyAll();
	}
}

class Customer implements Runnable{
	private Resourse r;
	public Customer(Resourse r){
		this.r = r;
	}
	@Override
	public void run() {
		while(true){
			r.Set("烤鸭");
		}
	}
	
}

class Producer implements Runnable{
	private Resourse r;
	public Producer(Resourse r){
		this.r = r;
	}
	@Override
	public void run() {
		while(true){
			r.Out();			
		}
	}
	
}