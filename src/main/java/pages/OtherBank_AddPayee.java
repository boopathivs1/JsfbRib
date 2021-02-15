package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class OtherBank_AddPayee  extends ProjectWrapp{
	public  OtherBank_AddPayee(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public OtherBank_AddPayee fillotherpayee(String accno,String ifsccode,String acctype,String firstname,String nickname,String mobno) throws InterruptedException{

		String accnum=regvalue(accno);
		

		
	

		clickByXpathExplict(prop.getProperty("enter.otheraccno.xpath"));
		enterByXpathExplict(prop.getProperty("enter.otheraccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.otherConfirmaccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.bankifsc.code.xpath"),ifsccode);
selectVisibileTextByXPath(prop.getProperty("select.acctype.xpath"),acctype);
		enterByXpathExplict(prop.getProperty("enter.firstname.xpath"),firstname);
		enterByXpathExplict(prop.getProperty("enter.otherbank.nickname.xpath"),nickname);
		enterByXpathExplict(prop.getProperty("enter.otherbank.mobno.xpath"),mobno);
		clickByXpathExplict(prop.getProperty("click.otherbank.submitxpath"));
		clickByXpathExplict(prop.getProperty("click.confirmdetails.xpath"));
//		enterByXpathExplict(prop.getProperty("click.otherbankotp.xpath"),otpnum);
		
	//	clickByXpathExplict(prop.getProperty("click.otherbanksubmit.xpath"));
		
			
		
			
	return this;
	
	}

	
	

	public OtherBank_AddPayee  enterOtp(String otp) throws InterruptedException{

	
		String otpnum=regvalue(otp);
	
	
	
	

	enterByXpathExplict(prop.getProperty("click.otherbankotp.xpath"),otpnum);
	
	clickByXpathExplict(prop.getProperty("click.otherbanksubmit.xpath"));
	

	return this;
	
	
	}


	public OtherBank_AddPayee  verifyOtherPayee() throws InterruptedException{
	
		VerifyElementPresent(prop.getProperty("verify.otherpayee.successfule.xpath"),"Other Payee Added Successfully","Other Payee has not Added Successfully");
		
		clickByXpathExplict(prop.getProperty("click.addpayee.link.xpath"));
		
	
	return this;
	
		}

	
	
	
	
	public OtherBank_AddPayee  verifyOtherPayeeAdded(String otherpayeenickname) throws InterruptedException{
		
		//clickByXpathExplict(prop.getProperty("click.fundtransmenu.xpath"));
		clickByXpathExplict(prop.getProperty("clickotherbank.managelink.xpath"));
		clickByXpathExplict(prop.getProperty("click.otherpayee.tab.xpath"));
scrolltoelementJs("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");
//		VerifyElementpresentreturn("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");
		VerifyElementPresent("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]","Other Beneficiary has added successfully","Other Beneficiary has not added successfully");

return this;

}


}