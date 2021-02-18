package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_13_JanaBanKTransfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC13";
		testDescription="JanaBanKTransfer";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC13";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String accno,String name,String Fromacc,String amount,String remarks,String otp,String amountRange,String param6,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickInitiatetrans()
	.clickJanaPayeeTab()
	.submitJanaAccForm( accno,name,Fromacc,amount, remarks)
	.otpVerify(otp)
	.clickOkTransfer()
	.clickTransferHistory()
	.filterTransHistory(Fromacc, amountRange)
	.verifyHistoryAmount(amount)
	.clickAccountMenu()
	.verifyBalanceDeduction(Fromacc);
	logout(false);
	}
catch (Exception e) {
	logout(false);
}	

	}
	
	
	
	}