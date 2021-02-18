package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_14_Otherbank_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC14";
		testDescription="Other bank_Transfer -IMPS";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC14";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String accno,String name,String fromacc,String amount,String remarks,String otp,String amountRange,String param6,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
		try{	

	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickInitiatetrans()
	.clickOtherPayeeTab()
	.submitOtherbankAccForm( accno,name,fromacc,amount, remarks,"IMPS")
	.otpVerify(otp)
	.clickOkTransfer()
	.clickTransferHistory()
	.filterTransHistory(fromacc, amountRange)
	.verifyHistoryAmount(amount)
	.clickAccountMenu()
	.verifyBalanceDeduction(fromacc);
	logout(false);
	}
catch (Exception e) {
	logout(false);
	throw new Exception();
}	

	}
	
	
	
	}