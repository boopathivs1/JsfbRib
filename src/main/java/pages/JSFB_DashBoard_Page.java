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
	
	public fundtransferpage clickfundtrans() throws InterruptedException{
	
	     clickByXpathExplict(prop.getProperty("click.fundtransmenu.xpath"));

		return new fundtransferpage(driver, test);
	}
	
	
	
	public JSFB_ServicePage clickServices() throws InterruptedException{
		locateFrameById("canvas");
	     clickByXpathExplict(prop.getProperty("click.services.xpath"));

		return new JSFB_ServicePage(driver,test);
	}
	
	
	
	public JSFB_DashBoard_Page ClickFD() throws InterruptedException{
	
	     clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		return this;
	}
	
	
	public JSFB_DashBoard_Page ClickLoan() throws InterruptedException{
		
		pageScroll();
		
	     clickByXpathExplict(prop.getProperty("click.Loan.xpath"));
		return this;
	}
	
	public JSFB_DashBoard_Page ClickRD() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.RD.xpath"));
		return this;
	}
	
	
	
	public JSFB_DashBoard_Page verifyFDSummary() throws InterruptedException{
	
	 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Fixed Deposit summary has been displaying","Fixed Deposit summary has not been displaying");
		return this;
		}
	
	public JSFB_DashBoard_Page verifyRDSummary() throws InterruptedException{
		
		 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Recurring Deposit summary has been displaying","Recurring Deposit summary has not been displaying");
			return this;
			}
	
	public JSFB_DashBoard_Page verifyLoanSummary() throws InterruptedException{
		
		 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Loan summary has been displaying","Loan summary has not been displaying");
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
