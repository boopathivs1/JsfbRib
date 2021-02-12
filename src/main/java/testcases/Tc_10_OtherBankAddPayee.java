package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_10_OtherBankAddPayee  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC10";
		testDescription="Other Bank Add Payee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC10";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String otp,String accno,
			String ifsccode,String acctype,String firstname,String nickname,String mobno,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	
		System.out.println(accno);
		System.out.println(ifsccode);
		try{	
	 new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickaddpayeemenu()
	.clickotherpayee()
	.fillotherpayee(accno, ifsccode, acctype, firstname, nickname, mobno, otp)
	.logout(false);
	
	
	
	
	
	}
catch (Exception e) {
	logout(false);
	throw new Exception();

}	

	}
	
	
	
	}