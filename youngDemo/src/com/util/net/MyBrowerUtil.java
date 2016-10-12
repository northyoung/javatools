package com.util.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowerUtil {
	
	public void BrowerSend() throws UnknownHostException, IOException{
		Socket socket = new Socket("www.oschina.com",80);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true); 
		out.println("Accept	text/css,*/*;q=0.1");		
		out.println("Accept-Encoding	gzip, deflate");		
		out.println("Accept-Language	zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");		
		out.println("Connection	keep-alive");		
		out.println("Cookie	oscid=wONuj%2FmzY%2B0dBnlUjI5ZqklATmRMfxGrzkh7yBq9%2FBnqj8F4QW1J2S3lmPHOCHDziIozN1KLHZa1dz3xX18ldQgM7%2Bud8bY1zSCjMpW78wZUKypvaqNYJw%3D%3D");		
		out.println("Host	www.oschina.net");		
		out.println("Referer	http://www.oschina.net/");		
		out.println("User-Agent	Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");		
		out.println("");
		out.println("");
		
		InputStream in = socket.getInputStream();		
		byte[] buf = new byte[1024];
		while(in.read(buf)!=-1){
			int len = in.read(buf);
			String str = new String(buf,0,len);
			System.out.print(str);
		}
	}
}

	

//
//
//
//
//

