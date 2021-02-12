package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_JanabankTransferPage extends ProjectWrapp{
	public  JSFB_JanabankTransferPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public JSFB_JanabankTransferPage clickJanaPayeeTab() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.janapayee.tab.xpath"));

		return this;
	} 
	
	
	public JSFB_OtherbankTransferPage clickOtherPayeeTab() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.otherbank.tab.xpath"));

		return new JSFB_OtherbankTransferPage(driver, test);
	}
 }
 	
	
	

