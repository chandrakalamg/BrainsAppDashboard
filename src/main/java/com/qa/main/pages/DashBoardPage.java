package com.qa.main.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.main.base.BaseTest;

public class DashBoardPage extends BaseTest {

	////Introduction page elements
	@FindBy(id="name")
	WebElement newDashboardName;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement dashBoardSubmitBtn;
	
	//dashboard page components
	@FindBy(xpath = "//ng-include[@ng-if='!dashboard.minimal']/div/li[1]")
	WebElement setAsHomePageBtn;
	
	
	@FindBy(xpath="//p[text()='Set this dashboard as your homepage?']")
	WebElement dashBoardsetHomePage;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement dashBoardSubwinOKBtn;
	
	@FindBy(xpath="//div[@class='alertify-logs bottom right']")
	WebElement successmsg;
	
	@FindBy(xpath = "//ng-include[@ng-if='!dashboard.minimal']/div/li[@title='Duplicate Dashboard']")
	WebElement duplicateDashboardBtn;
	
	@FindBy(xpath = "//h1[text()='Name Duplicate Dashboard']")
	WebElement nameDuplicateDashboardPage;
	
	@FindBy(id = "name")
	WebElement nameDuplicateDashboard;
	
	@FindBy(xpath = "//ng-include[@ng-if='!dashboard.minimal']/div/li[@title='Shared with you']")
	WebElement sharedwithyouBtn;
		
	@FindBy(xpath = "//ng-include[@ng-if='!dashboard.minimal']/div/li[@title='Export Data']")
	WebElement exportDataBtn;
	
	@FindBy(xpath = "//h2[text()='Export Data']")
	WebElement exportDataPage;
	
	@FindBy(xpath = "//p[text()='Report (PDF)']")
	WebElement reportPdfbtn;
	
	@FindBy(xpath = "//p[text()='Report (XLS)']")
	WebElement reportxlsbtn;
	
	@FindBy(xpath = "//p[text()='Raw Data (CSV)']")
	WebElement reportcsvbtn;
	
	@FindBy(xpath = "//span[@title='Edit Filename']")
	WebElement editfilename;
	
	@FindBy(xpath = "//div[@class='modal-footer clearfix']//button[text()='Save to Files']")
	WebElement savetofileBtn;
	
	@FindBy(xpath = "//div[@class='modal-footer clearfix']//button[text()='Cancel']")
	WebElement cancelExportfileBtn;
	
	
	@FindBy(xpath = "//div[text()='Download File']")
	WebElement downloadfileBtn;
	
	@FindBy(xpath = "//li[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//p[text()='Delete this dashboard?']")
	WebElement deletedashboardmodal;
	
	//frame elements
	
	@FindBy(name = "intercom-tour-frame")
	WebElement intercomFrame;
	
	@FindBy(xpath = "//div[text()='Hi Menna,']")
	WebElement intercomuser;
	
	@FindBy(xpath = "//div[text()='1 of 8']")
	WebElement intercomsteps;
	
	@FindBy(xpath = "//button[text()='Next']")
	WebElement intercomNext;
	
	@FindBy(xpath = "//div[@class='intercom-tour-step-header']/span[1]")
	WebElement intercomClose;
	
	@FindBy(xpath = "//div[text()='3 of 8']")
	WebElement intercomsteps3;
	
	// Initializing the Page Objects:
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//verify Dashboard Page components
		public void verifyHomebutton() {
			setAsHomePageBtn.click();
			driver.switchTo().activeElement();
			String dashboardsmsg =dashBoardsetHomePage.getText();
			System.out.println("dashboard :"+dashboardsmsg);
			wait.until(ExpectedConditions.visibilityOf(dashBoardSubwinOKBtn));
				//if(dashboardsmsg=="Set this dashboard as your homepage?")
					dashBoardSubwinOKBtn.click();
		}
		
