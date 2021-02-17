package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_35_BillPaymentElectricity  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC35";
		testDescription="BillPayment";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC35";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String state,String biler,String Consumerno,String Fromacc,String OTP,String amountRange,String amount,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.ClickBillpay()
	.ClickBillpayment()
	.ClickElectricity()
	.FillBillpaymentForm(state, biler, Consumerno,Fromacc)
	.SubmitOTP(OTP);
//	.clickOkTransfer()
//	.clickTransferHistory()
//	.filterTransHistory(Fromacc, amountRange)
//	.verifyHistoryAmount(amount)
//	.clickAccountMenu()
//	.verifyBalanceDeduction(Fromacc);
	
	
	
		logout(false);
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}