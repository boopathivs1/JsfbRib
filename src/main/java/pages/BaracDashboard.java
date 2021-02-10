package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BaracDashboard extends ProjectWrapp{
	public  BaracDashboard(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	public BaracDashboard frameSwitching() throws InterruptedException{
	loadtime();
	
	locateFrame("icanvas");

	
	return this;
	}
	
	public CurrencyPage clickOther() throws InterruptedException{
		boolean a=VerifyElementpresentreturn(prop.getProperty("click.others.menu.xpath"));	
		clickByXpathExplict(prop.getProperty("click.others.menu.xpath"));	
	return new CurrencyPage(driver, test);
	}

	public Request_Page clickServices() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.requestservices.xpath"));	
	return new Request_Page(driver, test);
	}
	
	
	public FxRatePage clickOtherFXRatePage() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.others.menu.xpath"));	
		loadtime();
	return new FxRatePage(driver, test);
	}
	
	
	public TransferPage clickOtherMenu() throws InterruptedException{
		
			clickByXpathExplict(prop.getProperty("click.others.menu.xpath"));	
		return new TransferPage(driver, test);
		}
	
	public BillPaymentsPage clickBillPaymentsLink() throws InterruptedException{
	//	loadtime();
	//	VerifyElementpresentreturn(prop.getProperty("click.BillPayments.menu.xpath"));	
		scrolltoelementJs(prop.getProperty("click.BillPayments.menu.xpath"));	
		clickByXpathExplict(prop.getProperty("click.BillPayments.menu.xpath"));	
		loadtime();
			return new BillPaymentsPage(driver, test);

	}


	
	public Accounts clickAccountSummaryLink() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("Summary.display.verify.dashboard.xpath"));		
			return new Accounts(driver, test);

	}

	
	
		
	public TransferPage clickSubmenu() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("Click.Transfers.menu.xpath"));		
			return new TransferPage(driver, test);

	}	
	
	
	
public TransferPage clickTransferMenu() throws InterruptedException{
	

//	try {
//		//readywithtime(prop.getProperty("Click.Transfers.menu.xpath"));
//readytimes();
//readystate();
//		jqueryload();
//		jqueryload();
//	} catch (InterruptedException e1) {
//	}


loadtime();
//Boolean a=VerifyElementpresentreturn(prop.getProperty("Click.Transfers.menu.xpath"));

clickByXpathExplict(prop.getProperty("Click.Transfers.menu.xpath"));		
	loadtime();
	return new TransferPage(driver, test);

}









public BaracDashboard clickAccountSummaryTab() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.accountSummary.tab.xpath"));
	return this;
	}	
public BaracDashboard clickCreditCardSummaryTab() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.creditCardSummary.tab.xpath"));
	
	return this;
	}	
public BaracDashboard clickPrepaidCardSummaryTab() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.prepaidSummary.tab.xpath"));
	return this;
	}	
public BaracDashboard clickDepositCardSummaryTab() throws InterruptedException{
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("click.depositSummary.tab.xpath"));	
	//Thread.sleep(15000);
	return this;
	}	



public BaracDashboard clickloanSummaryTab() throws InterruptedException{
	
	
	Thread.sleep(2000);
	
	//Boolean a=VerifyElementpresentreturn(prop.getProperty("click.loanSummary.tab.xpath"));

	//if(a){
		clickByXpathExplict(prop.getProperty("click.loanSummary.tab.xpath"));
		

	return this;
	}	



public Accounts clickSummaryTab() throws InterruptedException{
	
//	Boolean a=VerifyElementpresentreturn(prop.getProperty("Summary.display.verify.dashboard.xpath"));

		clickByXpathExplict(prop.getProperty("Summary.display.verify.dashboard.xpath"));
		pageScroll();
	
	
	
	return new Accounts(driver, test);
	}	











public BaracDashboard verifySummary(String ValidMsg,String InvalidMsg) throws InterruptedException{
	VerifyElementPresent(prop.getProperty("Summary.display.verify.dashboard.xpath"), ValidMsg,InvalidMsg);
	
	return this;
	}	


public Accounts clickAccountMenulinks() throws InterruptedException{
	clickByXpathExplict(prop.getProperty("Click.Account.Menu.xpath"));
	
	return new Accounts(driver, test);
	}	


	
	
}
