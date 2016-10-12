package test.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.junit.Test;

import com.util.net.MyBrowerUtil;
import com.util.net.URLRequest;

public class URLUtilTest {

//	@Test
	public void test() throws MalformedURLException {
		URLRequest uRLRequest = new URLRequest();
		uRLRequest.SendRequest("http://www.baidu.com");
	}

	@Test
	public void test2() throws UnknownHostException, IOException{
		MyBrowerUtil myBrowerUtil = new MyBrowerUtil();
		myBrowerUtil.BrowerSend();
	}
}
