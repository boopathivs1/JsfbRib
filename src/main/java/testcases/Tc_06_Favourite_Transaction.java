package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_06_Favourite_Transaction  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC06";
		testDescription="Favourite_Transaction";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC06";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String Payee,String accno,String Mode,String amount,String remarks,String otp,String amountRange,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
		try{	

	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.FillFavTransForm(Payee,accno,Mode,amount,remarks)
	.otpVerify(otp)
	.clickOkTransfer()
	.clickfundtrans()
	.clickTransferHistory()
	.filterTransHistory(accno, amountRange)
	.verifyHistoryAmount(amount)
	.clickAccountMenu()
	.verifyBalanceDeduction(accno);
	logout(false);
	
	}
catch (Exception e) {
	logout(false);
}	

	}
	
	
	
	}