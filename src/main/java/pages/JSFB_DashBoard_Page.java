package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_DashBoard_Page extends ProjectWrapp{
	public  JSFB_DashBoard_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public JSFB_DashBoard_Page clickOverviewButton() throws InterruptedException{
		locateFrameById("canvas");
	     clickByXpathExplict(prop.getProperty("click.overview.button.xpath"));

	 
		return this;
	}
	
	
	public JSFB_DashBoard_Page verifyStatement(String accno,String Month) throws InterruptedException{
clickByXpathExplict(".//a[text()='"+accno+"']");
clickByXpathExplict(prop.getProperty("click.monthdropdown.xpath"));
clickByXpathExplict(".//div[contains(text(),'"+Month+"')]");
clickByXpathExplict(prop.getProperty("clickdetailsStmt.xpath"));





		return this;
	}




	
	
	public JSFB_DashBoard_Page verifyaccSummary() throws InterruptedException{
	
	 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Account summary has been displaying","Account summary has not been displaying");
		return this;
		}
		  
	
	
	
	
	
		
	
	
	
}
