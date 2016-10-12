package test.util;

import org.junit.Test;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void  TestMethod1() {
		System.out.println("111111111111");
	}
	
	public static void  TestMethod2(){
		System.out.println("222222222222");
	}
	
	public void  TestMethod3(){
		System.out.println("3333333333");
	}
	
	@Test
	public void test1(){
		TestMain t = new TestMain();
		t.TestMethod3();
	}
	
	@Test 
	public void test2(){
		TestMain.TestMethod1();
		TestMain.TestMethod2();
	}
}
//只能有一个public
class TestMain2 {
	
}
