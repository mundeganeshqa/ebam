package com.bikkadit.ebam.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.bikkadit.ebam.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Eneterd username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			assertTrue(true);
			logger.info("Test has passed");
		}
		else
			assertTrue(false);
			logger.info("Test has failed");
		}
	
}
