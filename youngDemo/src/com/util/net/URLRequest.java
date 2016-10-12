package com.util.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLRequest {
	/**
	 * 获取网页的源代码
	 * @param url
	 * @throws MalformedURLException
	 */
	public void SendRequest(String url) throws MalformedURLException{
		URL tempUrl = new URL(url); 
		System.out.println("getProtocol:"+tempUrl.getProtocol());
		System.out.println("getHost:"+tempUrl.getHost());
		System.out.println("getPort:"+tempUrl.getPort());
		System.out.println("getPath:"+tempUrl.getPath());
		System.out.println("getQuery:"+tempUrl.getQuery());
			
		try {
			URLConnection conn = tempUrl.openConnection();
			InputStream in = conn.getInputStream();
			byte[] buf = new byte[1024];
			while(in.read(buf) != -1){
				int len = in.read(buf);
				String text = new String(buf, 0, len);
				System.out.print(text);				
			}
			in.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
