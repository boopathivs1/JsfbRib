package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_011_OtherBankDeletePayee  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC11";
		testDescription="Other Bank Delete Payee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC11";
		LogoutStatus=true;	


	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String otp,String otherpayeenickname,
			String param0,String param1,String param2,String param3,String param4,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	
		
		try{	
	 new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickmanagepayee()
	.clickotherbankpayee()
	.clickotherbankpayeeButton(otherpayeenickname)
	.clickotherpayeeDelete();
	
	
	
		logout(false);
	
	
	
	
	
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}