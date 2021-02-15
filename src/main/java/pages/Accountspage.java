package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Accountspage  extends ProjectWrapp{
	public  Accountspage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public  Accountspage clickAccountMenu() throws InterruptedException{	
		   clickByXpathExplict(prop.getProperty("click.acclink.xpath"));


	

return this;
	}
	
	public  Accountspage verifyBalanceDeduction(String accno) throws InterruptedException{	
		String accnum=regvalue(accno);
		
		
		

				Thread.sleep(3000);
		
		
		String finalAccountBalance = null;
		

	Boolean a=VerifyElementpresentreturn("(.//a[contains(text(),'"+accnum+"')]//following::td)[3]");



	if(a){
		finalAccountBalance=getTextByXpath("(.//a[contains(text(),'"+accnum+"')]//following::td)[3]");
		reportStep("Balanec has displaying "+finalAccountBalance+"", "PASS");
	}
	else{
	booleanResultFail(a, "Balanec has not displaying "+finalAccountBalance+"");

	}

		
		verifyNottextmatches(AccountBalance,finalAccountBalance,"Balance has been deducted in Account Balance","Balance has not been deducted in Account Balance");
	

return this;
	}	
	
	
	
	
	
	
	
	
	
	
}
