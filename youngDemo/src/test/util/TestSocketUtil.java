package test.util;

import static org.junit.Assert.*;

import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

import com.util.net.SocketUtil;
import com.util.net.UDPReceDemo;
import com.util.net.UDPSendDemo;

public class TestSocketUtil {

//	@Test
//	public void test() {
//		SocketUtil socketUtil = new SocketUtil();
//		try {
//			socketUtil.getLocalIp();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

	@Test
	public void testSend() throws SocketException, UnknownHostException{
		UDPSendDemo uDPSendDemo = new UDPSendDemo();
		uDPSendDemo.SendMessage();
	}
	
	@Test
	public void testRece() throws SocketException, UnknownHostException{
		UDPReceDemo uDPReceDemo = new UDPReceDemo();
		uDPReceDemo.ReceMessage();
	}
	
}
