package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_ServicePage extends ProjectWrapp{
	public  JSFB_ServicePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public JSFB_ServicePage clickUpdateEmail() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.update.email.xpath"));

		return this;
	}
	
	public JSFB_ServicePage FillEmailForm(String Email) throws InterruptedException{
     
enterByXpathExplict(prop.getProperty("enter.newemail.xpath"),Email);
enterByXpathExplict(prop.getProperty("enter.confiememail.xpath"),Email);
clickByXpathExplict(prop.getProperty("click.submit.xpath"));
		return this;
	}
	
	public JSFB_ServicePage SubmitOTP(String OTP) throws InterruptedException{
	     
		enterByXpathExplict(prop.getProperty("enter.otp.xpath"),OTP);
	
		clickByXpathExplict(prop.getProperty("click.otp.submit.xpath"));
				return this;
			}
	 
	
	public JSFB_ServicePage VerifyEmailUpdated() throws InterruptedException{
	 
		VerifyElementPresent(prop.getProperty("verify.email.xpath"),"email has updated successfully","email is not updated");

				return this;
			}
 }
 	
	
	

