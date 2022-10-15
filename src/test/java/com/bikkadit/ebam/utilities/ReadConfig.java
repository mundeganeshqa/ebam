package com.bikkadit.ebam.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is "+ e.getMessage());
		}
		
		
	}
	public String getAppliactionURL() {
		// TODO Auto-generated method stub
		String url = pro.getProperty("baseUrl");
		return url;		
	}
	
	public String getusername() {
		// TODO Auto-generated method stub
		String username = pro.getProperty("username");
		return username;		
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		String pwd = pro.getProperty("password");
		return pwd;		
	}
	public String getChromepath() {
		// TODO Auto-generated method stub
		String chrome = pro.getProperty("chromepath");
		return chrome;		
	}
	public String getfirefoxPath() {
		// TODO Auto-generated method stub
		String firefox = pro.getProperty("firefoxpath");
		return firefox;		
	}
	

}
