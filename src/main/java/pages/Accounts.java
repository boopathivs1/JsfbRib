package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Accounts extends ProjectWrapp{
	public  Accounts(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	public Accounts verifyCreditCardTab(String ValidMsg,String InvalidMsg) throws InterruptedException{
		
	//	scrolltoelementJs(prop.getProperty("verify.creditcard.tab.xpath"));
		//Thread.sleep(5000);
		

		VerifyElementPresent(prop.getProperty("verify.creditcard.tab.xpath"), ValidMsg,InvalidMsg);
		
		return this;
		}	

	public Accounts verifySupplimentaryCardTab(String ValidMsg,String InvalidMsg) throws InterruptedException{
		
		scrolltoelementJs(prop.getProperty("creditcard.suplimentary.visa.xpath"));
		//Thread.sleep(5000);
		

		VerifyElementPresent(prop.getProperty("creditcard.suplimentary.visa.xpath"), ValidMsg,InvalidMsg);
		
		return this;
		}	

	
	
	
	public Accounts verifyTermDeposit(String nickname,String updateNickname) throws InterruptedException{
clickByXpathExplict(prop.getProperty("click.edit.deposit.nickname.icon.xpath"));		

String a=randomStringGeneration();

enterByXpathExplict(prop.getProperty("enter.input.deposit.nickname.xpath"),a);
clickByXpathExplict(prop.getProperty("click.update.deposit.nickname.button.xpath"));
verifyTextByXpathExplicitwait(prop.getProperty("Verify.nickname.deposit.xpath"),a);
//Thread.sleep(8000);

/*
Boolean a=VerifyElementpresentreturn(prop.getProperty("click.edit.deposit.nickname.icon.xpath"));

if(a){
	clickByXpathExplict(prop.getProperty("click.edit.deposit.nickname.icon.xpath"));		
	
}

else{
reportStep("edit icon could not display","FAIL");	
}


//clickByXpathExplict(prop.getProperty("click.edit.deposit.nickname.icon.xpath"));		
enterByXpathExplict(prop.getProperty("enter.input.deposit.nickname.xpath"),updateNickname);
clickByXpathExplict(prop.getProperty("click.update.deposit.nickname.button.xpath"));
	*/	
		return this;
		}	

	
	
	
		
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

public Accounts clicklastStatement() throws InterruptedException{
//	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("payment.laststatement.xpath"));
	
	return this;
	}	

	
	
	public Accounts clickBilledTransactionTab() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("bill.transaction.tab.xpath"));
	//	Thread.sleep(3000);
		return this;
		}	

	public Accounts supplimentaryCards() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("supplimentary.card.statement.xpath"));
		
		return this;
		}	
	public Accounts last6Statements() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("six.month.statement.xpath"));
		
		return this;
		}	

	
	
	
	
	
	
	
	
	
	
	
	
	public Accounts clickViewDetailsLinksandVerify(String ValidMsg,String invalidMsg) throws InterruptedException{
//Thread.sleep(8000);
		clickByXpathExplict(prop.getProperty("click.viewdetails.creditprepaid.xpath"));
		VerifyElementPresent(prop.getProperty("verify.credit.prepaid.summary.xpath"), ValidMsg,invalidMsg);
	return this;	
	}
	public Accounts clickLoanViewDetailsLinksandVerify(String ValidMsg,String invalidMsg) throws InterruptedException{

		clickByXpathExplict(prop.getProperty("click.loandetails.view.xpath"));
		VerifyElementPresent(prop.getProperty("loan.balance.verify.details.xpath"), ValidMsg,invalidMsg);
	return this;	
	}
	
	
	
	public Accounts clickLoanViewDetailsLinksandVer(String ValidMsg,String invalidMsg) throws InterruptedException{

		clickByXpathExplict(prop.getProperty("click.loandetails.view.xpath"));
	//	VerifyElementPresent((".//h4[text()='Loan Details']"), ValidMsg,invalidMsg);
	return this;	
	}
	
