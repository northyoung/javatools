package com.javax.simple.Tools;

import java.util.Scanner;

import org.junit.Test;

/**
 * 20140929
 * 测试键盘输入
 * @author young
 *
 */
class KeyboardInputOutput {
	
	public static void main(String[] args){
		KeyboardInputOutput instance = new KeyboardInputOutput();
		instance.Instance();
	}
	
	public void Instance(){
		Scanner scan = new Scanner(System.in);
		//将输入的第一行交给String；
		String string1 = scan.nextLine();
		//将输入的第一个空白符为止的字符串交给String；
		String string2 = scan.next();		
		System.out.println(string1);
	}
	
}		
	
