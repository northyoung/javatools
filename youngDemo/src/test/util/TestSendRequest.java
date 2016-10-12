package test.util;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.util.fileutil.PropertiesUtil;
import com.util.net.SendRequest;

public class TestSendRequest {
	
	
//	@Test
//	public void test1() throws IOException{
//		PropertiesUtil propertiesUtil = new PropertiesUtil();
//		Properties prop = propertiesUtil.GetPropertiesFile("request.properties");
//		String host = (String) prop.get("Host");
//		System.out.println(host);
//	}
	
	@Test
	public void test2() throws Exception{
		SendRequest sendRequest = new SendRequest();
		boolean flag = sendRequest.SendReq("localhost:8080/citicsp/core/login!ajaxLogin.action","POST", "dev", "dev");
		System.out.println(flag);
	}
}
