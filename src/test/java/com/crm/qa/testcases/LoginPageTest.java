package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.qa.ExtentReportListener.ExtentReporterNG;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	ExtentReporterNG ExtentObj;
	Random random = new Random();  
	
	public LoginPageTest(){
		super();
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		loginPage = new LoginPage();
		ExtentObj= new ExtentReporterNG();
		
		
		String name= "IdentityName" + random.nextInt(10000);
		System.out.println(loginPage.validateLoginPageTitle());
		AssertJUnit.assertEquals("SailPoint IdentityIQ - Home", "SailPoint IdentityIQ - Home");
		loginPage.createIdentity(name);
		loginPage.verifyIdentity(name, name);
	}
}
