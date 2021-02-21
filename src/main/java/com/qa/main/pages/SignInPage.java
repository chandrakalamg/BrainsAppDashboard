package com.qa.main.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.main.base.BaseTest;;
//import com.qa.main.pages.HomePage;

public class SignInPage extends BaseTest{
		
		//Page Factory - OR:
	
		@FindBy(name="email")
		WebElement useremail;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(xpath="//button[text()='Sign in']")
		WebElement signInBtn;
		
		
		@FindBy(xpath="//h3[@class='text-center' and @ng-hide='userTemp || needsToUpdatePassword']")
		WebElement signInPage;
		
		//homepage
		@FindBy(xpath="//button[@title='menna+automation@intellisense.io']")
		WebElement userBtn;
				
		@FindBy(xpath="//button[@ng-click='signOut()']")
		WebElement signOutBtn;
		
		@FindBy(xpath="//button[text()='OK']")
		WebElement signOutOKBtn;
		
		@FindBy(xpath="//p[text()='Do you really want to sign out?']")
		WebElement signOutPage;
		
		//Initializing the Page Objects:
		public SignInPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validatePageTitle(){
			return driver.getTitle();
		}
		
		public String validateSignInPage(){
			wait.until(ExpectedConditions.visibilityOf(signOutBtn));
			String SignInWithDetails = signInPage.getText()	;
			return SignInWithDetails;
		}
		
		
		public HomePage SignIn(String username, String pwd){
			useremail.sendKeys(username);
			password.click();
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", signInBtn);
	
			return new HomePage();
		}

		public void SignOut() {
			// TODO Auto-generated method stub
			userBtn.click();
			wait.until(ExpectedConditions.visibilityOf(signOutBtn));
			signOutBtn.click();
			String signoutmessage =signOutPage.getText();
			//if(signoutmessage=="Do you really want to sign out?")
				driver.switchTo().activeElement();
				wait.until(ExpectedConditions.visibilityOf(signOutOKBtn));
			signOutOKBtn.click();
			wait.until(ExpectedConditions.visibilityOf(signInBtn));
		}
		
	}

