package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class TransferPage extends ProjectWrapp{
	public  TransferPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	public TransferPage clickwithinBracMenu() throws InterruptedException{
		loadtime();
		boolean a=VerifyElementpresentreturn(prop.getProperty("click.transfer.within.bank.menu.xpath"));	
		clickByXpathExplict(prop.getProperty("click.transfer.within.bank.menu.xpath"));		
loadtime();		
		return this;

	}
	public TransferPage clickAddBeneficiaryButtonNoFrames() throws InterruptedException{

		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.AddBeneficiary.button.xpath"));
		
			
			return this;
		}
	public TransferPage clickMobileWalletDropdown() throws InterruptedException{
		
		//Boolean a=VerifyElementpresentreturn(prop.getProperty("click.walletPay.menu.xpath"));
	loadtime();
	scrolltoelementJs(prop.getProperty("click.walletPay.menu.xpath"));	
	clickByXpathExplict(prop.getProperty("click.walletPay.menu.xpath"));	
	loadtime();
			return new TransferPage(driver, test);

	}

	public TransferPage clickWalletMenu(String walletmenu) throws InterruptedException{
		loadtime();

		Boolean a=VerifyElementpresentreturn(".//p[text()='"+walletmenu+"']");
		scrolltoelementJs(".//p[text()='"+walletmenu+"']");
		clickByXpathExplict(".//p[text()='"+walletmenu+"']");		
		loadtime();
			return new TransferPage(driver, test);

	}
	

public TransferPage clickAddBeneficiaryButton() throws InterruptedException{

	locateFrame("icanvas");

	clickByXpathExplict(prop.getProperty("click.AddBeneficiary.button.xpath"));
	
		
		return this;
	}


public TransferPage locatingFrames() throws InterruptedException{



locateFrame("icanvas");

return this;
}

public TransferPage clickAddBeneficiaryMobie_Wallet() throws InterruptedException{
	locateFrame("icanvas");
	Thread.sleep(4000);
	

Boolean a=VerifyElementpresentreturn(prop.getProperty("click.AddBeneficiary.button.xpath"));
if(a){
clickByXpathExplict(prop.getProperty("click.AddBeneficiary.button.xpath"));
}
else{
	booleanResultFail(a, "Add beneficiary element has not display");
}

	
	

//	clickByXpathExplict(prop.getProperty("click.AddBeneficiary.button.xpath"));
	
		
		return this;
	}
public TransferPage clickCardTab() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.card.tab.xpath"));
	
		
		return this;
	}
public TransferPage fillWithinBank_Account_Beneficiary(String accnumber,String nickname) throws InterruptedException{
	
	
	String regAccnum=regvalue(accnumber);
	enterByXpathExplict(prop.getProperty("Enter.within.Acc.number.xpath"),regAccnum);
	//clickByXpathExplict(prop.getProperty("click.within.bankpayee.xpath"));
	
	enterByXpath(prop.getProperty("enter.payee.acc.name.xpath"),nickname);
	
	
//Thread.sleep(6000);
	enterByXpathExplict(prop.getProperty("enter.within.bankpayee.xpath"),nickname);
	scrolltoelementJs(prop.getProperty("click.withinbank.sms.xpath"));
	clickByXpathExplict(prop.getProperty("click.withinbank.sms.xpath"));
	scrolltoelementJs(prop.getProperty("click.within.beneficiary.xpath"));


	clickByXpathExplict(prop.getProperty("click.within.beneficiary.xpath"));

	
		return this;
	}


public TransferPage fillOtherBank_Account_Beneficiary(String BankNameDropDown,String BranchCode,String accnumber,String nickname) throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.npsb.xpath"));
	scrolltoelementJs(prop.getProperty("click.BankName.dropdown.xpath"));
	dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),BankNameDropDown);
	
	dropdownSelection(prop.getProperty("click.branchcode.dropdown.xpath"),BranchCode);
	
	String regAccnum=regvalue(accnumber);
	enterByXpathExplict(prop.getProperty("Enter.within.Acc.number.xpath"),regAccnum);
	
//	clickByXpathExplict(prop.getProperty("click.within.bankpayee.xpath"));

	enterByXpathExplict(prop.getProperty("click.within.bankpayee.xpath"),nickname);
	
	enterByXpathExplict(prop.getProperty("enter.other.bankpayeeshortname.xpath"),nickname);
	
	pageScroll();
	
	clickByXpathExplict(prop.getProperty("click.otherbank.sms.xpath"));
	clickByXpathExplict(prop.getProperty("click.within.beneficiary.xpath"));

	
		return this;
	}


public TransferPage clickbenbutton() throws InterruptedException{
	scrolltoelementJs(prop.getProperty("click.beneedit.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.beneedit.button.xpath"));
	
		
		return this;
	}

public TransferPage clickConfirmbutton() throws InterruptedException{
	scrolltoelementJs(prop.getProperty("click.confirm.beneficiary.button.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.confirm.beneficiary.button.xpath"));
	
		
		return this;
	}