//click.loandetails.view.xpath	
	

	public Accounts clickViewDetailsLinks() throws InterruptedException{

		clickByXpathExplict(prop.getProperty("Click.ViewDetails.click.xpath"));
		
	return this;	
	}

	
	public Accounts updateNickame(String Nickname,String UpdateNickname) throws InterruptedException{
	//	clickByXpathExplict(prop.getProperty("Click.ViewDetails.click.xpath"));
		clickByXpathExplict(prop.getProperty("Click.editbutton.xpath"));
		
		String a=randomStringGeneration();
		
enterByXpathExplict(prop.getProperty("Click.enter.Account.nickname.xpath"),a);
clickByXpathExplict(prop.getProperty("Click.update.nickname.button.xpath"));		
		verifyTextByXpathExplicitwait(prop.getProperty("Verify.NickName.xpath"),a);		

/*
		Thread.sleep(20000);
		clickByXpathExplict(prop.getProperty("Click.editbutton.xpath"));
		
		Thread.sleep(8000);
		
		enterByXpathExplict(prop.getProperty("Click.enter.Account.nickname.xpath"),UpdateNickname);
		clickByXpathExplict(prop.getProperty("Click.update.nickname.button.xpath"));		
*/
		
		return this;	
	}
	
	
	
	
	
	

public Accounts verifyAccountsPagebalance() throws InterruptedException{
	locateFrame("icanvas");
	
	Thread.sleep(3000);
	
	
	String finalAccountBalance = null;
	

Boolean a=VerifyElementpresentreturn(prop.getProperty("getstatement.account.balance.xpath"));



if(a){
	finalAccountBalance=getTextByXpath(prop.getProperty("getstatement.account.balance.xpath"));
//	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	reportStep("Balanec has displaying "+finalAccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+finalAccountBalance+"");

}

	
/*	
//String finalAccountBalance=getTextByXpath(prop.getProperty("getstatement.account.balance.xpath"));

System.out.println(AccountBalance);
	System.out.println(finalAccountBalance);

//	AccountBalance="100";
	
	
	int AccBalance=Integer.parseInt(AccountBalance);  
	int finalAccBalanc=Integer.parseInt(finalAccountBalance);  
System.out.println("&&&&&&");
	System.out.println(AccBalance);
	System.out.println(finalAccBalanc);
	Thread.sleep(2000);
	verifyGreaterValues(AccBalance, finalAccBalanc,"Balance has been deducted in Account Balance","Balance has not been deducted in Account Balance");
	*/
//	verifyNottextmatches(AccountBalance,finalAccountBalance);
	verifyNottextmatches(AccountBalance,finalAccountBalance,"Balance has been deducted in Account Balance","Balance has not been deducted in Account Balance");

	
	
return this;
}

public Accounts verifyMiniStatementbalance(String amount) throws InterruptedException{

//pageScroll();
	String amt=regvalue(amount);	
	//clickByXpathExplict(prop.getProperty("click.trans.menu.link.xpath"));
//	Thread.sleep(2000);
	pageScroll400();
//	Thread.sleep(2000);
	//verifyTextContainsByXpath(prop.getProperty("verify.accbalance.xpath"),amt);
return this;
}	
	
public Accounts verifyStatement(String ValidMsg,String InvalidMsg) throws InterruptedException{
	
	
	VerifyElementPresent(prop.getProperty("ministatemt.verify.xpath"), ValidMsg,InvalidMsg);
	
	return this;
	}		






public Accounts rechargetab() throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.prepaid.recharge.link.xpath"));
	
return this;	
}





public Accounts clickdetailtab() throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.detail.stat.tab.xpath"));
	
return this;	
}






public Accounts VerifydetailtabResult(String validmsg,String invalidmsg) throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.detail.stat.filter.tab.xpath"));

	scrolltoelementJs(prop.getProperty("click.both.filter.icon.xpath"));
	Thread.sleep(2000);
	System.out.println("element will be click");

	enterByXpathExplict("(.//input[contains(@class,'ws-number')])[1]","1");
	enterByXpathExplict("(.//input[contains(@class,'ws-number')])[2]","1000");
	dropdownSelection(prop.getProperty("click.detail.filter.yeardrop.xpath"),"Last 1 year");
	

clickByXpathExplict(prop.getProperty("click.both.filter.icon.xpath"));
	

clickByXpathExplict(prop.getProperty("click.accdetails.filterbutton.xpath"));
	



VerifyElementPresent(prop.getProperty("ministatemt.verify.xpath"), validmsg,invalidmsg);



return this;	
}





public Accounts VerifychequeHistory(String Validmsg,String invalidmsg) throws InterruptedException{

	clickByXpathExplict(prop.getProperty("click.chequehistory.tab.xpath"));

	VerifyElementPresent(prop.getProperty("click.chequehistory.statement.tab.xpath"), Validmsg,invalidmsg);
	
	


return this;	

}




}