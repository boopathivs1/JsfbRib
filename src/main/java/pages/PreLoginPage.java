package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class PreLoginPage  extends ProjectWrapp{
	public  PreLoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	public PreLoginPage clickCrn() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.crn.xpath"));

		return this;
	}
	
	
	public PreLoginPage FillRegisterForm(String Crnno,String pin) throws InterruptedException{
		
		String Crnnumber=regvalue(Crnno);
		
		
		enterByXpathExplict(prop.getProperty("enter.crnnumber.xpath"),Crnnumber);
		enterByXpathExplict(prop.getProperty("enter.pin.xpath"),pin);
		 clickByXpathExplict(prop.getProperty("click.reg.submit.xpath"));

		return this;
	}
	
public PreLoginPage FillForgotPwdForm(String Crnno,String pin) throws InterruptedException{
		
		String Crnnumber=regvalue(Crnno);
		
		
		enterByXpathExplict(prop.getProperty("enter.crnnumber.xpath"),Crnnumber);
		enterByXpathExplict(prop.getProperty("enter.pin.xpath"),pin);
		 clickByXpathExplict(prop.getProperty("click.forgotpwd.submit.xpath"));

		return this;
	}
	}
