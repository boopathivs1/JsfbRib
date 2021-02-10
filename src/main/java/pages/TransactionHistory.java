package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class TransactionHistory extends ProjectWrapp{
	public  TransactionHistory(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	

public TransactionHistory filterTransactionHistory(String fromacc,String beneficiarytype,String channeltype,String toAcccTransHistory) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromacc);
	String toaccount=regvalue(toAcccTransHistory);

	dropdownSelection(prop.getProperty("click.from.acc.history.xpath"),fromaccount);
	
	dropdownSelection(prop.getProperty("click.beneficiarytype.xpath"),beneficiarytype);
	dropdownSelection(prop.getProperty("select.beneficiary.acc.xpath"),toaccount);
	
	
	
	dropdownSelection(prop.getProperty("click.channeltype.xpath"),channeltype);
	
clickByXpathExplict(prop.getProperty("click.fromdate.xpath"));	


clickByXpathExplict(prop.getProperty("clicktoday.date.xpath"));	
clickByXpathExplict(prop.getProperty("click.upto.date.xpath"));	
clickByXpathExplict(prop.getProperty("click.today.button.xpath"));	
clickByXpathExplict(prop.getProperty("click.filter.trans.history.xpath"));	

	
	
	
return this;
}
public TransactionHistory filterTransactionHistoryOwnAcc(String fromacc,String beneficiarytype,String channeltype,String toAcccTransHistory) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromacc);
	String toaccount=regvalue(toAcccTransHistory);

	dropdownSelection(prop.getProperty("click.from.acc.history.xpath"),fromaccount);
	
	dropdownSelection(prop.getProperty("click.beneficiarytype.xpath"),beneficiarytype);

dropdownSelectionindex(prop.getProperty("select.beneficiary.acc.xpath"),toaccount,2);	
	
	
	dropdownSelection(prop.getProperty("click.channeltype.xpath"),channeltype);
	
clickByXpathExplict(prop.getProperty("click.fromdate.xpath"));	


clickByXpathExplict(prop.getProperty("clicktoday.date.xpath"));	
clickByXpathExplict(prop.getProperty("click.upto.date.xpath"));	
clickByXpathExplict(prop.getProperty("click.today.button.xpath"));	
clickByXpathExplict(prop.getProperty("click.filter.trans.history.xpath"));	

	
	
	
return this;
}

public TransactionHistory locatingFrames() throws InterruptedException{
locateFrame("icanvas");

return this;
}
	
public TransactionHistory transactionHistory(String fromacc,String beneficiarytype,String channeltype,String beneficiaryaccNum) throws InterruptedException{
	
//	String fromaccount=regvalue(fromacc);
//	String toaccount=regvalue(beneficiaryaccNum);
//
//	dropdownSelection(prop.getProperty("click.from.acc.history.xpath"),fromaccount);
//	
//	dropdownSelection(prop.getProperty("click.beneficiarytype.xpath"),beneficiarytype);
//	dropdownSelection(prop.getProperty("select.beneficiary.acc.xpath"),toaccount);
//	
//	
//	
//	dropdownSelection(prop.getProperty("click.channeltype.xpath"),channeltype);
//	


	clickByXpathExplict(prop.getProperty("click.fromdate.xpath"));	

	
//	selectVisibileTextByXPath(prop.getProperty("select.month.calendar.xpath"),"Jan");
	clickByXpathExplict(".//button[@data-handler='today']//preceding::a[text()='1']");	

	
	
//clickByXpathExplict(prop.getProperty("click.first.day.xpath"));	
clickByXpathExplict(prop.getProperty("click.upto.date.xpath"));	
clickByXpathExplict(prop.getProperty("click.today.button.xpath"));	
clickByXpathExplict(prop.getProperty("click.filter.trans.history.xpath"));	

	
	
	
	
return this;
}








public TransactionHistory transactionHisacc(String fromacc,String beneficiarytype,String channeltype,String beneficiaryaccNum,String dropindex) throws InterruptedException{

String fromaccount=regvalue(fromacc);
String toaccount=regvalue(beneficiaryaccNum);

dropdownSelection(prop.getProperty("click.from.acc.history.xpath"),fromaccount);

dropdownSelection(prop.getProperty("click.beneficiarytype.xpath"),beneficiarytype);


if(dropindex.equalsIgnoreCase("one")){
dropdownSelection(prop.getProperty("select.beneficiary.acc.xpath"),toaccount);
}
else{
	dropdownSelectionindex(prop.getProperty("select.beneficiary.acc.xpath"),toaccount,2);
}


clickByXpathExplict(prop.getProperty("click.filter.trans.history.xpath"));	





return this;
}














public TransactionHistory verifyTransactionHistory(String amount) throws InterruptedException{
	String amt=regvalue(amount);	
	
	//verifyTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
	
	//enable below
	verifyExactTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);

	
	
	//	verifyTextMatchlistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
	
	
return this;
}



public TransactionHistory verifyTransactionHistoryBillers(String amount) throws InterruptedException{
String amt=regvalue(amount);	
	
	//verifyTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
	System.out.println(amt);
		
	
	String str = amt;
	String digits="";
	for (int i = 0; i < str.length(); i++) {
	    char chrs = str.charAt(i);
	    if (Character.isDigit(chrs)){
	    	digits = digits+chrs;
	}
	System.out.println(digits);

			}


	String getbal = digits.substring(0,2);

	
	
	System.out.println("qqqqqq");
	System.out.println("retrived balance"+getbal+"");
	
	//verifyExactTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),firsttwonum);

verifyExactTextcontainslistReg(prop.getProperty("verify.within.transferhistory.xpath"),getbal);
	
	//	verifyTextMatchlistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
	
	/*
	Boolean a=driver.getPageSource().contains(amount);
	if(a){
		reportStep("Transaction amount has matched", "PASS");
	}
	else{
		reportStep("Transaction amount has not matched", "PASS");

	}
	*/
	
return this;
}

public TransactionHistory verifyTransactionHistoryPresent() throws InterruptedException{
	
	VerifyElementPresent(prop.getProperty("transaction.history.list.xpath"),"Transaction History has been displaying","Transaction History has not been displaying");
	
	
	
return this;
}




public Accounts clickAccountMenu() throws InterruptedException{
	
	defaultcontent();
	clickByXpathExplict(prop.getProperty("click.account.menu.name.xpath"));	

	
	

return new Accounts(driver, test);
}








}