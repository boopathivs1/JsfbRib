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
	
	
	public fundtransferpage clickotherbankpayee() throws InterruptedException{
		
	     clickByXpathExplict(prop.getProperty("click.otherbankpayee.xpath"));

	     
	     
		return this;
	}			
	
	public fundtransferpage clickjanabankpayee(String janaPayeeNickname) throws InterruptedException{
		scrolltoelementJs("(.//table[@aria-describedby='DataTables_Table_1_info']//input[contains(@value,'~Active~"+janaPayeeNickname+"')]/following::label)[1]");

		
		clickByXpathExplict("(.//table[@aria-describedby='DataTables_Table_1_info']//input[contains(@value,'~Active~"+janaPayeeNickname+"')]/following::label)[1]");
	
			return this;
		}			

	
	
	
	public fundtransferpage clickotherbankpayeeButton(String otherpayeenickname) throws InterruptedException{
		scrolltoelementJs("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");

	     clickByXpathExplict("(.//input[contains(@value,'EXTSUBMOD~"+otherpayeenickname+"')]//following::label)[1]");

	     
	     
		return this;
	}				
	
	
	
	public fundtransferpage clickotherpayeeDelete() throws InterruptedException{
	     clickByXpathExplict(prop.getProperty("click.manage.delete.payee.xpath"));
	     clickByXpathExplict(prop.getProperty("click.manage.delete.submit.xpath"));
	
			return this;
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
