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
	
	clickByXpathExplict(prop.getProperty("click.fromdate.text.xpath"));
	clickByXpathExplict(prop.getProperty("select.lastdate.trans.xpath"));
	clickByXpathExplict(prop.getProperty("click.todate.text.xpath"));
	clickByXpathExplict(prop.getProperty("click.futuredate.xpath"));
	
	
	clickByXpathExplict(prop.getProperty("select.fromacc.transhistory.xpath"));
	clickByXpathExplict(".//div[text()='"+accnum+"']");
	
	
	clickByXpathExplict(prop.getProperty("click.select.trans.range.xpath"));	
	
	clickByXpathExplict(prop.getProperty("click.amountrange.transhistory.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("click.submit.transhistory.xpath"));
	
	
	
	
	return this;
	}
	
	
	
	
	
public Accountspage verifyHistoryAmount(String amount){	
	String amt=regvalue(amount);	
	verifyExactTextcontainslistByXpath(prop.getProperty("verify.transamt.history.xpath"),amt);
	return new Accountspage(driver, test);

}
	

}