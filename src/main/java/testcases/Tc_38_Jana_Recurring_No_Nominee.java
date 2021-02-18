package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_38_Jana_Recurring_No_Nominee  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC38";
		testDescription="Jana Recurring Deposit-No Nominee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC38";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String sourceaccno,
			String amountRange,String deposit_frequency_month,String deposit_frequency_year,String tensure_month,
			String toaacno,String NomineeName,String relation,String Mobno,String address,String Zip,
			String otp,String para11,String param12,String param13,String param14,String param15) throws Exception{
		
		String Sourcenum=regvalue(sourceaccno);
String amtrange=regvalue(amountRange);		
String toaccnum=regvalue(toaacno);
String otpnum=regvalue(otp);

try{	

	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickDepositMenu()
	.clickOpenDeposit()
	.clickjanaRecurring_Deposit()
	.fillJanaRecurring(Sourcenum, amtrange, deposit_frequency_month, deposit_frequency_year, tensure_month, toaccnum)
	.SelectNoNominee()
	.SubmitOTP(otpnum)
	.verifyDepositsuccess();
	
	
	
	logout(false);
	}
catch (Exception e) {
	logout(false);
	throw new Exception();
}	

	}
	
	
	
	}