package com.util.thread;

/**
 * 懒汉式
 * 非线程安全
 */
class SingleLazy{
	public static SingleLazy single = null;
	private SingleLazy(){};
	public static SingleLazy getInstance(){
		return single = new SingleLazy();
	}
}

/**
 * 饿汉式
 * 线程安全
 */
class Single {
	public static final Single single = new Single();
	private Single(){};
	public static Single getInstance(){
		return single;
	}
}

/**
 * 懒汉式   
 * 多线程下的单例模式
 */
public class SingleThread {

	public static SingleThread single = null;
	
	private SingleThread (){}
	
	public static SingleThread getInstance(){
		if(single == null){   //在同步外进行判断，可以防止因为 加了线程同步变得低效
			synchronized (SingleThread.class) {
				if(single == null){    //同步锁保证了每次判断只有一个对象进入判断，防止两个对象同时进入，产生两个初始化
					single = new SingleThread();
				}
			}
		}
		return single;
	}

}