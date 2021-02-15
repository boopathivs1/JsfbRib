package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_09_JanaPayeeDelete  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC09";
		testDescription="Jana Delete Payee";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC09";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String otp,String janaPayeeNickname,
			String params0,String params1,String params2,String params3,String params4,String param7,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
	
		
		try{	
	 new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickfundtrans()
	.clickmanagepayee()
	.clickjanabankpayee(janaPayeeNickname)
	.clickotherpayeeDelete()
	.clickmanagepayee()
	//.clickotherbankpayee()
	.verifyJanaBeneficiaryDeletion(janaPayeeNickname);
	
	
	
	
	
		logout(true);
	
	
	
	
	
	}
catch (Exception e) {
	logout(true);
	throw new Exception();

}	

	}
	
	
	
	}