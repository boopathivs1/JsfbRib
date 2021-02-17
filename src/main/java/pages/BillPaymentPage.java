package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BillPaymentPage  extends ProjectWrapp{
	public  BillPaymentPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

		
	
	public BillPaymentPage ClickBillpayment() throws InterruptedException{
		
		   clickByXpathExplict(prop.getProperty("click.billpayment.xpath"));

			return this;
		}
		
	
	public BillPaymentPage ClickElectricity() throws InterruptedException{
		

		clickByXpathvalue(prop.getProperty("click.electricity.xpath"));

			return this;
		}
	
	
public BillPaymentPage ClickGas() throws InterruptedException{
		

	clickByXpathvalue(prop.getProperty("click.gas.xpath"));

			return this;
		}
		
		
	public BillPaymentPage FillBillpaymentForm(String state, String biler,String Consumerno,String Fromacc) throws InterruptedException{
		
		String accno = regvalue(Fromacc);
		System.out.println(accno);
	
		selectVisibileTextByXPath(prop.getProperty("select.state.dropdown.xpath"), state);
		selectVisibileTextByXPath(prop.getProperty("select.electricity.biller.dropdown.xpath"), biler);
		enterByXpathvalue(prop.getProperty("enter.consumer.num.xpath"), Consumerno);
		clickByXpathvalue(prop.getProperty("click.fetchbill.xpath"));
		clickByXpathvalue(prop.getProperty("click.continue.pay.xpath"));
		clickByXpathvalue(prop.getProperty("click.fromacc.dropdown.xpath"));
		 
		clickByXpathvalue("//div[@class='item active selected'][.='"+accno+"']");
		 
		clickByXpathvalue(prop.getProperty("click.billpayment.submit.xpath"));
		clickByXpathvalue(prop.getProperty("click.billpayment.confirm.xpath"));
			return this;
		}
	
	
public BillPaymentPage FillBillpaymentGasForm(String biler,String Consumerno,String Fromacc) throws InterruptedException{
		
		String accno = regvalue(Fromacc);
		System.out.println(accno);
	
		selectVisibileTextByXPath(prop.getProperty("select.gas.provider.xpath"), biler);
		enterByXpathvalue(prop.getProperty("enter.bpno.xpath"), Consumerno);
		clickByXpathvalue(prop.getProperty("click.fetchbill.xpath"));
		clickByXpathvalue(prop.getProperty("click.continue.pay.xpath"));
		clickByXpathvalue(prop.getProperty("click.fromacc.dropdown.xpath"));
		 
		clickByXpathvalue("//div[@class='item active selected'][.='"+accno+"']");
		 
		clickByXpathvalue(prop.getProperty("click.billpayment.submit.xpath"));
		clickByXpathvalue(prop.getProperty("click.billpayment.confirm.xpath"));
			return this;
		}
	
	public BillPaymentPage SubmitOTP(String OTP) throws InterruptedException{
	     
		enterByXpathExplict(prop.getProperty("enter.otp.xpath"),OTP);
	
		clickByXpathExplict(prop.getProperty("click.otp.submit.xpath"));
				return this;
			}
	
	public BillPaymentPage  clickOkTransfer() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.oktransfer.button.link.xpath"));
		

	return this;

	}
	
	public TransferHistoryPage  clickTransferHistory() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.oktransfer.history.link.xpath"));
		

	return new TransferHistoryPage(driver, test);
	}	
		
	
}
