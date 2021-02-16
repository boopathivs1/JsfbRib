package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class RegularFDNoncummulativePage  extends ProjectWrapp{
	public  RegularFDNoncummulativePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	
	
	
	public RegularFDNoncummulativePage FillDepositForm(String fromacc,String amount,String Years) throws InterruptedException{
		
		String accno= regvalue(fromacc);
		String amt= regvalue(amount);
		
		 dropdownSelectionbyindex(1,accno);
		enterByXpathExplict(prop.getProperty("enter.deposit.amount.xpath"),amt);
		 
		 dropdownSelectionbyindex(2,Years); 
		 
		 dropdownSelectionbyindex(4,"1 Months");
			dropdownSelectionbyindex(5,accno);
			
		
			
		
		return this;
		}
	
	
		}
