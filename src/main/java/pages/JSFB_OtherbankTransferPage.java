package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_OtherbankTransferPage extends ProjectWrapp{
	public  JSFB_OtherbankTransferPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	
	

	public JSFB_OtherbankTransferPage submitOtherbankAccForm(String accno,String listid,String accid,String amount,String remarks) throws InterruptedException{
		String amt=regvalue(amount);
		String accnum=regvalue(accno);
		String accidnum=regvalue(accid);

		clickByXpathExplict(".//td[text()='"+accnum+"']//preceding::form[@id='"+listid+"']//a[@id='"+accidnum+"']");

		AccountBalance=getTextByXpath(prop.getProperty("getbalance.xpath"));
System.out.println(AccountBalance);
		enterByXpathExplict(prop.getProperty("click.otherbank.amount.xpath"),amt);
		pageScroll();
enterByXpathExplict(prop.getProperty("click.otherbank.remark.xpath"),remarks);
clickByXpathExplict(prop.getProperty("click.ownacc.submit.xpath"));
clickByXpathExplict(prop.getProperty("click.ownacc.confirm.submit.xpath"));


submitOtp("1111");
	     
	     
	  return this;
	
	}
	
		 
 }
 	
	
	

