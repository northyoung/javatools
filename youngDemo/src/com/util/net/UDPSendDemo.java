package com.util.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {
	
	public static void main(String[] args) throws SocketException, UnknownHostException {
		UDPSendDemo uDPSendDemo = new UDPSendDemo();
		uDPSendDemo.SendMessage();
	}
	
	public void SendMessage() throws SocketException, UnknownHostException{
		System.out.println("UDP发送服务启动");
		/*
		 * 1.建立UDP的socket服务
		 * 2.将要发送的数据封装到数据包中
		 * 3.通过udp的socket服务将数据包发送出去
		 * 4.关闭socket
		 */
		//1.UDP使用DatagramSocket对象
		DatagramSocket datagramSocket = new DatagramSocket(13001);
		InetAddress ipother = InetAddress.getByName("192.168.1.6");
		//2.封装数据DatagramPacket对象
		String str = "udp测试信息";
		byte[] buf = str.getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.6"), 13000);
		//3.通过UDP的socket服务将数据包发出去。
		try {
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.关闭socket
		datagramSocket.close();
	}
}
