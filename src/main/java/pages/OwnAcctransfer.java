package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class OwnAcctransfer extends ProjectWrapp{
	public  OwnAcctransfer(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public OwnAcctransfer submitOwnAccForm(String amount,String remarks,String toaccno,String accid,String fromacc) throws InterruptedException{
		String amt=regvalue(amount);
		String accnum=regvalue(toaccno);
		String accidnum=regvalue(accid);
String fromaccnum=regvalue(fromacc);
	//	4534010000188392
//		String otpnum=regvalue(otpcode);
		
		
		clickByXpathExplict(prop.getProperty("click.ownacc.jana.links.xpath"));
		clickByXpathExplict(".//td[text()='"+accnum+"']//preceding::a[@id='"+accidnum+"']");

		clickByXpathExplict(".//div[@class='ui dropdown selection']");
		clickByXpathExplict("(.//div[text()='"+fromaccnum+"'])[2]");

		
		AccountBalance=getTextByXpath(prop.getProperty("getbalance.xpath"));
System.out.println(AccountBalance);
		enterByXpathExplict(prop.getProperty("enter.txtamt.xpath"),amt);
enterByXpathExplict(prop.getProperty("enter.ownacc.remarks.xpath"),remarks);
clickByXpathExplict(prop.getProperty("click.ownacc.submit.xpath"));
clickByXpathExplict(prop.getProperty("click.ownacc.confirm.submit.xpath"));

//     
	     return this;
	
	}
public OwnAcctransfer otpVerify(String otpnum) throws InterruptedException{				
	submitOtp(otpnum);
    VerifyElementPresent(prop.getProperty("verify.otherpayee.successfule.xpath"),"Own Account Transfer Done","Own Account Transfer has failed");
    return this;
	
}
public OwnAcctransfer  clickOkTransfer() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.oktransfer.button.link.xpath"));
	

return this;
}
	



public TransferHistoryPage  clickTransferHistory() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.oktransfer.history.link.xpath"));
	

return new TransferHistoryPage(driver, test);
}	
		
}
