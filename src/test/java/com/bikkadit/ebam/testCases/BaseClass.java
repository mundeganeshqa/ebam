package com.bikkadit.ebam.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bikkadit.ebam.utilities.ReadConfig;

public class BaseClass {

	ReadConfig config = new ReadConfig();
	public static WebDriver driver;
	public static Logger logger;	
	
	
	public String baseUrl = config.getAppliactionURL();
	public String username = config.getusername();
	public String password = config.getPassword();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {		
		
		logger = Logger.getLogger("ebam");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",config.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",config.getfirefoxPath());
			driver=new FirefoxDriver();
			}
		
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
