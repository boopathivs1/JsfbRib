package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_16_RegularFDNonCummulative  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC16";
		testDescription="RegularFDNonCummulative";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC16";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String fromacc,String amount,String Years,String MaturityOpt,String NomineeName,String relation,String Mobno,String address,String Zip,String OTP,String Mobnumber1,String address1,String param11,String param13,String param14,String param15,String param16) throws Exception{
	try{	
	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickDepositMenu()
	.clickOpenDeposit()
	.clickRegulrFDNonCumm_Deposit()
	.FillDepositForm(fromacc,amount,Years,MaturityOpt)
	.SelectNominee()
	.FillNomineeForm( NomineeName, relation, Mobno,address,Zip)
	.SubmitOTP(OTP);
	
	logout(false);
	}
catch (Exception e) {
	//logout(false);
	throw new Exception();

}	

	}
	
	
	
	}