public TransferPage otpsubmit() throws InterruptedException{
	Thread.sleep(2000);
	DBOTP_function();
	enterByXpathExplict(prop.getProperty("enter.otp.password.xpath"),DbOTP);
	
//	enterByXpathExplict(prop.getProperty("enter.otp.password.xpath"),"123456");
//	scrolltoelementJs(xpathtext);
	clickByXpathExplict(prop.getProperty("click.submit.otp.button.xpath"));
	
		return this;
	}
public TransferPage verifyBeneficiaryAdded(String accnumber) throws InterruptedException{

			String  regaccnum=regvalue(accnumber);
//Boolean a=VerifyElementpresentreturn(prop.getProperty("verify.success.Beneficiarty.message.xpath"));

VerifyElementPresent(prop.getProperty("verify.success.Beneficiarty.message.xpath"),"Beneficiary has added sucessfully","Beneficiary has not added successfully");
//	verifyTextByXpathExplicitwait(".//span[text()='"+regaccnum+"']",regaccnum);
	
	
	
	
	
	return this;
	}



public TransferPage verifyEditSearchBeneficiary(String beneficiaryName) throws InterruptedException{

scrolltoelementJs(prop.getProperty("click.view.beneficiary.button.xpath"));
clickByXpathExplict(prop.getProperty("click.view.beneficiary.button.xpath"));

enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);

verifyTextByXpathExplicitwait(".//span[text()='"+beneficiaryName+"']",beneficiaryName);


return this;
}



public TransferPage verifySearchBeneficiary(String beneficiaryName) throws InterruptedException{

scrolltoelementJs(prop.getProperty("click.view.beneficiary.xpath"));
clickByXpathExplict(prop.getProperty("click.view.beneficiary.xpath"));

enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);

verifyTextByXpathExplicitwait(".//span[text()='"+beneficiaryName+"']",beneficiaryName);


return this;
}



public TransferPage clicktransferOtherBank() throws InterruptedException{

	loadtime();
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.transferotherbank.xpath"));
	scrolltoelementJs(prop.getProperty("click.transferotherbank.xpath"));
clickByXpathExplict(prop.getProperty("click.transferotherbank.xpath"));
loadtime();

return this;
}
public TransferPage fillOtherBankTransferForm() throws InterruptedException{


dropdownSelection(".//div[@id='accountid_chosen']","1507202123474001 | BDT");

clickByXpathExplict(".//i[text()='Accounts']");	



dropdownSelection("(.//div[@id='beneficiaryInstructionId_chosen'])[1]","");



enterByXpathExplict(".//input[@id='transactionAmount']","10");



//dropdowncitySelection(".//div[@id='transactionCurrency_chosen']","");

return this;
}


public TransferPage transferotherBaracForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	
	
	
	dropdownSelection(prop.getProperty("click.fundTransfer.fromdropdown.xpath"),fromaccount);	
	
	Thread.sleep(2000);

Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

}


