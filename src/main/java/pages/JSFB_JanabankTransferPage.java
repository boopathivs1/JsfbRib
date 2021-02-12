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
	
	
	
	
	public JSFB_JanabankTransferPage submitJanaAccForm(String accno,String accid,String amount,String remarks) throws InterruptedException{
		String amt=regvalue(amount);
		String accnum=regvalue(accno);
		String accidnum=regvalue(accid);

		clickByXpathExplict(".//td[text()='"+accnum+"']//preceding::a[@id='"+accidnum+"']");

		AccountBalance=getTextByXpath(prop.getProperty("getbalance.xpath"));
System.out.println(AccountBalance);
		enterByXpathExplict(prop.getProperty("enter.txtamt.xpath"),amt);
enterByXpathExplict(prop.getProperty("enter.ownacc.remarks.xpath"),remarks);
clickByXpathExplict(prop.getProperty("click.ownacc.submit.xpath"));
clickByXpathExplict(prop.getProperty("click.ownacc.confirm.submit.xpath"));


submitOtp("1111");
	     
	     
	     return this;
	
	}
	
	public JSFB_OtherbankTransferPage clickOtherPayeeTab() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.otherbank.tab.xpath"));

		return new JSFB_OtherbankTransferPage(driver, test);
	}
 }
 	
	
	

