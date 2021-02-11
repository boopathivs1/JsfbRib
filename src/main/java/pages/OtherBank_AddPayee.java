package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class OtherBank_AddPayee  extends ProjectWrapp{
	public  OtherBank_AddPayee(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public OtherBank_AddPayee fillotherpayee(String accno,String ifsccode,String acctype,String firstname,String nickname,String mobno,String otp) throws InterruptedException{

		String accnum=regvalue(accno);
		String otpnum=regvalue(otp);
		enterByXpathExplict(prop.getProperty("enter.otheraccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.otherConfirmaccno.xpath"),accnum);
		enterByXpathExplict(prop.getProperty("enter.bankifsc.code.xpath"),ifsccode);
selectVisibileTextByXPath(prop.getProperty("select.acctype.xpath"),acctype);
		enterByXpathExplict(prop.getProperty("enter.firstname.xpath"),firstname);
		enterByXpathExplict(prop.getProperty("enter.otherbank.nickname.xpath"),nickname);
		enterByXpathExplict(prop.getProperty("enter.otherbank.mobno.xpath"),mobno);
		clickByXpathExplict(prop.getProperty("click.otherbank.submitxpath"));
		clickByXpathExplict(prop.getProperty("click.confirmdetails.xpath"));
		enterByXpathExplict(prop.getProperty("click.otherbankotp.xpath"),otpnum);
		
		clickByXpathExplict(prop.getProperty("click.otherbanksubmit.xpath"));
		
			
		
			
//			#click.//a[text()='Fund transfer']
//			clickotherbank.managelink.xpath=.//a[@id='onMPClick']
//			click.otherpayee.tab.xpath=.//a[text()='Other Bank Payee']
//			#click..//td[text()='987321654']
	
	return this;
	
	}
}
