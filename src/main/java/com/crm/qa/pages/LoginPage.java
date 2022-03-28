package com.crm.qa.pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='loginForm:accountId']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='loginForm:password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='loginForm:loginButton']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@id='quicklinkButton']")
	WebElement quicklinkButton;
	
	@FindBy(xpath="//li[@class='panel quickLinkCategoryManage']")
	WebElement quickLinkCategoryManage;
	
	@FindBy(xpath="//a[contains(text(),'Create Identity')]")
	WebElement createIdentity;
	
	@FindBy(xpath="//a[contains(text(),'View Identity')]")
	WebElement ViewIdentity;
	
	
	@FindBy(xpath="(//label[contains(@for,'name')]/following-sibling::input)[1]")
	WebElement identityName;
	
	@FindBy(xpath="(//label[contains(@for,'password')]/following-sibling::input)[1]")
	WebElement identityPassword;
	
	@FindBy(xpath="(//label[contains(@for,'passwordConfirm')]/following-sibling::input)[1]")
	WebElement identityConfirmPassword;
	
	@FindBy(xpath="(//label[contains(@for,'firstname')]/following-sibling::input)[1]")
	WebElement firstName;
	
	@FindBy(xpath="(//label[contains(@for,'lastname')]/following-sibling::input)[1]")
	WebElement lastName;
	
	@FindBy(xpath="(//label[contains(@for,'email')]/following-sibling::input)[1]")
	WebElement email;
	
	@FindBy(xpath="(//label[contains(@for,'displayName')]/following-sibling::input)[1]")
	WebElement displayName;
	
	@FindBy(xpath="(//label[contains(@for,'softwareVersion')]/following-sibling::input)[1]")
	WebElement softwareVersion;
	
	@FindBy(id="DefaultAttributesForm-form-administrator-field")
	WebElement administrator;
	
	@FindBy(xpath="//button[@id='submitBtn']")
	WebElement submitBtn;
	
	@FindBy(xpath="//li[@class='formInfo']")
	WebElement formInfo;
	
	@FindBy(xpath="//input[@id='searchInput']")
	WebElement searchInput;
	
	@FindBy(xpath="//button[@id='searchBtn']")
	WebElement searchBtn;
	
	@FindBy(xpath="//p[contains(@class,'identity-title')]")
	WebElement title;
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public void login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
	
	public void createIdentity(String identityname) throws InterruptedException
	{
		quicklinkButton.click();
		quickLinkCategoryManage.click();
		createIdentity.click();
		Thread.sleep(5000);
		identityName.sendKeys(identityname);
		identityPassword.sendKeys("identityPassword");
		identityConfirmPassword.sendKeys("identityPassword");
		firstName.sendKeys("firstName");
		lastName.sendKeys("lastName");
		email.sendKeys("test@gmail.com");
		displayName.sendKeys(identityname);
		softwareVersion.sendKeys("softwareVersion");
		submitBtn.click();
		Thread.sleep(3000);
		Assert.assertEquals(formInfo.getText(), "Create identity request submitted");
	}
	
	public void verifyIdentity(String identityName, String displayName) throws InterruptedException
	{
		quicklinkButton.click();
		quickLinkCategoryManage.click();
		ViewIdentity.click();
		searchInput.sendKeys(identityName);
		searchBtn.click();
		Thread.sleep(3000);
		Assert.assertEquals(title.getText(), displayName);
	}
	
}
