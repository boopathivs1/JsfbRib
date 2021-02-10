package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.BaracHomePage;
import wrappers.ProjectWrapp;
public class Tc_01  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC01";
		testDescription="Verifying Account,Prepaid card,credit card,loan,Deposit Summary.";
		browserName="Chrome";
		dataSheetName="Barac";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC01";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String Username,String Password,String Otp,String accnumber,String nickname,String Data3,String Data4,String Data5,String Data6,String data7,String data8,String data9,String data10,String data11,String data12,String data13,String data14,String data15,String data16,String data17) throws Exception{
		try{
			
		new	BaracHomePage(driver,test)
	.enterUserName(Username)
	.clickContinueButton()
	
	.enterPassword(Password)
	.clickSecureCheckBox()
	.clickLoginButton()
	.frameSwitching()
	//.clickAccountSummaryTab()
	.verifySummary("Account Summary has been displaying", "Account Summary has not been displaying")
	.clickCreditCardSummaryTab()
	.verifySummary("Credit Card Summary has been displaying", "Credit Card Summary has not been displaying")
	.clickPrepaidCardSummaryTab()
	.verifySummary("Prepaid Card Summary has been displaying", "Prepaid Card Summary has not been displaying")
	.clickDepositCardSummaryTab()
	.verifySummary("Deposit Summary has been displaying", "Deposit Summary has not been displaying")
	.clickloanSummaryTab()
	.verifySummary("Loan Summary has been displaying", "Loan Summary has not been displaying")

.logout();
		}

	catch (Exception e) {
//Thread.sleep(20000);
logout();
		throw new Exception();
		
		// TODO: handle exception
	}

	}
	}

