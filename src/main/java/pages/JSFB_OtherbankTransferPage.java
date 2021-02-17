package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_OtherbankTransferPage extends ProjectWrapp{
	public  JSFB_OtherbankTransferPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	
	

	public JSFB_OtherbankTransferPage submitOtherbankAccForm(String accno,String name ,String amount,String remarks,String transmode)  throws InterruptedException{
		String amt=regvalue(amount);
		String accnum=regvalue(accno);
	
		clickByXpathExplict("//td[.='"+accnum+"']//preceding::a[contains(.,'"+name+"')]");

		AccountBalance=getTextByXpath(prop.getProperty("getbalance.xpath"));
System.out.println(AccountBalance);
		enterByXpathExplict(prop.getProperty("click.otherbank.amount.xpath"),amt);
		
		if(transmode.equalsIgnoreCase("NEFT")){
			clickByXpathExplict(".//label[text()='"+transmode+"']");
			

			
		}else if(transmode.equalsIgnoreCase("RTGS")){
			clickByXpathExplict(".//label[text()='"+transmode+"']");

		}
		
		
		
enterByXpathExplict(prop.getProperty("click.otherbank.remark.xpath"),remarks);
clickByXpathExplict(prop.getProperty("click.ownacc.submit.xpath"));
clickByXpathExplict(prop.getProperty("click.ownacc.confirm.submit.xpath"));
	     
	     return this;
	
	}
	
	
	
	
	
	
	public JSFB_OtherbankTransferPage otpVerify(String otpnum) throws InterruptedException{				
		submitOtp(otpnum);
	    VerifyElementPresent(prop.getProperty("verify.otherpayee.successfule.xpath"),"Otherbank Account Transfer Done","Otherbank Account Transfer has failed");
	    return this;
		
	}
	public JSFB_OtherbankTransferPage  clickOkTransfer() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.oktransfer.button.link.xpath"));
		

	return this;

	}
	
	public TransferHistoryPage  clickTransferHistory() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.oktransfer.history.link.xpath"));
		

	return new TransferHistoryPage(driver, test);
	}	
	
	
		 
 }
 	
	
	

