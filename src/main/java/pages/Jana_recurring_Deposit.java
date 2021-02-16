package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Jana_recurring_Deposit  extends ProjectWrapp{
	public Jana_recurring_Deposit(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	public Jana_recurring_Deposit fillJanaRecurring(String sourceaccno,String amount,String deposit_frequency_month,String deposit_frequency_year,String tensure_month,String toaacno ) throws InterruptedException{
		
		dropdownSelectionbyindex(1,sourceaccno);
		
		
		enterByXpathExplict(prop.getProperty("installment.amount.xpath"),amount);
				//deposit frequency
		
		dropdownSelectionbyindex(2,deposit_frequency_month);
		
		dropdownSelectionbyindex(3,deposit_frequency_year);
		

		dropdownSelectionbyindex(4,tensure_month);
		dropdownSelectionbyindex(5,toaacno);
		
		clickByXpathExplict(prop.getProperty("click.deposit.confirmdetails.xpath"));
				
		




				





				

				
		
		
		
		return this;
	}
	
	
	
	
}
