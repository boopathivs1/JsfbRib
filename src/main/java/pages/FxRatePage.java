package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class FxRatePage extends ProjectWrapp{
	public  FxRatePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	
	public FxRatePage clickFxRate() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.FxRate.menu.xpath"));	
	return this;
	}
	
	

public FxRatePage locatingFrames() throws InterruptedException{
locateFrame("icanvas");

return this;
}
	public FxRatePage ExchangeRateForm() throws InterruptedException{

VerifyElementPresent(prop.getProperty("verify.ExchangeRate.xpath"),"Exchange Rates has been displayed successfully", "Exchange Rates has not been displayed successfully");


		return this;
	}
	

}
