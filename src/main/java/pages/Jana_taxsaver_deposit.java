package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Jana_taxsaver_deposit  extends ProjectWrapp{
	public Jana_taxsaver_deposit(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public NomineePage SelectNominee() throws InterruptedException
	{
	pageScrollup();
		clickByXpathExplict(prop.getProperty("click.radiobtn.yes.xpath"));
		return  new NomineePage(driver, test);
	}
	
	public NomineePage SelectNoNominee() throws InterruptedException
	{
		pageScrollup();
		clickByXpathExplict(prop.getProperty("click.no.nominee.radio.xpath"));
		clickByXpathExplict(prop.getProperty("click.nonominee.next.xpath"));
		clickByXpathExplict(prop.getProperty("click.nonominee.confirm.xpath"));
		
		
		
		return  new NomineePage(driver, test);
	}
	
	
	
	
	public Jana_taxsaver_deposit filltaxsaver(String sourceaccno,String amount,String toaacno ) throws InterruptedException{
		
		dropdownSelectionbyindex(1,sourceaccno);
		
		
		enterByXpathExplict(prop.getProperty("enter.deposit.tax.amt.xpath"),amount);
//				//deposit frequency
//		
//		dropdownSelectionbyindex(2,deposit_frequency_month);
//		
//		dropdownSelectionbyindex(3,deposit_frequency_year);
//		
//
//		dropdownSelectionbyindex(4,tensure_month);
		scrolltoelementJs(prop.getProperty("click.taxsaver.form.submit.xpath"));

	//	doubleclickByXpathExplict("(.//div[contains(@class,'ui dropdown selection')])[4]");
//		clickByXpathExplict("(.//div[contains(@class,'visible')])[2]//div[contains(text(),'"+toaacno+"')]");
//mouseOverByXpath("(.//div[contains(@class,'ui dropdown selection')])[4]");
		
//dropdownSelectionbyindex(4,toaacno);
		
		
		
		clickByXpathExplict(prop.getProperty("click.taxsaver.form.submit.xpath"));
				
		Thread.sleep(10000);




				





				

				
		
		
		
		return this;
	}
	
	
	
	
}
