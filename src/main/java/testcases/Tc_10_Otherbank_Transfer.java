package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_10_Otherbank_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC10";
		testDescription="Otherbank_Transfer";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC10";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String accno,String nickname,String otp,String param3,String param4,String param5,String param6,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.clickOverviewButton()
	.clickfundtrans()
	.clickInitiatetrans()
	.clickOtherPayeeTab();
	
	
	logout(false);
	}
catch (Exception e) {
	logout(false);
}	

	}
	
	
	
	}