if(acctype.equalsIgnoreCase("CreditCard")){
		
		
		scrolltoelementJs(prop.getProperty("click.creditcard.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		//scrolltoelementJs(prop.getProperty("enter.transaction.amount.xpath"));
//pageScroll400();
		
		
		
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
	
//		Thread.sleep(10000);
		//clickByXpath(".//label[contains(text(),'Amount')]");
		
		
	clickByXpath(prop.getProperty("click.amount.lablel.xpath"));
		System.out.println("element will click");
		Thread.sleep(3000);
		
		// MouseHoverByXpathExplict(prop.getProperty("click.benefiary.choosen.acc.xpath"));
		
		//scrolltoelementJs(prop.getProperty("click.benefiary.choosen.acc.xpath"));
		dropdownSelection(prop.getProperty("click.benefiary.choosen.acc.xpath"),toaccount);
	}
	else if(acctype.equalsIgnoreCase("Account")){

scrolltoelementJs(prop.getProperty("enter.transaction.amount.xpath"));
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
	
	//	Thread.sleep(10000);
//		scrolltoelementJs(prop.getProperty("click.beneificiary.acc.firstindex.xpath"));
	
//		 MouseHoverByXpathExplict(prop.getProperty("click.beneificiary.acc.firstindex.xpath"));
		clickByXpath(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
		System.out.println("element will click");
		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);
		
		
		
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}


public TransferPage transferOwnAccountCardBaracForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	
	
	

		if(acctype.equalsIgnoreCase("CreditCard")){
			clickByXpathExplict(prop.getProperty("click.ownacc.creditcard.button.xpath"));
		
fromAcc(fromaccount);		
		
		scrolltoelementJs(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"));
//		Thread.sleep(4000);
		dropdownSelection(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"),toaccount);
	//	Thread.sleep(2000);
		scrolltoelementJs(prop.getProperty("click.otherradio.button.xpath"));
	//	Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("click.otherradio.button.xpath"));
		
//		enterByXpathExplict(prop.getProperty("other.payamt.xpath"),amt);

		enterByXpathExplict(prop.getProperty("enter.owncard.transamt.xpath"),amt);
			
		
		
	}
	else if(acctype.equalsIgnoreCase("Account")){
		
		fromAcc(fromaccount);		
			
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
//		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);
		
		dropdownSelectionindex(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount,2);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}




public TransferPage transferOwnAccCard(String fromAcc,String Miniamount,String toAcc,String acctype,String Maxamount) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String miniamt=regvalue(Miniamount);	
	
	
	

		if(acctype.equalsIgnoreCase("CreditCard")){
			clickByXpathExplict(prop.getProperty("click.ownacc.creditcard.button.xpath"));
		
fromAcc(fromaccount);		
		scrolltoelementJs(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"));
		
//		Thread.sleep(4000);
		dropdownSelection(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"),toaccount);
	//	Thread.sleep(2000);
		scrolltoelementJs(prop.getProperty("click.otherradio.button.xpath"));
	//	Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("click.otherradio.button.xpath"));
		
//		enterByXpathExplict(prop.getProperty("other.payamt.xpath"),amt);

		enterByXpathExplict(prop.getProperty("enter.owncard.transamt.xpath"),miniamt);
			
		
		
	}
	else if(acctype.equalsIgnoreCase("Account")){
		
		fromAcc(fromaccount);		
			
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),miniamt);
		
//		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);
		scrolltoelementJs(prop.getProperty("click.beneificiary.acc.firstindex.xpath"));
		dropdownSelectionindex(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount,2);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}







public TransferPage clickownacclink() throws InterruptedException{
	
	//Boolean a=VerifyElementpresentreturn("(.//nav[@id='transferssubnav']//following::li[@class='active']//p[contains(text(),'Accounts')])[1]");
	loadtime();
//	verifyMenuavailable();
	
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.transfer.myacc.xpath"));
	clickByXpathExplict(prop.getProperty("click.transfer.myacc.xpath"));
	loadtime();
	
	
return this;

}
public void verifyMenuavailable(){
Boolean a=VerifyElementpresentreturn(".//p[contains(text(),'Accounts')])[1]");

}
public TransferPage transferOwnAccountBaracForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	
	
	

		if(acctype.equalsIgnoreCase("CreditCard")){
			clickByXpathExplict(prop.getProperty("click.ownacc.creditcard.button.xpath"));
		
fromAcc(fromaccount);		
		
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
		//Thread.sleep(4000);
		dropdownSelection(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"),toaccount);
	}
	else if(acctype.equalsIgnoreCase("Account")){
		
		fromAcc(fromaccount);		
			
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
//		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);
		
		clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
		
		dropdownSelectionindex(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount,2);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}

public TransferPage enterMaxAmount(String amt) throws InterruptedException{
	scrolltoelementJs(prop.getProperty("enter.transaction.amount.xpath"));
enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
return this;

}

public TransferPage verifyAmountMaxmsg(){
	boolean a=VerifyElementpresentreturn(".//div[contains(@class,'ws-errorbox')][@style='display: block;']//p[contains(text(),'Maximum')]");
	booleanVerifyResult(a,"Maximum Amount Error message has dispalying", "Maximum Amount Error message has not dispalying");
	
return this;

}

public TransferPage verifyAmountMinmsg(){
	
	
	boolean a=VerifyElementpresentreturn(".//div[contains(@class,'ws-errorbox')][@style='display: block;']//p[contains(text(),'Minimum')]");
	booleanVerifyResult(a,"Minimum Amount Error message has dispalying", "Minimum Amount Error message has not dispalying");
	
	return this;

}
public TransferPage transferOwnAccForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	
	
	

		if(acctype.equalsIgnoreCase("CreditCard")){
			clickByXpathExplict(prop.getProperty("click.ownacc.creditcard.button.xpath"));
		
fromAcc(fromaccount);		
		
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
		//Thread.sleep(4000);
		dropdownSelection(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"),toaccount);
	}
	else if(acctype.equalsIgnoreCase("Account")){
		
		fromAcc(fromaccount);		
			
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
//		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);
		
		clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
		
		dropdownSelectionindex(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount,2);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}


public void fromAcc(String fromaccount) throws InterruptedException{
	
	dropdownSelection(prop.getProperty("click.fundTransfer.fromdropdown.xpath"),fromaccount);	
	Thread.sleep(2000);


	Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
	if(a){
		
		AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));
		System.out.println(AccountBalance);

		reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
	}
	else{
	booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

	}

	
	
	
}







public TransferPage transferWithinBaracForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	
	
	
	dropdownSelection(prop.getProperty("click.fundTransfer.fromdropdown.xpath"),fromaccount);	
Thread.sleep(2000);



Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));
	System.out.println(AccountBalance);

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

}
	if(acctype.equalsIgnoreCase("CreditCard")){
		
		
		
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
//		Thread.sleep(2000);
		dropdownSelection(prop.getProperty("click.benefiary.choosen.acc.xpath"),toaccount);
	}
	else if(acctype.equalsIgnoreCase("Account")){
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);	
//		Thread.sleep(2000);		
	dropdownSelection(prop.getProperty("click.beneficiary.accnumber.choosen.xpath"),toaccount);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}


public TransferPage transferOtherBaracOnTimePayForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.onetime.pay.menu.xpath"));
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	clickByXpathExplict(prop.getProperty("click.npsb.xpath"));	

	dropdownSelection(prop.getProperty("click.onetime.account.id.choosen.xpath"),fromaccount);	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	if(acctype.equalsIgnoreCase("CreditCard")){
		
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		
		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		
		clickByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"));
		pageScroll();
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);
	}
	else if(acctype.equalsIgnoreCase("Account")){
	
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		
		enterByXpathExplict(prop.getProperty("enter.otherbank.beneficiary.name.xpath"),"testgj");
		
		
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);
		
		
		
		pageScroll();
//		enter.input.acc.number.xpath
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}




public TransferPage transferOtherBankOnTimePayForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.onetime.pay.menu.xpath"));
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
//	clickByXpathExplict(prop.getProperty("click.npsb.xpath"));	

	dropdownSelection(prop.getProperty("click.onetime.account.id.choosen.xpath"),fromaccount);	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	if(acctype.equalsIgnoreCase("CreditCard")){
		
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		
		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		Thread.sleep(2000);
	clickByXpath(prop.getProperty("clicktrans.amount.onepay.xpath"));	
//		scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
		enterByXpathExplict(prop.getProperty("enter.otherbank.beneficiary.name.xpath"),"testgj");
		
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);

		
		
/*		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		enterByXpathExplict(prop.getProperty("enter.onepay.benename.xpath"),"test");
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		
		
		
		
	//	clickByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"));
		pageScroll();
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);*/
	}
	else if(acctype.equalsIgnoreCase("Account")){

		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		Thread.sleep(4000);
		
		clickByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"));	
		
//	clickByXpath(prop.getProperty("clicktrans.amount.onepay.xpath"));	
//		scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
		enterByXpathExplict(prop.getProperty("enter.otherbank.beneficiary.name.xpath"),"testgj");
		
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);
		
		
		
		
		pageScroll();
//		enter.input.acc.number.xpath
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}


public TransferPage transferOtherOneTimePayForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.onetime.pay.menu.xpath"));
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
//	clickByXpathExplict(prop.getProperty("click.npsb.xpath"));	

	dropdownSelection(prop.getProperty("click.onetime.account.id.choosen.xpath"),fromaccount);	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	if(acctype.equalsIgnoreCase("CreditCard")){
		scrolltoelementJs(prop.getProperty("click.creditcard.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		
		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		Thread.sleep(2000);
	clickByXpath(prop.getProperty("clicktrans.amount.onepay.xpath"));	
//	pageScroll400();
//		scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
		enterByXpathExplict(prop.getProperty("enter.otherbank.beneficiary.name.xpath"),"testgj");
		scrolltoelementJs(prop.getProperty("clicktrans.amount.onepay.xpath"));
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
scrolltoelementJs(prop.getProperty("click.BankName.dropdown.xpath"));		
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM BANK");
	

		
		
/*		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		enterByXpathExplict(prop.getProperty("enter.onepay.benename.xpath"),"test");
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		
		
		
		
	//	clickByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"));
		pageScroll();
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);*/
	}
	else if(acctype.equalsIgnoreCase("Account")){
scrolltoelementJs(prop.getProperty("enter.input.acc.number.xpath"));
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		Thread.sleep(2000);
	clickByXpath(prop.getProperty("clicktrans.amount.onepay.xpath"));	
//		scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
scrolltoelementJs(prop.getProperty("enter.otherbank.beneficiary.name.xpath"));
		enterByXpathExplict(prop.getProperty("enter.otherbank.beneficiary.name.xpath"),"testgj");
		
		
		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM BANK");
		enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);
		

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);

		
		
		pageScroll();
//		enter.input.acc.number.xpath
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}


public TransferPage baractransferOneTimePayForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.onetime.pay.menu.xpath"));
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	dropdownSelection(prop.getProperty("click.onetime.account.id.choosen.xpath"),fromaccount);	
	

Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

}

	
	
	//AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	if(acctype.equalsIgnoreCase("CreditCard")){
		Boolean b=VerifyElementpresentreturn(prop.getProperty("click.creditcard.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		
//		clickByXpathExplict(".//i[text()='Credit Card']");
		
		
Thread.sleep(2000);		
	enterByXpathExplict(prop.getProperty("onetimepay.credit.acc.number.xpath"),toaccount);
		
//		dropdownSelection(prop.getProperty("click.obcc.to.number.xpath"),toaccount);
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);

//clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
	
	}
	else if(acctype.equalsIgnoreCase("Account")){
		Thread.sleep(2000);		
		enterByXpathExplict(prop.getProperty("enter.toacc.onetimepay.xpath"),toaccount);
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);

//clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}









public TransferPage transferWithinBaracOnTimePayForm(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.onetime.pay.menu.xpath"));
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);	
	dropdownSelection(prop.getProperty("click.onetime.account.id.choosen.xpath"),fromaccount);	
	
//	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	

Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){
	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));

	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");

}

	
	
	if(acctype.equalsIgnoreCase("CreditCard")){
		
		clickByXpathExplict(prop.getProperty("click.creditcard.button.xpath"));
		
//		clickByXpathExplict(".//i[text()='Credit Card']");
		
		
	//	dropdownSelection(prop.getProperty("click.obcc.to.number.xpath"),toAcc);

		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		Thread.sleep(2000);
		
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
		
		
		
//		enterByXpathExplict(prop.getProperty(".//input[@id='transactionAmount']"),toaccount);
//		
//		dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
//		
//		
//	//	clickByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"));
//		pageScroll();
	}
	else if(acctype.equalsIgnoreCase("Account")){
		
		
		
		
		
		enterByXpathExplict(prop.getProperty("enter.toacc.onetimepay.xpath"),toaccount);
		
		//enterByXpathExplict("(.//input[@id='beneficiaryName'])[2]","cardname");
		
		
	//	dropdownSelection(prop.getProperty("click.BankName.dropdown.xpath"),"EXIM Bank");
		

		Thread.sleep(1000);
		
		//enterByXpathExplict(prop.getProperty("clicktrans.amount.onepay.xpath"),amt);
		pageScroll();
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);
		
		
		
//		enter.input.acc.number.xpath
	//	enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
	
	
	
	
	
	
	
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;

}
	




public TransferPage transferownAccSubmitForm(String remarks) throws InterruptedException{
scrolltoelementJs(prop.getProperty("enter.remarks.own.xpath"));
	Thread.sleep(1000);
	//dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	enterByXpathExplict(prop.getProperty("enter.remarks.own.xpath"),remarks);
	
//	clickByXpathExplict(prop.getProperty("click.sms.tab.xpath"));
	
	

	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
	
	Thread.sleep(2000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}



public TransferPage transferownAccSubmForm(String remarks) throws InterruptedException{
scrolltoelementJs(prop.getProperty("enter.remarks.own.xpath"));
	Thread.sleep(1000);
	//dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	enterByXpathExplict(prop.getProperty("enter.remarks.own.xpath"),remarks);
	
	//clickByXpathExplict(prop.getProperty("click.sms.tab.xpath"));
	clickByXpathExplict(".//label[contains(@class,'check')]");
	clickByXpathExplict(".//button[@id='agree']");
	
	
	scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));

	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	scrolltoelementJs(prop.getProperty("own.acc.text.confirm.xpath"));	
	clickByXpathExplict(prop.getProperty("own.acc.text.confirm.xpath"));
	
	Thread.sleep(2000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}





public TransferPage scrollup() throws InterruptedException{

	pageScrollup();
	
return this;	
}

