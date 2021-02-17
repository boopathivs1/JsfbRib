package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class JSFB_DashBoard_Page extends ProjectWrapp{
	public  JSFB_DashBoard_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public JSFB_DashBoard_Page clickOverviewButton() throws InterruptedException{
	
		
	     clickByXpathExplict(prop.getProperty("click.overview.button.xpath"));

		return this;
	}
	
	public DepositPage clickDepositMenu() throws InterruptedException{
		
		
	     clickByXpathExplict(prop.getProperty("click.deposit.menu.xpath"));

		return new DepositPage(driver, test);
	}
	
	
	public BillPaymentPage ClickBillpay() throws InterruptedException{
		
		   clickByXpathExplict(prop.getProperty("click.billpay.xpath"));

			return new BillPaymentPage(driver, test);
		}
	
	
	public JSFB_DashBoard_Page locatingFrames() throws InterruptedException{
		
	locateFrameById("canvas");
	return this;
	}
	
	public RegularFDNoncummulativePage ClickDeposit() throws InterruptedException{
		
		 clickByXpathExplict(prop.getProperty("click.deposit.xpath"));
		return new RegularFDNoncummulativePage(driver,test);
		}
	
	
	public JSFB_DashBoard_Page FillFavTransForm(String Payee,String accno,String MOde,String amount,String Remarks) throws InterruptedException{
		
		String accnum= regvalue(accno);
		String amt= regvalue(amount);
	
		clickByXpath(prop.getProperty("click.dropdown.payee.xpath"));
		clickByXpath("//div[contains(text(),'"+Payee+"')]");
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("click.dropdown.account.xpath"));
		clickByXpath("//div[.='"+accnum+"']");
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("click.dropdown.mode.xpath"));
		clickByXpath("//div[contains(text(),'"+MOde+"')]");
		enterByXpathExplict(prop.getProperty("enter.fav.amount.xpath"), amt);
		enterByXpathExplict(prop.getProperty("enter.fav.remarks.xpath"), Remarks);
		clickByXpathExplict(prop.getProperty("click.button.paynow.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.ownacc.confirm.submit.xpath"));
		
		return this;
		}
	
	public JSFB_DashBoard_Page otpVerify(String otpnum) throws InterruptedException{				
		submitOtp(otpnum);
	    VerifyElementPresent(prop.getProperty("verify.otherpayee.successfule.xpath"),"Favourite transaction Transfer Done","Favourite transaction Transfer has failed");
	    return this;
		
	}
	public JSFB_DashBoard_Page  clickOkTransfer() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.oktransfer.button.link.xpath"));
		

	return this;

	}
	
	

	
	
	
	public loanspage clickloanlink() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.loanmenulink.xpath"));

		return new loanspage(driver, test);
	}
	public fundtransferpage clickfundtrans() throws InterruptedException{
	
	     clickByXpathExplict(prop.getProperty("click.fundtransmenu.xpath"));

		return new fundtransferpage(driver, test);
	}	
	
	
	

			public fundtransferpage clickintiatetrans() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("intiate.trans.link.xpath"));

		return new fundtransferpage(driver, test);
	}
				
			
	

	
	public JSFB_ServicePage clickServices() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.services.xpath"));

		return new JSFB_ServicePage(driver,test);
	}
	
	
	
	public JSFB_DashBoard_Page ClickFD() throws InterruptedException{
	
	     clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		return this;
	}
	
	
	public JSFB_DashBoard_Page ClickLoan() throws InterruptedException{
		
		pageScroll();
		
	     clickByXpathExplict(prop.getProperty("click.Loan.xpath"));
		return this;
	}
	
	public JSFB_DashBoard_Page ClickRD() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.RD.xpath"));
		return this;
	}
	
	
	
	public JSFB_DashBoard_Page verifyFDSummary() throws InterruptedException{
	
	 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Fixed Deposit summary has been displaying","Fixed Deposit summary has not been displaying");
		return this;
		}
	
	public JSFB_DashBoard_Page verifyRDSummary() throws InterruptedException{
		
		 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Recurring Deposit summary has been displaying","Recurring Deposit summary has not been displaying");
			return this;
			}
	
	public JSFB_DashBoard_Page verifyLoanSummary() throws InterruptedException{
		
		 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Loan summary has been displaying","Loan summary has not been displaying");
			return this;
			}
	
	
	public JSFB_DashBoard_Page verifyStatement(String accno,String Month) throws InterruptedException{
clickByXpathExplict(".//a[text()='"+accno+"']");
clickByXpathExplict(prop.getProperty("click.monthdropdown.xpath"));
clickByXpathExplict(".//div[contains(text(),'"+Month+"')]");
clickByXpathExplict(prop.getProperty("clickdetailsStmt.xpath"));





		return this;
	}




	
	
	public JSFB_DashBoard_Page verifyaccSummary() throws InterruptedException{
	
	 VerifyElementPresent(prop.getProperty("click.accSummary.xpath"),"Account summary has been displaying","Account summary has not been displaying");
		return this;
		}
		  
	
	
	
	
	
		
	
	
	
}
