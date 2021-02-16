package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class DepositPage  extends ProjectWrapp{
	public  DepositPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public  DepositPage clickManageDeposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty(""));

		return this;
		
	}
	
	public  DepositPage clickOpenDeposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty(""));

		return this;
	}
	
	
	
	public  Jana_recurring_Deposit clickjanaRecurring_Deposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty(""));

		return new Jana_recurring_Deposit(driver, test);
	}
	
	
	
}
