package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class fundtransferpage  extends ProjectWrapp{
	public  fundtransferpage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public fundtransferpage clickaddpayeemenu() throws InterruptedException{
		
	   clickByXpathExplict(prop.getProperty("click.addpayeemenu.xpath"));

		return this;
	}	
	public fundtransferpage clickmanagepayee() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.manage.payee.link.xpath"));

	     
	     
		return this;
	}		
	
	
	
	
	

	public TransferHistoryPage  clickTransferHistory() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.oktransfer.history.link.xpath"));
		

	return new TransferHistoryPage(driver, test);
	}
	
	public fundtransferpage clickotherbankpayee() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.otherbankpayee.xpath"));

	     
	     
		return this;
	}			
	
	public fundtransferpage clickjanabankpayee(String janaPayeeNickname) throws InterruptedException{
		
		
		scrolltoelementJs("(.//table[@aria-describedby='DataTables_Table_1_info']//input[contains(@value,'"+janaPayeeNickname+"')]/following::label)[1]");

		
		clickByXpathExplict("(.//table[@aria-describedby='DataTables_Table_1_info']//input[contains(@value,'"+janaPayeeNickname+"')]/following::label)[1]");
	
			return this;
		}			

	
	
	
	public fundtransferpage clickotherbankpayeeButton(String otherpayeenickname) throws InterruptedException{
		scrolltoelementJs("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");

	     clickByXpathExplict("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");

	     
	     
		return this;
	}				
public fundtransferpage verifyBeneficiaryDeletion(String otherpayeenickname) throws InterruptedException{

VerifyElementnotPresent("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]","Beneficiary has deleted successfully","Beneficiary has not deleted successfully");
	     
	     
		return this;
	}				
	
	
public fundtransferpage verifyJanaBeneficiaryDeletion(String otherpayeenickname) throws InterruptedException{

VerifyElementnotPresent("(.//table[@aria-describedby='DataTables_Table_1_info']//input[contains(@value,'"+otherpayeenickname+"')]/following::label)[1]","Beneficiary has deleted successfully","Beneficiary has not deleted successfully");
	     
     
		return this;
	}			
	
	public fundtransferpage clickotherpayeeDelete() throws InterruptedException{
	     clickByXpathExplict(prop.getProperty("click.manage.delete.payee.xpath"));
	     clickByXpathExplict(prop.getProperty("click.manage.delete.submit.xpath"));
	
			return this;
		}				
		
	
	public fundtransferpage clickDeleteOtherConfirm() throws InterruptedException{
	     clickByXpathExplict(prop.getProperty("click.otherbank.deleteconfirm.xpath"));
	 	
		
	return this;
}				


	public JSFB_JanabankTransferPage clickInitiatetrans() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.initiate.tran.xpath"));

		return new JSFB_JanabankTransferPage(driver, test);
	}
	
	
	public JanaBank_AddPayee clickjanabank() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.janapayee.xpath"));

		return new JanaBank_AddPayee(driver, test);
	}	
	
	

	public OwnAcctransfer clickintiatelink() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("intiate.trans.link.xpath"));

		return new OwnAcctransfer(driver, test);
	}	
		

	
	
	
	
	
	
	public OtherBank_AddPayee clickotherpayee() throws InterruptedException{
		
     clickByXpathExplict(prop.getProperty("click.otherpayee.xpath"));

		return new OtherBank_AddPayee(driver, test);
	}	
	
	
	
}
