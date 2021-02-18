package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class RegularFDNoncummulativePage  extends ProjectWrapp{
	public  RegularFDNoncummulativePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
public RegularFDNoncummulativePage fillJanaRecurring(String sourceaccno,String amount,String deposit_frequency_month,String deposit_frequency_year,String tensure_month,String toaacno ) throws InterruptedException{
		
		dropdownSelectionbyindex(1,sourceaccno);
		
		
		enterByXpathExplict(prop.getProperty("enter.deposit.amount.xpath"),amount);
				//deposit frequency
		
		dropdownSelectionbyindex(2,deposit_frequency_month);
		
		dropdownSelectionbyindex(3,deposit_frequency_year);
		

		dropdownSelectionbyindex(4,tensure_month);
		dropdownSelectionbyindex(5,toaacno);
		
		clickByXpathExplict(prop.getProperty("click.deposit.confirmdetails.xpath"));
			
		return this;
	}

public NomineePage SelectNoNominee() throws InterruptedException
{
pageScrollup();
	clickByXpathExplict(prop.getProperty("click.no.nominee.radio.xpath"));
	clickByXpathExplict(prop.getProperty("click.nonominee.next.xpath"));
	clickByXpathExplict(prop.getProperty("click.nonominee.confirm.xpath"));
	
	
	
	return  new NomineePage(driver, test);
}
	
	
	
	public RegularFDNoncummulativePage FillDepositForm(String fromacc,String amount,String Years,String MaturityOpt) throws InterruptedException{
		
		String accno= regvalue(fromacc);
		String amt= regvalue(amount);
		
		 dropdownSelectionbyindex(1,accno);
		enterByXpathExplict(prop.getProperty("enter.deposit.amount.xpath"),amt);
		 dropdownSelectionbyindex(2,Years); 
		 pageScroll();
		 dropdownSelectionbyindex(4,MaturityOpt);
		//dropdownSelectionbyindex(6,accno);
		clickByXpathExplict(prop.getProperty("click.deposit.next.button.xpath"));
			
		
			
		
		return this;
		}
	
	public NomineePage SelectNominee() throws InterruptedException
	{
	pageScrollup();
		clickByXpathExplict(prop.getProperty("click.radiobtn.yes.xpath"));
		return  new NomineePage(driver, test);
	}
	
	
		}
