package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_39_college_investment_plan_No_Nominee  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC39";
		testDescription="college investment plan regular -No Nominee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC39";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String sourceaccno,
			String amountRange,String deposit_frequency_month,String deposit_frequency_year,String tensure_month,
			String toaacno,String NomineeName,String relation,String Mobno,String address,String Zip,
			String otp,String param12,String param13,String param14,String param15,String param16) throws Exception{
	
		
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
	.click_college_investment_Deposit()
	.fillJanaRecurring(Sourcenum, amtrange, deposit_frequency_month, deposit_frequency_year, tensure_month, toaccnum)
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