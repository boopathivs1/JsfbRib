package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_40_tax_saver_fd_No_Nominee  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC40";
		testDescription="Tax saver FD Cumulative investment plan regular-No Nominee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC40";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String sourceaccno,
			String amount,String toaccno,String NomineeName,String relation,String Mobno,String address,String Zip,
			String otp,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
		
		
		String Sourcenum=regvalue(sourceaccno);
String toaccnum=regvalue(toaccno);

String amt=regvalue(amount);
String otpnum=regvalue(otp);

try{	

	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickDepositMenu()
	.clickOpenDeposit()
	.click_taxsaver()
	.filltaxsaver(Sourcenum, amt, toaccnum)
	.SelectNoNominee()


	.SubmitOTP(otpnum)
	.verifyDepositsuccess();
	
	logout(false);
	}
catch (Exception e) {
	logout(false);
}	

	}
	
	
	
	}