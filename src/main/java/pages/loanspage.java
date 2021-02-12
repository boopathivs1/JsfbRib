package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class loanspage  extends ProjectWrapp{
	public  loanspage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public loanspage clickshowdetails() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty(""));

		return this;
	}
	public loanspage verifyloandetails() throws InterruptedException{
		
		 VerifyElementPresent("","loan details has been displaying","loan details has not been displaying");
			return this;
			}		
	
	
	

}
