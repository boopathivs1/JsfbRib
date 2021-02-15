package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_12_Own_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC12";
		testDescription="Own Account Transfer";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC12";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String otp,
			String amount,
			String remarks,String toaccno,String accid,String fromacc,String amountRange,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	
		System.out.println(toaccno);
		try{	
	
		
		
     new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickintiatelink()
	//.submitOwnAccForm(amount, remarks, toaccno, accid,fromacc)
	//.otpVerify(otp)
	//.clickOkTransfer()
	.clickTransferHistory()
	.filterTransHistory(fromacc, amountRange)
	
	
	
	
	.logout(false);
	
	
	
	
	
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}