public TransferPage transferownCardSubmForm(String remarks) throws InterruptedException{
scrolltoelementJs(prop.getProperty("enter.remarks.own.xpath"));
	Thread.sleep(1000);
	//dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	enterByXpathExplict(prop.getProperty("enter.remarks.own.xpath"),remarks);
	
//	clickByXpathExplict(prop.getProperty("click.sms.tab.xpath"));
	//clickByXpathExplict(".//label[contains(@class,'check')]");
	
	
	clickByXpathExplict(".//label[contains(@class,'check')]");
	clickByXpathExplict(".//button[@id='agree']");
	
	
	
scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	scrolltoelementJs(prop.getProperty("own.acc.text.confirm.xpath"));
	
	clickByXpathExplict(prop.getProperty("own.acc.text.confirm.xpath"));
	
	Thread.sleep(2000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}

//start
public TransferPage transferwalletpay(String remarks) throws InterruptedException{
//scrolltoelementJs(prop.getProperty("click.payment.transfer.type.choosen.xpath"));
	//Thread.sleep(25000);
//	dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	//Thread.sleep(2000);
//enable below 

	scrolltoelementJs(prop.getProperty("walletpay.enter.remarks.xpath"));
	
	enterByXpathExplict(prop.getProperty("walletpay.enter.remarks.xpath"), remarks);
	scrolltoelementJs(prop.getProperty("click.sms.within.tab.xpath"));
	clickByXpathExplict(prop.getProperty("click.sms.within.tab.xpath"));
	//scrolltoelementJs(prop.getProperty("click.agreecheckbox.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.agreecheckbox.xpath"));
	clickByXpathExplict(prop.getProperty("click.agreebtn.xpath"));
	scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	scrolltoelementJs(prop.getProperty("click.submit.button.fundtrans.xpath"));
	clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
	
	Thread.sleep(1000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}






public TransferPage transferWithinForm(String remarks) throws InterruptedException{
scrolltoelementJs(prop.getProperty("click.payment.transfer.type.choosen.xpath"));
	//Thread.sleep(25000);
	dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	//Thread.sleep(2000);
//enable below 
//	clickByXpathExplict(prop.getProperty("click.sms.within.tab.xpath"));

	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
	
	Thread.sleep(1000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}
public TransferPage transferWithForm(String remarks) throws InterruptedException{
	Thread.sleep(1000);
scrolltoelementJs(prop.getProperty("click.payment.transfer.type.choosen.xpath"));
	Thread.sleep(2000);
	dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);


//	Thread.sleep(2000);
//enable below 
//	clickByXpathExplict(prop.getProperty("click.sms.within.tab.xpath"));

	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
	
	Thread.sleep(1000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}
public TransferPage transferWithinSubmitForm(String remarks) throws InterruptedException{
	
	scrolltoelementJs(prop.getProperty("enter.remarks.own.xpath"));
	Thread.sleep(1000);
	enterByXpathExplict(prop.getProperty("enter.remarks.own.xpath"),remarks);
	
	Thread.sleep(2000);
//enable below 
	clickByXpathExplict(prop.getProperty("click.sms.within.tab.xpath"));

	clickByXpathExplict(".//label[contains(@class,'check')]");
	clickByXpathExplict(".//button[@id='agree']");
	
	

		
	scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));
	scrolltoelementJs(prop.getProperty("own.acc.text.confirm.xpath"));
//loadtime();
	//pageScroll();
	clickByXpathExplict(prop.getProperty("own.acc.text.confirm.xpath"));


	
	Thread.sleep(2000);
	
	

		return this;
	}



public TransferPage transferothercardSubmitForm(String remarks) throws InterruptedException{
	
	scrolltoelementJs(prop.getProperty("enter.remarks.own.xpath"));
	Thread.sleep(1000);
	enterByXpathExplict(prop.getProperty("enter.remarks.own.xpath"),remarks);
	
//scrolltoelementJs(prop.getProperty("click.payment.transfer.type.choosen.xpath"));
	//Thread.sleep(1000);
	//dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
	Thread.sleep(2000);
//enable below 
	scrolltoelementJs(prop.getProperty("click.sms.within.tab.xpath"));

	clickByXpathExplict(prop.getProperty("click.sms.within.tab.xpath"));

	clickByXpathExplict(prop.getProperty("click.agreecheckbox.xpath"));
	loadtime();
	scrolltoelementJs(prop.getProperty("click.agreebtn.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.agreebtn.xpath"));
	scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

	scrolltoelementJs(prop.getProperty("own.acc.text.confirm.xpath"));
	
	clickByXpathExplict(prop.getProperty("own.acc.text.confirm.xpath"));

//	clickByXpathExplict(prop.getProperty("withincard.confirm.button.xpath"));
	
	Thread.sleep(2000);
//	clickByXpathExplict(prop.getProperty("click.transfer.confirmbutton.xpath"));
	
	

		return this;
	}




public TransferPage VerifyTransfer() throws InterruptedException{
Thread.sleep(5000);
VerifyElementPresent(prop.getProperty("verify.success.Beneficiarty.message.xpath"),"Fund has been Transferred sucessfully","Fund has not been Transferred successfully");

return this;
}

public TransferPage clickOtherMenu() throws InterruptedException{
defaultcontent();
//Thread.sleep(10000);

Boolean a=VerifyElementpresentreturn(prop.getProperty("click.others.menu.xpath"));
	clickByXpathExplict(prop.getProperty("click.others.menu.xpath"));
	Thread.sleep(2000);	
	
	
return this;
}






public TransactionHistory clickTransactionHistory() throws InterruptedException{
//Thread.sleep(20000);
//	loadtime();
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.transactionHistory.menulink.xpath"));
//	clickByXpathExplict(prop.getProperty("click.transactionHistory.menulink.xpath"));
	//loadtime();
//	Thread.sleep(10000);
	
	
return new TransactionHistory(driver, test);
}

public TransferPage clickeditMobileWallet() throws InterruptedException{
	//Thread.sleep(10000);
	loadtime();
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.walletpay.expand.xpath"));
	
					clickByXpathExplict(prop.getProperty("click.walletpay.expand.xpath"));
					loadtime();
					loadtime();
					scrolltoelementJs(prop.getProperty("click.wallet.editbutton.xpath"));
					
					clickByXpathExplict(prop.getProperty("click.wallet.editbutton.xpath"));
	
//	clickByXpathExplict(prop.getProperty("mobile.wallet.editbutton.xpath"));
	
//	Thread.sleep(6000);	
		return this;
	}
public TransferPage clickBkash() throws InterruptedException{
	loadtime();
	boolean a=VerifyElementpresentreturn(prop.getProperty("click.bkash.link.xpath"));
	scrolltoelementJs(prop.getProperty("click.bkash.link.xpath"));
	clickByXpathExplict(prop.getProperty("click.bkash.link.xpath"));
	defaultcontent();
	return this;
	}	

public TransferPage clickCashBaba() throws InterruptedException{
loadtime();
boolean a=VerifyElementpresentreturn(prop.getProperty("click.cashbaba.xpath"));
scrolltoelementJs(prop.getProperty("click.cashbaba.xpath"));
clickByXpathExplict(prop.getProperty("click.cashbaba.xpath"));
defaultcontent();
return this;
}	
public TransferPage fillMobileAddBeneficiary(String accnumber,String payeename,String nickname,String mobilenum,String remarks,Boolean payeenterStatus) throws InterruptedException{
	Thread.sleep(2000);
	String accountno=regvalue(accnumber);
	String phnum=regvalue(mobilenum);
	
	
					enterByXpathExplict(prop.getProperty("enter.mob.acc.number.xpath"),accountno);
		scrolltoelementJs(prop.getProperty("enter.mob.remarks.xpath"));
					clickByXpathExplict(prop.getProperty("enter.mob.remarks.xpath"));
					
			if(payeenterStatus){
			enterByXpathExplict(prop.getProperty("enter.mob.payeename.xpath"),payeename);
			}
			enterByXpathExplict(prop.getProperty("enter.mob.payeenickname.xpath"),nickname);
			enterByXpathExplict(prop.getProperty("enter.mob.mob.number.xpath"),phnum);
					scrolltoelementJs(prop.getProperty("enter.mob.remarks.xpath"));
			enterByXpathExplict(prop.getProperty("enter.mob.remarks.xpath"),remarks);
	//Thread.sleep(25000);
	
	
	
	scrolltoelementJs(prop.getProperty("click.mob.sms.xpath"));
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.mob.sms.xpath"));

	if(a){
		clickByXpathExplict(prop.getProperty("click.mob.sms.xpath"));
		
	}

	else{
reportStep("sms notification button has not present", "FAIL");
	}	
			scrolltoelementJs(prop.getProperty("click.within.beneficiary.xpath"));
	clickByXpathExplict(prop.getProperty("click.within.beneficiary.xpath"));

	return this;

}	

public TransferPage clickipay() throws InterruptedException{
loadtime();
boolean a=VerifyElementpresentreturn(prop.getProperty("ipay.button.xpath"));
scrolltoelementJs(prop.getProperty("ipay.button.xpath"));
clickByXpathExplict(prop.getProperty("ipay.button.xpath"));
defaultcontent();
return this;
}	
public TransferPage clickokwallet() throws InterruptedException{
loadtime();
boolean a=VerifyElementpresentreturn(prop.getProperty("okwallet.button.xpath"));
scrolltoelementJs(prop.getProperty("okwallet.button.xpath"));
clickByXpathExplict(prop.getProperty("okwallet.button.xpath"));
defaultcontent();
return this;
}	
public TransferPage clickrocketpay() throws InterruptedException{
loadtime();
boolean a=VerifyElementpresentreturn(prop.getProperty("rocket.button.xpath"));
scrolltoelementJs(prop.getProperty("rocket.button.xpath"));
clickByXpathExplict(prop.getProperty("rocket.button.xpath"));
defaultcontent();
return this;
}	




public TransferPage clickeditButtonBeneficiary() throws InterruptedException{
//	Thread.sleep(10000);
	loadtime();
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.fundtransfer.editbutton.first.xpath"));
	scrolltoelementJs(prop.getProperty("click.fundtransfer.editbutton.first.xpath"));
	clickByXpathExplict(prop.getProperty("click.fundtransfer.editbutton.first.xpath"));
	loadtime();
		
		return this;
	}

public TransferPage editbeneficiary(String nickName,String UpdateNickname) throws InterruptedException{
	locateFrame("icanvas");
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),nickName);

	Boolean a=driver.getPageSource().contains(nickName);
