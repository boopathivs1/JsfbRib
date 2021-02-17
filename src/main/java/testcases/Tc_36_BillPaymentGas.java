package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_36_BillPaymentGas  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC36";
		testDescription="BillPaymentGas";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC36";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String biler,String Consumerno,String Fromacc,String OTP,String amountRange,String amount,String param7,String data1,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.ClickBillpay()
	.ClickBillpayment()
	.ClickGas()
	.FillBillpaymentGasForm(biler, Consumerno,Fromacc)
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