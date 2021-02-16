package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NomineePage  extends ProjectWrapp{
	public  NomineePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public void SelectDropdownByIndex(int i,String text,int j) throws InterruptedException{ 



		clickByXpathExplict("(.//div[@class='ui dropdown selection dropdown text menu'])["+i+"]");
		clickByXpathExplict("(.//div[@class='item active selected'][.='"+text+"'])["+j+"]");
		
}
	
	
	
	
	public NomineePage SubmitOTP(String OTP) throws InterruptedException{
	     
		enterByXpathExplict(prop.getProperty("enter.otp.xpath"),OTP);
	
		clickByXpathExplict(prop.getProperty("click.otp.submit.xpath"));
				return this;
			}
	
	
	public NomineePage VerifyOpenFDNonCummulativeDeposit() throws InterruptedException{
		
		pageScrollup();
	     
		VerifyElementPresent(prop.getProperty("verify.opendeposit.xpath"), "FD NOn Cummulatitive deposit opened successfully", "FD NOn Cummulatitive deposit was not opened ");
		
		clickByXpathExplict(prop.getProperty("click.success.okbtn.xpath"));
		return this;
			}
	
	public NomineePage VerifyOpenFDCummulativeDeposit() throws InterruptedException{
	     
		pageScrollup();
		VerifyElementPresent(prop.getProperty("verify.opendeposit.xpath"), "FD Cummulatitive deposit opened successfully", "FD Cummulatitive deposit was not opened ");
		
		clickByXpathExplict(prop.getProperty("click.success.okbtn.xpath"));
		return this;
			}
	
	
	public NomineePage FillNomineeForm(String NomineeName,String relation,String Mobno,String address,String Zip) throws InterruptedException
	{

		String Mobnumber= regvalue(Mobno);
		String Pincode = regvalue(Zip);
			
	enterByXpathExplict(prop.getProperty("enter.nominee.name.xpath"),NomineeName);
	clickByXpathExplict(prop.getProperty("click.dob.xpath"));
	//clickByXpathExplict("//tbody//td[.='16']");

	clickByXpathExplict(prop.getProperty("select.calendar.year1.xpath"));
	
	clickByXpathExplict(prop.getProperty("select.calendar.year2.xpath"));
	
	clickByXpathExplict(prop.getProperty("select.calendar.year3.xpath"));
	
	clickByXpathExplict(prop.getProperty("select.calendar.year4.xpath"));
	clickByXpathExplict(prop.getProperty("select.calendar.year5.xpath"));


	clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	clickByXpathExplict(prop.getProperty("select.calendar.day.xpath"));


	SelectDropdownByIndex(1,relation,1);
	
	enterByXpathExplict(prop.getProperty("enter.Nominee.mobno.xpath"),Mobnumber);
	
	enterByXpathExplict(prop.getProperty("enter.nominee.address.xpath"),address);
	
	enterByXpathExplict(prop.getProperty("enter.nominee.address1.xpath"),address);
	scrolltoelementJs(prop.getProperty("enter.pincode.xpath"));
	enterByXpathExplict(prop.getProperty("enter.pincode.xpath"),Pincode);
	Thread.sleep(2000);
	scrolltoelementJs(prop.getProperty("click.nominee.nextbtn.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.nominee.nextbtn.xpath"));
	clickByXpathExplict(prop.getProperty("click.nominee.confirm.xpath"));
	
		return  this;
	}
	
		
	
}
