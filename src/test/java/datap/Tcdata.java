package datap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BaracHomePage;
import wrappers.ProjectWrapp;
public class Tcdata  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC01";
		testDescription="Verifying Account,Prepaid card,credit card,loan,Deposit Summary.";
		browserName="Chrome";
		dataSheetName="Barac";
		category="Regression";
		authors="Boopathi";
		testKeyword="c";
		LogoutStatus=true;	
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="datacoloumn")
	public void checkAccSummary(String casename,String Username,String Password,String Otp) throws Exception{
System.out.println(casename);
System.out.println(Username);
System.out.println(Password);
System.out.println(Otp);

new	BaracHomePage(driver,test)
.enterUserName(casename)
.clickContinueButton();


	}
}