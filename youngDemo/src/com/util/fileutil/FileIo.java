package com.util.fileutil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/**
 * 
 * @author root
 * IO相关的操作
 */
public class FileIo {

	public static String s = File.separator;
	
	/**
	 * 
	 */
	public static void testInputReadLine(){
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader (new FileReader("E:" + s + "dic" + s + "6.dic"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sBufferedReader = null;
		try {
			while((sBufferedReader = bufferedReader.readLine()) != null){			
				System.out.println(sBufferedReader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testInput(){
		int a = 0;
		// 读入 D盘下有个java.txt文件，现在按字节读入：
		FileInputStream fileInputStream;
		//输入流
		try {
			fileInputStream = new FileInputStream("D:"+ s +"java.java");
			while((a = fileInputStream.read())!= -1){
				System.out.print((char)a);
			}
			System.out.println("\n\n----------------------");
			FileReader fileReader = new FileReader("D:"+ a +"java.java");
			while((a=fileReader.read())!= -1){
				System.out.print((char)a);
			}
			System.out.println("\n\n----------------------");
			fileInputStream.close();
			fileReader.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	private static void testOutput(){
		int a =0;
		File file = new File("D:" + s +"testFile"+s+ "javatest.txt");
		if(!file.exists()){
			file.getParentFile().mkdirs();
			System.out.println(file.getParentFile());
			try{
				file.createNewFile();
				FileOutputStream fileout = new FileOutputStream(file);
				FileInputStream fileinp = new FileInputStream("D:"+s+"java.java");
				while((a=fileinp.read())!=-1){
					fileout.write(a);
				}
				FileWriter fileWriter = new FileWriter("D:" + s +"testFile"+s+ "javatest.txt");
				for(int i=0;i<65535;i++){
					fileWriter.write(i);
				}
				FileWriter f23 = new FileWriter("D:" + s + "testFile" + s + "test3.txt");
				f23.write("Hello,world!");
				
				fileout.close();
				fileinp.close();
				fileWriter.close();
				f23.close();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else{
			System.out.println("文件已经存在");
		}
	}
	/**
	 * 
	 */
	private static void testBuffering(){
		int a = 0,counter = 0 ;
		//缓冲字符，实现高效写入
		BufferedWriter bufferedwriter;
		try {
			bufferedwriter = new BufferedWriter(new FileWriter("D:" + s + "testFile" + s + "test4.txt"));
			for(int i=1;i<=100;i++){
				bufferedwriter.write(String.valueOf(new Random().nextInt(100))+" ");
				if(i % 10 ==0){
					bufferedwriter.newLine();
				}
			}
			bufferedwriter.flush();
			bufferedwriter.close();		
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:" + s + "testFile" + s + "test4.txt"));
			String sBufferedReader;
			while((sBufferedReader = bufferedReader.readLine())!=null){
				System.out.println(sBufferedReader);
			}
			bufferedReader.close();
			System.out.println("\n------------------------------");			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	private static void testZip(){
		try{
			File f1 = new File("D:/test.zip");
			File f2 = new File("D:/testFile");
			ZipFile zf = new ZipFile(f1);
			testZipToUnZip(zf,f2);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	// 将压缩包zipfile解压到file中
	private static void testZipToUnZip(ZipFile zipfile, File file) {
		// TODO Auto-generated method stub
		ZipEntry zentry = null;
		File zipout;
		InputStream zis= null;
		FileOutputStream fos = null;
		Enumeration enu = zipfile.entries();
		while (enu.hasMoreElements()){
			zentry = (ZipEntry) enu.nextElement();
			System.out.println(zentry.getName());
			zipout = new File(file+s+zentry.getName());
			if(!zentry.isDirectory()){
				try{
					zis = zipfile.getInputStream(zentry);
					if(!zipout.exists()){
						zipout.getParentFile().mkdirs();
					}
					fos = new FileOutputStream(zipout);
					byte[] b = new byte[1024];
					int length;
					while((length = zis.read(b))>0){
						fos.write(b,0,length);
					}
					fos.close();
					zis.close();
				}catch(ZipException e){
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}else{
				System.out.println("不是有效的文件夹");
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		//testInput();
		//testOutput();
		//testBuffering();
		//testZip();
	}

}
