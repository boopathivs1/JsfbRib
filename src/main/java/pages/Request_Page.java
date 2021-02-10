package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Request_Page extends ProjectWrapp{
	public  Request_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public Request_Page selectServices(String value) throws InterruptedException {
		locateFrame("icanvas");
		
	dropdownSelection(prop.getProperty("click.requesttype.xpath"), value);
		
		
		return this;
	}
	


	public Request_Page debitCardChoosen(String value) throws InterruptedException {
	dropdownSelection(prop.getProperty("debitcard.number.choosen.xpath"), value);
		
		
		return this;
	}
	
	
	
	public Request_Page enterfourdigitNumber(String value) throws InterruptedException {
		
	enterByXpathExplict(prop.getProperty("enter.fourdigit.acc.number.xpath"), value);	
		return this;
	}
	
	
	public Request_Page enterCardPIN(String value) throws InterruptedException {
		
	enterByXpathExplict(prop.getProperty("Enter.pin.card.choose.xpath"), value);	
		return this;
	}

	
	
	public Request_Page enteraccid(String value) throws InterruptedException {
		
	dropdownSelection(prop.getProperty("enter.card.acc.xpath"), value);	
		return this;
	}


	
	public Request_Page cardSubmit(String newpin,String confirmpin,String year,String month,String reason,int i,int j) throws InterruptedException {
		
enterByXpathExplict(prop.getProperty("card.newpin.xpath"),newpin);
enterByXpathExplict(prop.getProperty("card.new.confirm.pin.xpath"),confirmpin);
		
			scrolltoelementJs(prop.getProperty("click.notelable.xpath"));
			
			
			clickByXpathExplict(prop.getProperty("click.notelable.xpath"));
			
		
			
			clickByXpathExplict(prop.getProperty("card.year.xpath"));
	
			clickByXpathExplict("(.//div[@id='year_chosen']//li[contains(@class,'active-result')][contains(text(),'"+year+"')])");
								
					clickByXpathExplict(prop.getProperty("card.year.month.xpath"));
					
			clickByXpathExplict("(.//div[@id='month_chosen']//li[contains(@class,'active-result')][contains(text(),'"+month+"')])");
			
					clickByXpathExplict(prop.getProperty("click.notelable.xpath"));

					
					
	dropdownSelection(prop.getProperty("card.reason.xath"),reason);	
		
clickByXpathExplict(prop.getProperty("card.submit.xpath"));		
			return this;
		}




	
	public Request_Page clickCreditcard() throws InterruptedException {
				clickByXpathExplict(prop.getProperty("click.creditcard.xpath"));

		return this;
	}
	public Request_Page clickPrepaid() throws InterruptedException {
		
		clickByXpathExplict(prop.getProperty("click.prepaidcard.xpath"));

		return this;
	}
	public Request_Page clickDebit() throws InterruptedException {
		
		clickByXpathExplict(prop.getProperty("click.debitcard.xpath"));
		
		return this;
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
}