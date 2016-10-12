package com.util.classutil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//要获取print(int,int)方法 1.要获取一个方法，就是获取一个类的的信息，获取一个信息，首先是获取类类型
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2.获取方法 名称和参数列表决定
		 * getMethod 获取public方法
		 * getDeclaredMethod 获得自己声明的方法
		 */
		try {
			//Method m = c.getDeclaredMethod("print", int.class,int.class);
			Method m = c.getDeclaredMethod("print", new Class[]{int.class,int.class});
			//方法的反射操作
			//方法的反射操作时用m对象来进行方法调用。和a1.print调用效果完全相同。
			//Object o = m.invoke(a1, new Object[]{10,20});
			Object o = m.invoke(a1, 10,20);
			System.out.println("++++++++++++++");
			//获取方法print(String,String)
			Method m1 = c.getMethod("print",String.class,String.class);
			//用方法进行反射操作
			m1.invoke(a1, "Hello","World");
			
			Method m2 = c.getMethod("print");
			m2.invoke(a1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}
}
	
class A {
	public void print(int a,int b ){
		System.out.println(a+b);
	}
	public void print(String a ,String b){
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}
