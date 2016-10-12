package com.util.fileutil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static final String split = java.io.File.separator; 
	public Properties GetPropertiesFile(String fileName) throws IOException{
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);   
        Properties prop = new Properties();
        prop.load(in);
        return prop;
	}
}
