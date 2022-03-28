package com.crm.qa.testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	Random random = new Random();  
	
	public LoginPageTest(){
		super();
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		loginPage = new LoginPage();
		
		String name= "IdentityName" + random.nextInt(10000);
		System.out.println(loginPage.validateLoginPageTitle());
		Assert.assertEquals("SailPoint IdentityIQ - Home", "SailPoint IdentityIQ - Home");
		loginPage.createIdentity(name);
		loginPage.verifyIdentity(name, name);
	}
}
