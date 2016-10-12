package com.util.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.map.ObjectMapper;

import com.util.fileutil.PropertiesUtil;
import com.web.beans.SendRequestBeans;

public class SendRequest {
	
	/**
	 * 
	 * @param url 发送的url
	 * @param method 发送的方式 post 或者 get
	 * @throws Exception 
	 */
	public boolean SendReq(String url,String method,String username,String pass) throws Exception{
		
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		
        final String encode = "utf-8";
        final int connectTimeOut = 15000;
        final int readDataTimeOut = 50000;
        String website = "http://"+url;

        HttpURLConnection httpConn = null;
        BufferedReader htmlContent = null;
        String requestCookie = null;
        String reqUrl = "";
        String result = "";
        /**
         * 读取配置文件中的请求头信息
         */
        Properties prop = propertiesUtil.GetPropertiesFile("request.properties");
        
		if(method.equals("POST")){
			URL urltemp = new URL(website+reqUrl);
			httpConn = (HttpURLConnection)urltemp.openConnection();
			//Sets the value of the doInput field for this URLConnection to the specified value.
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			httpConn.setUseCaches(false);
            httpConn.setConnectTimeout(connectTimeOut);
            httpConn.setReadTimeout(readDataTimeOut);
            
            //2.设置请求头
            httpConn.setRequestProperty("Host", prop.getProperty("Host"));
            httpConn.setRequestProperty("User-Agent", prop.getProperty("User-Agent"));
            httpConn.setRequestProperty("Accept", prop.getProperty("Accept"));
            httpConn.setRequestProperty("Accept-Language", prop.getProperty("Accept-Language"));
            httpConn.setRequestProperty("Accept-Encoding", prop.getProperty("Accept-Encoding"));
            httpConn.setRequestProperty("Cookie", prop.getProperty("Cookie"));
            httpConn.setRequestProperty("Connection", prop.getProperty("Connection"));
            httpConn.setRequestProperty("Cache-Control", prop.getProperty("Cache-Control"));
            System.out.println("Request url:"+website+reqUrl);
			//设置请求方式
            httpConn.setRequestMethod(method);
            //发送请求
            httpConn.connect();
            //设置请求参数
            OutputStream outStream = httpConn.getOutputStream();
            String postData = "username=" + username + "&&password="+pass;
            outStream.write(postData.getBytes());
            outStream.flush();
            outStream.close();            
            //获取响应头
            Map<String,List<String>> resHeaderMap = httpConn.getHeaderFields();
            System.out.println(resHeaderMap);
//            String a1 = httpConn.getResponseMessage();
            //获取响应结果
            if (HttpURLConnection.HTTP_OK == httpConn.getResponseCode())
            {
                htmlContent = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),"UTF-8"));
                String line;
                while ((line = htmlContent.readLine()) != null) {
                    result += line;
                    System.out.println(result);
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            SendRequestBeans sendRequestBeans = mapper.readValue(result, SendRequestBeans.class);
            System.out.println(sendRequestBeans.getState());
            if("success".equals(sendRequestBeans.getState())){
            	return true;
            } else {
        		return false ;
            }
            
		} else {
			throw(new Exception("暂时不支持GET方法"));
		}
	}
}
