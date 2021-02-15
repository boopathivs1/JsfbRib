package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_1_Register  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC1";
		testDescription="Register";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC1";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Crnno,String pin,String username,String pwd,String OTP,String amount,String remarks,String otp,String param5,String param6,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.clickRegister()
	.clickCrn()
	.FillRegisterForm(Crnno, pin)
	.FillUserForm(username,pwd)
	.SubmitOTP(OTP)
	.VerifyUserRegistration();
	}
catch (Exception e) {
	throw new Exception();
}	

	}
	
	
	
	}