package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_04_Verify_Deposit_Overview  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC04";
		testDescription="Verify Deposit Overview";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC04";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String otp,String param1,String param2,String param3,String param4,String param5,String param6,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickOverviewButton()
	.ClickFD()
	.verifyFDSummary()
	.ClickFD()
	.ClickRD()
	.verifyRDSummary();
	logout(false);
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}