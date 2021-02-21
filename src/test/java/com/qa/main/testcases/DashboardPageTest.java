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

public class DashboardPageTest extends BaseTest {
	SignInPage signInPage;
	HomePage homePage;
	TestUtil testUtil;
	DashBoardPage dashBoardpage;

	public DashboardPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		Reporter.log("***********Start Dashboard Page Test************",true);
		initialization();
		Reporter.log("Launch App",true);
		testUtil = new TestUtil();
		dashBoardpage = new DashBoardPage();
		signInPage = new SignInPage();
		homePage = signInPage.SignIn(prop.getProperty("signinemail"), prop.getProperty("signinpassword"));
		//dashBoardpage = homePage.clickOnDashboardSubItem("Test dashboard");
	}
	
		
	@Test(priority=1, description="Verify DashBoard Title before performing any opration on Dashboard Page")
	@Description("****Verify DashBoard Title ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Verify dashboard")
	@Severity(SeverityLevel.NORMAL)
	public void verifyDashBoardTest(){
		String seldashBoardTitle = homePage.verifyDashBoardTitle(prop.getProperty("testdashboardname"));
		Assert.assertEquals(seldashBoardTitle, prop.getProperty("testdashboardname"));
		Reporter.log("Dashboard displayed :"+seldashBoardTitle,true);
	}
	
	@Test(priority=2, description="Verify learn Links on dashboard Page feature")
	@Description("**** Verify learn Links feature ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Click learn Links")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLearnLinksTest() {
		dashBoardpage.verifyLearnLinks(prop.getProperty("learnlinks"));	
		Reporter.log("Launch Learn Link :"+"Dashboard",true);
	}
	
	@Test(priority=3, description="Set Dashboard page as HomePage")
	@Description("****Verify Set Dashboard page as HomePage ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Set as HomePage")
	@Severity(SeverityLevel.NORMAL)
	public void verifySethomeBtnTest() {
		dashBoardpage.verifyHomebutton();
		String successmsg = dashBoardpage.verifysuccessmsg();
		//Assert.assertEquals(successmsg, prop.getProperty("homepagesetmsg"));
		Reporter.log("Set dashboard Page as HomePage, Success message dispalyed :"+successmsg,true);
	}
	
	@Test(priority=4, description="Verify Create duplicate Dashboard page")
	@Description("**** Verify Create duplicate Dashboard page ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Create Duplicate dashboard and verify")
	@Severity(SeverityLevel.NORMAL)
	
		public void verifyduplicateDashboardTest() {
			dashBoardpage.verifyDuplicateDashboardbutton(prop.getProperty("duplicatedashboardname"));	
			homePage.verifyDashBoardTitle(prop.getProperty("duplicatedashboardname"));		
			Reporter.log("Create duplicate dashboard",true);
		}
	
	@Test(priority=5, description="Verify Share with you button")
		@Description("**** Verify Share with you button ****")
		@Epic("EP003")
		@Feature("Feature:DashBoardPage")
		@Story("Story: Verify Share with you button")
		@Severity(SeverityLevel.NORMAL)
		
			public void verifySharedwithYouTest() {
				dashBoardpage.verifysharedwithyouBtn();	
				Reporter.log("Click on Shared with you button",true);
			}
		
	@Test(priority=6, description="Verify Export data feature")
	@Description("**** Verify Export data feature ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Export dashboard in pdf,xls and csv form")
	@Severity(SeverityLevel.NORMAL)
	
	public void verifyExportdataTest() {
		dashBoardpage.verifyexportDataBtn(prop.getProperty("exportfilenme"));	
		Reporter.log("Export file",true);
	}

	//@Test(priority=7, description="Verify Exported data-download file feature")
	@Description("**** Verify download file feature ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Download file and verify in new webpage")
	@Severity(SeverityLevel.NORMAL)
	public void verifyExportdataDownloadTest() {
		dashBoardpage.verifydownloadfile(prop.getProperty("exportfilenme"));	
		Reporter.log("Download file",true);
	}
	
	@Test(priority=8, description="Verify Delete dashboard feature")
	@Description("**** Verify delete dashboard feature ****")
	@Epic("EP003")
	@Feature("Feature:DashBoardPage")
	@Story("Story: Delete dashboard and verify ")
	@Severity(SeverityLevel.NORMAL)
	public void verifyDeleteDashboardTest() {
		dashBoardpage.verifydeletedashboard();	
		String deletmsg = dashBoardpage.verifysuccessmsg();
		//Assert.assertEquals(deletmsg, prop.getProperty("deldashboardmsg"));
		Reporter.log("Delete dashboard success message dispalyed :"+deletmsg,true);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		Reporter.log("Close App",true);
	}
}