if(a){
	



	clickByXpathExplict(".//span[text()='"+nickName+"']/following::i[1]");
	clickByXpathExplict("(.//span[text()='"+nickName+"']/following::li/a[@class='canvasLeftMenuLink'])");

enterByXpathExplict(prop.getProperty("enter.update.nickname.within.xpath"),UpdateNickname);
	
//clickByXpathExplict(prop.getProperty("click.withinbank.sms.xpath"));
//clickByXpathExplict(prop.getProperty("click.within.beneficiary.xpath"));


//clickByXpathExplict(prop.getProperty("click.beneedit.button.xpath"));


}

return this;
}



public TransferPage deletebeneficiary(String beneficiaryName) throws InterruptedException{
	locateFrame("icanvas");
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);
	try {
		readytimes();
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	Thread.sleep(2000);

	Boolean a=driver.getPageSource().contains(beneficiaryName);
			

if(a){
	


	clickByXpathExplict(".//span[text()='"+beneficiaryName+"']/following::i[1]");
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
	clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));
/*	
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);
Boolean b=VerifyElementpresentreturn(".//span[text()='"+beneficiaryName+"']");
if(b){
booleanResultFail(b, "Beneficiary has not deleted");
}
else{
	booleanNoElementPresentResult(a,"Beneficiary has deleted");
}
*/

}
else{
	booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
	
}

