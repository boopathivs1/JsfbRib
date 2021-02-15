package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class TransferHistoryPage  extends ProjectWrapp{
	public TransferHistoryPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public TransferHistoryPage filterTransHistory(String accno,String amountRange) throws InterruptedException {
	String accnum=regvalue(accno);
	String AmtRange=regvalue(amountRange);
	clickByXpathExplict(".//input[@id='fromDate']");
	clickByXpathExplict(".//td[contains(@class,'active')]//preceding::td[1]");
	clickByXpathExplict(".//input[@id='toDate']");
	clickByXpathExplict(".//td[contains(@class,'active')]");
	clickByXpathExplict("(.//div[@class='ui dropdown selection'])[1]");
	clickByXpathExplict(".//div[text()='"+accnum+"']");
	
	clickByXpathExplict(".//div[text()='Select Range']");
	
	
	clickByXpathExplict(".//div[text()='1-5000']");
	clickByXpathExplict(".//button[@id='ftHistorySubmit']");
	
	
	
	
	


	
	
	
	
	return this;
	}
	
	
	
	
	
public Accountspage verifyHistoryAmount(String amount){	
	String amt=regvalue(amount);	
	verifyExactTextcontainslistByXpath(prop.getProperty("verify.transamt.history.xpath"),amt);
	return new Accountspage(driver, test);

}
	

}