package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class fundtransferpage  extends ProjectWrapp{
	public  fundtransferpage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public fundtransferpage clickaddpayeemenu() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.addpayeemenu.xpath"));

		return this;
	}	
	
	
	public JanaBank_AddPayee clickjanabank() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.janapayee.xpath"));

		return new JanaBank_AddPayee(driver, test);
	}	
	
	
	
	
	
	
	
	
	public OtherBank_AddPayee clickotherpayee() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.otherpayee.xpath"));

		return new OtherBank_AddPayee(driver, test);
	}	
	
	
	
}
