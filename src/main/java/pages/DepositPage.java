package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class DepositPage  extends ProjectWrapp{
	public  DepositPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public  DepositPage clickManageDeposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.manage.deposit.xpath"));

		return this;
		
	}
	
	public  DepositPage clickOpenDeposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.open.deposit.xpath"));

		return this;
	}
	
	
	public  Jana_recurring_Deposit clickjanaRecurring_Deposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.janarecurring.deposit.xpath"));

		return new Jana_recurring_Deposit(driver, test);
	}
	public  Jana_recurring_Deposit click_college_investment_Deposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.college.investment.deposit.xpath"));

		return new Jana_recurring_Deposit(driver, test);
	}
	
	public  RegularFDNoncummulativePage clickRegulrFDNonCumm_Deposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.regularFD.NonCumm.xpath"));

		return new RegularFDNoncummulativePage(driver, test);
	}
	
	public  RegularFDNoncummulativePage clickRegulrFDCumm_Deposit() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.regularFD.Cumm.xpath"));

		return new RegularFDNoncummulativePage(driver, test);
	}
	
	
	public  Jana_taxsaver_deposit click_taxsaver() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.taxsaver.fd.cumulative.xpath"));

		return new Jana_taxsaver_deposit(driver, test);
	}
		
	
}
