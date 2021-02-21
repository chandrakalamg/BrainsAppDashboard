package com.qa.main.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.main.base.BaseTest;
import com.qa.main.pages.SignInPage;

import io.qameta.allure.*;

public class SignInPageTest extends BaseTest {
	SignInPage signInPage;
	
	public SignInPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		Reporter.log("********Start SignIn Page Test********",true);
		initialization();
		signInPage = new SignInPage();	
		Reporter.log("App launch",true);
	}
	
	@Test(priority=1, description="Verify Brains.App Page title")
	//Allure reporting	
	@Description("****Verify Brains.App Page title****")
	@Epic("EP001")
	@Feature("Feature:SignInPage")
	@Story("Story: User SignIn")
	@Severity(SeverityLevel.NORMAL)
	public void pageTitleTest(){
		//Reporter.log("********************************Verify Brains.App Page Title***************************************",true);
		String title = signInPage.validatePageTitle();
		Assert.assertEquals(title, "Brains.App");
		Reporter.log("Page Title is "+title,true);
	}

	@Test(priority=2, description="Verify SignIn page is dispalyed")
	@Description("****Verify SignIn page is dispalyed****")
	@Epic("EP001")
	@Feature("Feature:SignInPage")
	@Story("Story: User SignIn")
	@Severity(SeverityLevel.NORMAL)
	public void signInPageWithDetails(){
		String pageSignIn = signInPage.validateSignInPage();
		Assert.assertEquals(pageSignIn, "Sign-in with your account");
		Reporter.log("SugnInPage title is "+pageSignIn,true);
	}

	
	@Test(priority=3, description="SignIn using userEmail and password")
	@Description("****SignIn using userEmail and password****")
	@Epic("EP001")
	@Feature("Feature:SignInPage")
	@Story("Story: User SignIn")
	@Severity(SeverityLevel.CRITICAL)
	public void signInTest(){
		signInPage.SignIn(prop.getProperty("signinemail"), prop.getProperty("signinpassword"));
		Reporter.log("SignIn details:"+prop.getProperty("signinemail"),true);
	}
	
	
	@Test(priority=4, description="SignOut of Brains.App ")
	@Description("****SignOut of Brains.App****")
	@Epic("EP001")
	@Feature("Feature:SignOutPage")
	@Story("Story: User SignOut")
	public void signoutTest() {
		signInPage.SignOut();
		Reporter.log("Signout is successfull",true);
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		Reporter.log("Close App",true);
	}
	
}
