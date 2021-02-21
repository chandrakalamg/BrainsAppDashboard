package com.qa.main.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.main.base.BaseTest;
import com.qa.main.pages.DashBoardPage;
import com.qa.main.pages.HomePage;
import com.qa.main.pages.SignInPage;
import com.qa.main.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest extends BaseTest{
	SignInPage signInPage;
	HomePage homePage;
	TestUtil testUtil;
	DashBoardPage dashBoardpage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeClass
	public void setUp() {
		Reporter.log("********Start HomePage Test********");
		initialization();
		Reporter.log("********launch App********");
		testUtil = new TestUtil();
		signInPage = new SignInPage();
		homePage = signInPage.SignIn(prop.getProperty("signinemail"), prop.getProperty("signinpassword"));
	}
	
	@Test(priority=1,description="Verify UserName on HomePage")
	@Description("****Verify UserName on HomePage****")
	@Epic("EP002")
	@Feature("Feature:HomePage")
	@Story("Story: BrainsApp Homepage")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyHomePageUserNameTest(){
		String userTitle = homePage.verifyCorrectUserName();
		Assert.assertEquals(userTitle, prop.getProperty("signinemail"),"Failed");
		Reporter.log("User Title is :"+userTitle,true);
	}
	
	@Test(priority=2, description="Verify Dashboard dispalayed")
	@Description("****Verify DashBoard Name****")
	@Epic("EP002")
	@Feature("Feature:HomePage")
	@Story("Story: Expected Dashboard Page")
	@Severity(SeverityLevel.NORMAL)
	public void verifyDashBoardTest(){
		String newdashBoardTitle = homePage.verifyDashBoardTitle("Test dashboard");
		Assert.assertEquals(newdashBoardTitle, "Test dashboard");
		Reporter.log("Dashboard name :"+newdashBoardTitle,true);
	}
	/*
	//@Test(priority=3)
	@Description("****Create New Dashboard****")
	@Epic("EP002")
	@Feature("Feature:HomePage")
	@Story("Story: Create New dashboard Test1")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyCreateNewDashBoardTest() throws InterruptedException{
		homePage.clickOnDashboardSubItem("New Dashboard");	
	//	homePage.createNewDashBoard("Test1");
	  Reporter.log("New Dashboard name :"+newdashBoardTitle,true);
		
	}
	*/
	
	@Test(priority=3,description="Select already created Dashboard")
	@Description("****Select already created Dashboard****")
	@Epic("EP002")
	@Feature("Feature:HomePage")
	@Story("Story: Select dashboard")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySelectDashBoardTest() throws InterruptedException{
		homePage.clickOnDashboardSubItem(prop.getProperty("selexistingdashboard"));
		String seldashBoardTitle = homePage.verifyDashBoardTitle(prop.getProperty("selexistingdashboard"));
		Assert.assertEquals(seldashBoardTitle, prop.getProperty("selexistingdashboard"));
		Reporter.log("Dashboard name :"+seldashBoardTitle,true);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		Reporter.log("Close App",true);
	}
}
