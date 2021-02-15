package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class PreLoginPage  extends ProjectWrapp{
	public  PreLoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	public PreLoginPage clickCrn() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.crn.xpath"));

		return this;
	}
	
	
	public PreLoginPage FillRegisterForm(String Crnno,String pin) throws InterruptedException{
		
		String Crnnumber=regvalue(Crnno);
		
		
		enterByXpathExplict(prop.getProperty("enter.crnnumber.xpath"),Crnnumber);
		enterByXpathExplict(prop.getProperty("enter.pin.xpath"),pin);
		 clickByXpathExplict(prop.getProperty("click.reg.submit.xpath"));

		return this;
	}
	public PreLoginPage SubmitOTP(String OTP) throws InterruptedException{
	     
		enterByXpathExplict(prop.getProperty("enter.otp.xpath"),OTP);
	
		clickByXpathExplict(prop.getProperty("click.otp.submit.xpath"));
				return this;
			}
	
	public PreLoginPage VerifyUserRegistration() throws InterruptedException{
		 
		VerifyElementPresent(prop.getProperty("verify.user.registration.xpath"),"user has updated successfully","user is not registered");

				return this;
			}
	
	
	public PreLoginPage FillUserForm(String Username,String pwd) throws InterruptedException{
		
		
		enterByXpathExplict(prop.getProperty("enter.register.username.xpath"),Username);
		enterByXpathExplict(prop.getProperty("enter.register.pwd.xpath"),pwd);
		enterByXpathExplict(prop.getProperty("enter.confirmpwd.xpath"),pwd);
		 clickByXpathExplict(prop.getProperty("click.agreeterms.checkbox.xpath"));
		 clickByXpathExplict(prop.getProperty("click.register.submit.xpath"));

		return this;
	}
	

	public PreLoginPage VerifyPasswordUpdate() throws InterruptedException{
	 
		VerifyElementPresent(prop.getProperty("verify.passwordUpdate.xpath"),"Password has updated successfully","Password is not updated");

				return this;
			}
	
	
public PreLoginPage FillForgotPwdForm(String Crnno,String pin) throws InterruptedException{
		
		String Crnnumber=regvalue(Crnno);
		
		
		enterByXpathExplict(prop.getProperty("enter.crnnumber.xpath"),Crnnumber);
		enterByXpathExplict(prop.getProperty("enter.pin.xpath"),pin);
		 clickByXpathExplict(prop.getProperty("click.forgotpwd.submit.xpath"));

		return this;
	}


public PreLoginPage setpassword(String Pwd,String captcha) throws InterruptedException{
	
	enterByXpathExplict(prop.getProperty("enter.forgotpwd.xpath"),Pwd);
	enterByXpathExplict(prop.getProperty("enter.confirm.forgotpwd.xpath"),Pwd);
     scrolltoelementJs(prop.getProperty("enter.captcha.xpath"));
	 enterByXpathExplict(prop.getProperty("enter.captcha.xpath"),captcha);
	 clickByXpathExplict(prop.getProperty("click.securelogin.xpath"));

	return this;
}
	}
