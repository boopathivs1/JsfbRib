package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Jana_recurring_Deposit  extends ProjectWrapp{
	public Jana_recurring_Deposit(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	public Jana_recurring_Deposit fillJanaRecurring(String sourceaccno,String amount,String daywise) throws InterruptedException{
		
		dropdownSelectionbyindex(1,"4534010000188902");
		
		
		enterByXpathExplict(".//input[@id='installmentAmount']","1000");
				//deposit frequency
		
		dropdownSelectionbyindex(2,"Monthly");
		
		dropdownSelectionbyindex(3,"1 Years");
		

		dropdownSelectionbyindex(4,"1 Months");
		dropdownSelectionbyindex(5,"4534010000188392");
		
		clickByXpathExplict(".//input[@id='confirmBeneDtls']");
				
				




				





				

				
		
		
		
		return this;
	}
	
	
	
	
}
