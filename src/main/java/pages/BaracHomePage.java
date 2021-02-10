package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BaracHomePage extends ProjectWrapp{
	public  BaracHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public BaracHomePage verifyLoginFail(){
		verifyTextByXpathExplicitwait(prop.getProperty("login.fail.message.xpath"),"Unable to login, please verify that your  User ID and Password is correct.");

				return this;
			}	
	public BaracHomePage enterUserName(String GroupId) throws InterruptedException{

		logid=GroupId;
		//loadingMethod("goupid");
		Boolean a=driver.getPageSource().contains("Forgot");
	//	Boolean a=VerifyElementpresentreturn(prop.getProperty("Enter.username.xpath"));

		if(a){
			
		}

		else{
		System.out.println("url will reload again");	
			getnewurl();
			Thread.sleep(2000);
			Boolean b=driver.getPageSource().contains("Forgot");
			booleanLogoutNoElementResult(b,"Login page has displaying Blank Page");
			
		}
	
	enterByXpathExplict(prop.getProperty("Enter.username.xpath"),GroupId);
		return this;
	}
	
	public BaracHomePage enterPassword(String Password){
		logpwd=Password;
	//	waitForJSandJQueryToLoad();
		enterByXpathExplict(prop.getProperty("Enter.pwd.xpath"),Password);
		
		
		return this;
	}
	
public BaracHomePage clickSecureCheckBox() throws InterruptedException{
		
	
	clickByXpathExplict(prop.getProperty("Click.checkbox.login.xpath"));
	
		
		return this;
	}
	


public BaracDashboard clickLoginButton() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("button.login.xpath"));
//	Thread.sleep(1000);
	System.out.println("page load time out will execute");
//	driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

	System.out.println("page load time out");
//pagesourceload("dashboard");
loadtime();


	
	Boolean a=driver.getPageSource().contains("Session Already");
	if(a){
		for(int i=1;i<100;i++){
			System.out.println(i);		
			Thread.sleep(6000);
		}
	//	booleanResult(a, "Previous session is still active");
		booleanelementInfo(a, "Previous session is still active");
	
getnewurl();
		enterUserName(logid)
		.clickContinueButton()
		
		.enterPassword(logpwd)
		.clickSecureCheckBox();
		clickByXpathExplict(prop.getProperty("button.login.xpath"));
		loadtime();
	
	
	}
	
//	fluentWait("dashboard");

/*	Boolean b=VerifyElementpresentreturn(".//h2[text()='Dashboard']");
	if(b){
		System.out.println("Dashboard has been displaying");
		reportStep("Dashboard has been displaying ","PASS");
	}
	*/
		
	loadtime();
	//Thread.sleep(5000);
	System.out.println("page load time out will execute");
//	driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

	System.out.println("page load time out");
/*
	pagesourceload("dashboard");
loadtime();
loadtime();
loadtime();	*/
	return new BaracDashboard(driver, test);
	}


	
	
	public  BaracHomePage clickContinueButton() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("Click.Continue.button.xpath"));
		return this;
	}
		
}