		public String verifysuccessmsg() {
			wait.until(ExpectedConditions.invisibilityOf(dashBoardSubwinOKBtn));
			return successmsg.getText();
		}
		
		
		public void verifyDuplicateDashboardbutton(String dashboardname) {
			duplicateDashboardBtn.click();
			//driver.switchTo().activeElement();
			wait.until(ExpectedConditions.visibilityOf(dashBoardSubwinOKBtn));
			String duplicatedashboardPage =nameDuplicateDashboard.getText();
			System.out.println("dashboard :"+duplicatedashboardPage);
				//if(duplicatedashboardPage=="Name Duplicate Dashboard")
			
					nameDuplicateDashboard.sendKeys(dashboardname);
					dashBoardSubwinOKBtn.click();
		}
		
		public void verifysharedwithyouBtn() {
			boolean buttonenable = sharedwithyouBtn.isDisplayed();
				if(buttonenable)
					sharedwithyouBtn.click();
				else
					System.out.println("Shared with you button is disbaled");
		}
		
		public void verifyexportDataBtn(String exportdatafilename) {
			boolean buttonenable = exportDataBtn.isEnabled();
				if(buttonenable)
					exportDataBtn.click();
				
				wait.until(ExpectedConditions.visibilityOf(cancelExportfileBtn));
				
				String exportdataPage =exportDataPage.getText();
				System.out.println("export:"+exportdataPage);
					reportxlsbtn.click();
				//	editfilename.sendKeys(exportdatafilename);
					savetofileBtn.click();
					wait.until(ExpectedConditions.visibilityOf(downloadfileBtn));
					boolean downloadenable = downloadfileBtn.isDisplayed();
					if(!downloadenable)
						cancelExportfileBtn.click();
		}
		
		//verify new browser and dashboard header
		public void verifydownloadfile(String exportdatafilename) {
			boolean buttonenable = downloadfileBtn.isEnabled();
				if(buttonenable)
					downloadfileBtn.click();
				Set<String> winhndls = driver.getWindowHandles();
				System.out.println("window handles"+winhndls.size());
				//driver.switchTo().window(nameOrHandle)
			}
		
		public void verifydeletedashboard() {
			boolean buttonenable = deleteBtn.isEnabled();
				if(buttonenable)
					deleteBtn.click();
				wait.until(ExpectedConditions.visibilityOf(dashBoardSubwinOKBtn));
				String deldashboardsmsg =deletedashboardmodal.getText();
				System.out.println(" delete dashboard :"+deldashboardsmsg);
						dashBoardSubwinOKBtn.click();
						verifysuccessmsg();
			}
		
		public void verifyLearnLinks(String linkname) {
			//WebElement linktext = driver.findElement(By.xpath("//span[contains(text(),'"+linkname+"')]"));
			WebElement linktext = driver.findElement(By.xpath("//a[@class='product-tour'][1]"));
			wait.until(ExpectedConditions.visibilityOf(linktext));
			linktext.click();
						
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println("Total number of iframes are " + iframeElements.size());
		}
		
		public void verifyintecomPages() {
			//driver.switchTo().frame("intercomNext");
			wait.until(ExpectedConditions.visibilityOf(intercomFrame));
			switchToFrame();
			//verify intercom content - User Name
			String username = intercomuser.getText();
			String stepscount = intercomsteps.getText();
			Assert.assertEquals(username, "Hi Menna,");
			Assert.assertEquals(stepscount, "1 of 8");
			intercomNext.click();
			//
			switchToFrame();
			// Verify next intercom text
			System.out.println("text"+driver.findElement(By.xpath("//h1[text()='Welcome to Brains.app !']")).getText());
			intercomNext.click();
			//
			switchToFrame();

			// Verify next intercom text
			String stepscount1 = intercomsteps3.getText();
			System.out.println("Steps3:"+stepscount1);
			//close
			intercomClose.click();
			driver.switchTo().defaultContent();		
		}
		
}
