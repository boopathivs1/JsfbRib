package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CloseDepositPage  extends ProjectWrapp{
	public  CloseDepositPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	

	public CloseDepositPage VerifyCloseDeposit() throws InterruptedException{
	     
VerifyElementPresent(prop.getProperty("verify.Closedeposit.xpath"), "FD NOn Cummulatitive deposit Closed successfully", "FD NOn Cummulatitive deposit was not Closed ");
		
		clickByXpathExplict(prop.getProperty("click.success.okbtn.xpath"));
				return this;
			}		
	
	public CloseDepositPage SubmitOTP(String OTP) throws InterruptedException{
	     
		enterByXpathExplict(prop.getProperty("enter.otp.xpath"),OTP);
	
		clickByXpathExplict(prop.getProperty("click.otp.submit.xpath"));
				return this;
			}
	
}
