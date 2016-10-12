package com.util.net;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketUtil {
	/*
	 * IP地址也是对象
	 * 
	 * getLocalIp() 
	 */
	public void getLocalIp() throws UnknownHostException{
		//获取本地IP地址对象
		InetAddress ip = InetAddress.getLocalHost();
		String ipadd = ip.getHostAddress();
		System.out.println(ipadd);
		System.out.println(ip);
		//获取其他的IP "192.168.1.6"
		InetAddress ipother = InetAddress.getByName("192.168.1.6");
		System.out.println(ipother.getHostName() + "  " + ipother.getHostAddress());
	}
	
}
