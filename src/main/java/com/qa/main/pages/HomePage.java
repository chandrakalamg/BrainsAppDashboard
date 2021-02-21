package com.qa.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.main.base.BaseTest;


public class HomePage extends BaseTest{
	//Introduction page elements
	
	@FindBy(xpath="//button[@title='menna+automation@intellisense.io']")
	WebElement userBtn;

	@FindBy(xpath = "//ul/a/li[text()='Thickener 1 - Opportunity Dashboard (NK)' and @ng-click='log(subitem.link)']")
	WebElement dashboardItem2;

	@FindBy(xpath = "//ul/a/li[text()='New Dashboard' and @ng-click='log(subitem.link)']")
	WebElement newDashboard;
	
	//new dashboard Page
	
	@FindBy(id="name")
	WebElement newDashboardName;
	
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement dashBoardSubmitBtn;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCorrectUserName(){
		 String usertitle = userBtn.getAttribute("title");
		 System.out.println(usertitle);
		 return usertitle;
	}
	
	//click on DashboardMenu
	public void clickOnMenuIcon(String menuItem ) {
		WebElement mainIcon = driver.findElement(By.xpath("//i[@title='"+menuItem+"']"));
		WebElement mainIconLink = driver.findElement(By.xpath("//a[contains(text(),'"+menuItem+"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mainIcon).moveToElement(mainIconLink).click().build().perform();
	}
	
	//Click on Dashboard item - New dashBoard,Test DashBoard
	public DashBoardPage clickOnDashboardSubItem(String subitem){
		clickOnMenuIcon("Dashboards");
		WebElement dashboardselect = driver.findElement(By.xpath("//ul/a/li[text()='"+subitem+"' and @ng-click='log(subitem.link)']"));
		wait.until(ExpectedConditions.visibilityOf(dashboardselect));
		dashboardselect.isEnabled();
		dashboardselect.click();
		return new DashBoardPage();
	}
	
//	subitem - Thickener options
		public ThickenerPage clickOnThickenerItem(String subitem) {
			clickOnMenuIcon("Thickener");
			WebElement thickenerselect = driver.findElement(By.xpath("//li[@ng-click='log(subitem.link)' and text()='"+subitem+"']"));
			wait.until(ExpectedConditions.visibilityOf(thickenerselect));
			thickenerselect.click();
			return new ThickenerPage();
		}
	
		//subitem - Pump options
		public PumpPage clickOnPumpItem(String subitem) {
			clickOnMenuIcon("Pump");
			WebElement pumpselect = driver.findElement(By.xpath("//li[@ng-click='log(subitem.link)' and text()='"+subitem+"']"));
			wait.until(ExpectedConditions.visibilityOf(pumpselect));
			pumpselect.click();
			return new PumpPage();
		}
		
				//subitem - ProjectsPage options - New Project, existing Project
		public ProjectsPage clickOnProjectsItem(String subitem) {
			clickOnMenuIcon("Projects");
			WebElement projectselect = driver.findElement(By.xpath("//li[@ng-click='log(subitem.link)' and text()='"+subitem+"']"));
			wait.until(ExpectedConditions.visibilityOf(projectselect));
			projectselect.click();
			return new ProjectsPage();
		}

		public String verifyDashBoardTitle(String dashBoradtitle){
			 String dashBoardName=driver.findElement(By.xpath("//h1[text()='"+dashBoradtitle+"']")).getText();
				return dashBoardName;
		}
				
}
