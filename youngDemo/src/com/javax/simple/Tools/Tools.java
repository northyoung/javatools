package com.javax.simple.Tools;

public class Tools {

	/**
	 * 字符串反转工具类
	 * 效率比较高
	 */
	public static String ReverseString(String str){		
		int strLen = str.length() - 1;
		StringBuffer stringBuffer = new StringBuffer();
		while(strLen>=0){
			stringBuffer.append(str.charAt(strLen--));
		}
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Tools.ReverseString("ab232323231cde"));
	}
}
