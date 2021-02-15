package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JanaBank_AddPayee  extends ProjectWrapp{
	public  JanaBank_AddPayee(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public JanaBank_AddPayee filljanabankpayee(String accno,String nickname,String otp) throws InterruptedException{

		String accnum=regvalue(accno);
		String otpnum=regvalue(otp);
		enterByXpathExplict(prop.getProperty("enter.otheraccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.otherConfirmaccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.otherbank.nickname.xpath"),nickname);
		clickByXpathExplict(prop.getProperty("click.otherbank.submitxpath"));
		clickByXpathExplict(prop.getProperty("click.confirmdetails.xpath"));
		enterByXpathExplict(prop.getProperty("click.otherbankotp.xpath"),otpnum);
		clickByXpathExplict(prop.getProperty("click.otherbanksubmit.xpath"));
	
	return this;
	
	}
	
	
	public JanaBank_AddPayee  verifyJanaPayee() throws InterruptedException{
		
		VerifyElementPresent(prop.getProperty("verify.otherpayee.successfule.xpath"),"Jana Payee Added Successfully","Jana Payee has not Added Successfully");
		
		clickByXpathExplict(prop.getProperty("click.addpayee.link.xpath"));
		
	
	return this;
	
		}
	
public JanaBank_AddPayee  verifyJanaPayeeAdded(String Janapayeenickname) throws InterruptedException{
		
		
		clickByXpathExplict(prop.getProperty("clickotherbank.managelink.xpath"));
		clickByXpathExplict(prop.getProperty("click.janapayee.tab.xpath"));
scrolltoelementJs("(.//input[contains(@value,'EXTSUBMOD~"+Janapayeenickname+"')]//following::label)[1]");
VerifyElementPresent("(.//input[contains(@value,'EXTSUBMOD~"+Janapayeenickname+"')]//following::label)[1]","JanaPayee Beneficiary has added successfully","JanaPayee Beneficiary has not added successfully");

return this;
	
}
