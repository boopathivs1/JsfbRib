package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_21_CloseFD_NonCummulative_Manage_Deposit  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC21";
		testDescription="CloseFD_NonCummulative Manage Deposit";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC21";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String amount,String OTP,String Years,String MaturityOpt,String NomineeName,String relation,String Mobno,String address,String Zip,String OTP1,String Mobnumber1,String address1,String param11,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickDepositMenu()
	.clickManageDeposit()
	.CloseDepositForm(amount)
	.SubmitOTP(OTP)
	.VerifyCloseDeposit();
	
	logout(false);
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}