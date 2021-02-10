package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_LoginPage extends ProjectWrapp{
	public  JSFB_LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
 public JSFB_DashBoard_Page loginApplication(String UserName,String Password,String captcha) throws InterruptedException{
	 enterByXpathExplict(prop.getProperty("enter.username.xpath"),UserName);
	 enterByXpathExplict(prop.getProperty("enter.userpassword.xpath"),Password);
     clickByXpathExplict(prop.getProperty("click.loginbutton.xpath"));
     enterByXpathExplict(prop.getProperty("enter.captcha.xpath"),captcha);
     clickByXpathExplict(prop.getProperty("click.loginbutton.xpath"));
     
	 return new JSFB_DashBoard_Page(driver, test);
	 
 }
 	
	
	
}
