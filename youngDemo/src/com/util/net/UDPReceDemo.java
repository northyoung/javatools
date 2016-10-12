package com.util.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPReceDemo {
	
	public static void main(String[] args) throws SocketException, UnknownHostException{
		System.out.println("UDP接收服务启动");
		/*
		 * 1.建立UDP的socket服务
		 * 2.将要发送的数据封装到数据包中
		 * 3.通过udp的socket服务receive方法将数据包接收
		 * 4.通过数据包方法解析数据
		 * 5.关闭socket
		 */
		//1.UDP使用DatagramSocket对象
		DatagramSocket datagramSocket = new DatagramSocket(13000);	
		//2.封装数据DatagramPacket对象
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		//3.通过udp的socket服务receive方法将数据包接收
		try {
			datagramSocket.receive(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.通过数据包方法解析数据
		String ip = datagramPacket.getAddress().getHostAddress();
		int port = datagramPacket.getPort();
		String text = new String(datagramPacket.getData(),0,datagramPacket.getLength());
		System.out.println(ip+":"+port+":"+text);
		//5.关闭socket
		datagramSocket.close();
	}
	
	public void ReceMessage() throws SocketException, UnknownHostException{		
		System.out.println("UDP接收服务启动");
		/*
		 * 1.建立UDP的socket服务
		 * 2.将要发送的数据封装到数据包中
		 * 3.通过udp的socket服务receive方法将数据包接收
		 * 4.通过数据包方法解析数据
		 * 5.关闭socket
		 */
		//1.UDP使用DatagramSocket对象
		DatagramSocket datagramSocket = new DatagramSocket(13000);	
		//2.封装数据DatagramPacket对象
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		//3.通过udp的socket服务receive方法将数据包接收
		try {
			datagramSocket.receive(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.通过数据包方法解析数据
		String ip = datagramPacket.getAddress().getHostAddress();
		int port = datagramPacket.getPort();
		String text = new String(datagramPacket.getData(),0,datagramPacket.getLength());
		System.out.println(ip+":"+port+":"+text);
		//5.关闭socket
		datagramSocket.close();
	}
}
