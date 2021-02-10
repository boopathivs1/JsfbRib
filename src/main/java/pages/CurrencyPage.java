package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CurrencyPage extends ProjectWrapp{
	public  CurrencyPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public CurrencyPage clickCurrency() throws InterruptedException{
		loadtime();
		boolean a=VerifyElementpresentreturn(prop.getProperty("click.currency.menu.xpath"));	
		clickByXpathExplict(prop.getProperty("click.currency.menu.xpath"));	
		loadtime();return this;
	}
	
	

public CurrencyPage locatingFrames() throws InterruptedException{
locateFrame("icanvas");

return this;
}
	public CurrencyPage currencyConverterForm(String fromCurrencytype,String tocurrencytype,String amount) throws InterruptedException{
dropdownSelection(prop.getProperty("currency.fromamounttype.xpath"),fromCurrencytype);		

dropdownSelectionindex(prop.getProperty("currency.toamounttype.xpath"),tocurrencytype, 2);
//dropdownSelection(prop.getProperty("currency.toamounttype.xpath"),tocurrencytype);	
String amt=regvalue(amount);


enterByXpathExplict(prop.getProperty("enter.currency.amount.xpath"),amt);
clickByXpathExplict(prop.getProperty("click.convert.button.xpath"));


VerifyElementPresent(prop.getProperty("Converted.amt.final.xpath"),"Currency has been converted successfully", "Currency has not been converted successfully");


		return this;
	}
	

}