defaultcontent();
return this;
}

public TransferPage deleteUpdbeneficiary(String beneficiaryName,String updateBene) throws InterruptedException{
	locateFrame("icanvas");
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);
	try {
		readytimes();
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	Thread.sleep(2000);

	Boolean a=driver.getPageSource().contains(beneficiaryName);
	
if(a){
	clickByXpathExplict(".//span[text()='"+beneficiaryName+"']/following::i[1]");
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
	clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));
}
else{
	
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),updateBene);
	try {
		readytimes();
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	Thread.sleep(2000);

	Boolean b=driver.getPageSource().contains(updateBene);
	if(b){
		clickByXpathExplict(".//span[text()='"+updateBene+"']/following::i[1]");
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
		clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));
	}
	
	else{
		booleanNoElementPresentResult(b,"Beneficiary has not Present for deletion");
	}
	
	
	
	
}










defaultcontent();
return this;

}



public TransferPage deleteUpdatebeneficiary(String beneficiaryName,String UpdateNickname) throws InterruptedException{
	locateFrame("icanvas");
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),beneficiaryName);
	try {
		readytimes();
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	Thread.sleep(2000);

	Boolean a=driver.getPageSource().contains(beneficiaryName);
			

if(a){
	


	clickByXpathExplict(".//span[text()='"+beneficiaryName+"']/following::i[1]");
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
	clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));

}
else{
	booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
	
}

defaultcontent();
return this;
}










public TransferPage deletebene(String nickName,String updatenickname) throws InterruptedException{
	locateFrame("icanvas");
	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),nickName);

	Boolean a=driver.getPageSource().contains(nickName);
	
	
	
	if(a){
	


	clickByXpathExplict(".//span[text()='"+nickName+"']/following::i[1]");
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
	clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));


}


	enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),updatenickname);

	Boolean b=driver.getPageSource().contains(updatenickname);

	
	if(a){
	


	clickByXpathExplict(".//span[text()='"+nickName+"']/following::i[1]");
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.delete.beneform.xpath"));
	clickByXpathExplict(prop.getProperty("click.deletepopup.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.close.button.xpath"));


}



else{
	booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
	
}

defaultcontent();
return this;
}

public TransferPage clickOtherBankTab() throws InterruptedException{
	locateFrame("icanvas");
Boolean a=VerifyElementpresentreturn(prop.getProperty("click.otherBank.tab.xpath"));
	clickByXpathExplict(prop.getProperty("click.otherBank.tab.xpath"));
	
		defaultcontent();
		return this;
	}

public TransferPage enterHoldername(String Holdername) throws InterruptedException{
enterByXpathExplict(prop.getProperty("acc.wallet.holdername.xpath"), Holdername);


return this;
}


public TransferPage mobileWalletToBeneficiary(String fromAcc,String amount,String toAcc,String acctype) throws InterruptedException{
	
	//loadtime();
	Thread.sleep(3000);
	locateFrame("icanvas");
	String fromaccount=regvalue(fromAcc);
	String toaccount=regvalue(toAcc);
	String amt=regvalue(amount);		
	System.out.println("element will click");
	if(acctype.equalsIgnoreCase("one time pay")){		
		clickByXpathExplict(prop.getProperty("one.timepay.tab.mbwallet.xpath"));
	}
	
//	System.out.println("kkkkkkjjjjjjjjjj");
//	System.out.println(driver.findElement(By.xpath(".//div[@id='accountid_chosen']")).isEnabled());
	dropdownSelection(prop.getProperty("click.fundTransfer.fromdropdown.xpath"),fromaccount);
	Thread.sleep(3000);
Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));
	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");
}
if(acctype.equalsIgnoreCase("one time pay")){		
//		clickByXpathExplict(prop.getProperty("one.timepay.tab.mobilewallet.xpath"));
		enterByXpathExplict(prop.getProperty("enter.input.acc.number.xpath"),toaccount);
	//	enterByXpathExplict(prop.getProperty("onetimepay.toacc.num.xpath"),"test");
		scrolltoelementJs(prop.getProperty("enter.transaction.amount.xpath"));
		Thread.sleep(1000);
		
		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);

	}
	else if(acctype.equalsIgnoreCase("Existing Beneficiary")){
		scrolltoelementJs(prop.getProperty("enter.transaction.amount.xpath"));

		enterByXpathExplict(prop.getProperty("enter.transaction.amount.xpath"),amt);

clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);

		dropdownSelection(prop.getProperty("click.beneificiary.acc.firstindex.xpath"),toaccount);		
	}
	else{
		System.out.println("Transfer type not matched");
	}
	return this;
}



}
