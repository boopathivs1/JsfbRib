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
}
