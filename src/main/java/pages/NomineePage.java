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
	
	
	public NomineePage FillNomineeForm(String NomineeName,String relation,String Mobno,String address,String Zip) throws InterruptedException
	{

		String Mobnumber= regvalue(Mobno);
		String Pincode = regvalue(Zip);
		
		
		
	enterByXpathExplict(prop.getProperty("enter.nominee.name.xpath"),NomineeName);
	clickByXpathExplict(prop.getProperty("click.dob.xpath"));
	//clickByXpathExplict("//tbody//td[.='16']");
	Thread.sleep(1000);
	clickByXpathExplict("(.//th[contains(text(),'2021')])[1]");
	Thread.sleep(1000);
	clickByXpathExplict("(.//th[contains(text(),'2021')])[2]");
	Thread.sleep(1000);
	clickByXpathExplict("(.//th[contains(text(),'2020')])[1]");
	Thread.sleep(1000);
	clickByXpathExplict("(.//span[text()='1990'])[1]");
	clickByXpathExplict("(.//span[text()='1990'])[1]");
	Thread.sleep(1000);
	clickByXpathExplict(".//span[text()='Jan']");
	clickByXpathExplict("(.//td[text()='1'])[1]");
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
