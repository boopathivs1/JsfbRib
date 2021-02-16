package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.JSFB_LoginPage;
import wrappers.ProjectWrapp;
public class Tc_19_tax_saver_fd_cumulative  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC19";
		testDescription="college investment plan regular";
		browserName="Chrome";
		dataSheetName="JSFBTestData";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC19";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void DEpositOverview(String casename,String Username,String Password,String captcha,String sourceaccno,
			String amount,String toaccno,String params1,String params2,String params3,String param0,String param6,String param8,String param9,String param10,String para11,String param12,String param13,String param14,String param15,String param16) throws Exception{
		String Sourcenum=regvalue(sourceaccno);
String toaccnum=regvalue(toaccno);

String amt=regvalue(amount);


try{	

	new JSFB_LoginPage(driver, test)
	.loginApplication(Username, Password, captcha)
	.locatingFrames()
	.clickDepositMenu()
	.clickOpenDeposit()
	.click_taxsaver()
	.filltaxsaver(Sourcenum, amt, toaccnum);
	logout(false);
	}
catch (Exception e) {
	logout(false);
}	

	}
	
	
	
	}