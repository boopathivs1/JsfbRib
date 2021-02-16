package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class RegularFDNoncummulativePage  extends ProjectWrapp{
	public  RegularFDNoncummulativePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	
	public RegularFDNoncummulativePage ClickOpenDeposit() throws InterruptedException{
		
		 clickByXpathExplict(prop.getProperty("click.open.deposit.xpath"));
		return this;
		}
	
	
	public RegularFDNoncummulativePage FillDepositForm(String fromacc) throws InterruptedException{
		
		String accno= regvalue(fromacc);
		
		 clickByXpathExplict(prop.getProperty("click.regularFD.NonCumm.xpath"));
		 
		 clickByXpathExplict(prop.getProperty("click.fromacc.dropdown.xpath"));
		 
		 clickByXpathExplict(prop.getProperty("click.fromacc.dropdown.xpath"));
		 
		 clickByXpathExplict("//div[.='"+accno+"']");
		 
		 
		return this;
		}
	
	
		}
