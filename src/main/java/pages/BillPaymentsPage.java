package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BillPaymentsPage  extends ProjectWrapp{
	public  BillPaymentsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public BillPaymentsPage clickaddBillersLink() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.addbill.link.xpath"));		
			return this;

	}
	
	

	public BillPaymentsPage locateFrames() throws InterruptedException{
		locateFrame("icanvas");
			return this;

	}
	
	public BillPaymentsPage SwitchdefaultContent(){
defaultcontent();
		return this;

	}
		
	
	public BillPaymentsPage verifyaddBillersLink(String billnumber){
		
    	String billno=regvalue(billnumber);	

	//	clickByXpathExplict(prop.getProperty("click.addmbile.pencil.xpath"));
enterByXpathExplict(prop.getProperty("enter.search.biller.xpath"), billno);
		
verifyTextByXpathExplicitwait(".//span[text()='"+billno+"']",billno);		

			return this;
	}









	
	public BillPaymentsPage otpsubmit() throws InterruptedException{
		DBOTP_function();
		enterByXpathExplict(prop.getProperty("enter.otp.password.xpath"),DbOTP);
			
		
//		enterByXpathExplict(prop.getProperty("enter.otp.password.xpath"),"123456");
		
		clickByXpathExplict(prop.getProperty("click.submit.otp.button.xpath"));
		
			return this;
		}
	
	public BillPaymentsPage billerForm(String fieldname,String value) throws InterruptedException{

		
		switch(fieldname){  
	    //Case statements  
	    case  "Billername":
	    	dropdownSelection(prop.getProperty("enter.billername.xpath"),value);
	    break;  
	    case "BillerType": 
	    	Thread.sleep(2000);
    	dropdownSelection(prop.getProperty("enter.billertype.xpath"),value);
	    
	    break;  
	    case "InstitutionName": 
		    dropdownSelectionindex(prop.getProperty("enter.billertype.xpath"),value,2);
		    break; 
	    case "InsuranceCompanyFirstField": 
    	dropdownSelection(prop.getProperty("enter.billername.xpath"),value);
	    
	    break;  
	   
	    
	    case "InsuranceComp": 
    	dropdownSelection(prop.getProperty("enter.billername.xpath"),value);
     	break;  
	    case "InsuranceComptwo": 
	     	dropdownSelection(prop.getProperty("enter.billertype.xpath"),value);    
		    break;  

	    
	    	    case "ClickSms": 
Thread.sleep(2000);
scrolltoelementJs(prop.getProperty("sms.billpayments.xpath"));
		clickByXpathExplict(prop.getProperty("sms.billpayments.xpath"));
	    break;  

	    
	    case "InsuranceCompanySecondField": 
	    	dropdownSelection(prop.getProperty("enter.billertype.xpath"),value);
		    
		    break;  
	   
	    
	    
	    case "BillerCategory": 
    	dropdownSelection(prop.getProperty("utility.category.biller.xpath"),value);
	    
	    break;  

	    case "insuranceCategory": 
	    	dropdownSelection(prop.getProperty("insurance.cat.choosen.xpath"),value);
		    
		    break;  
	    
	    
	    case "BillerService": 
    	dropdownSelection(prop.getProperty("biller.service.utility.xpath"),value);
	    
	    break;  
	    
	    case "BillerService Utilty": 
	    	dropdownSelectionindex(prop.getProperty("biller.service.utility.xpath"),value,2);
		    
		    break; 
	    
	    case "Insurance short name": 
enterByXpathExplict(prop.getProperty("enter.insurance.short.namemobile.xpath"),value);
	    	break; 
	    	

	    case "Insurance short name bene": 
enterByXpathExplict(prop.getProperty("enter.insurance.sec.xpath"),value);
	    	break; 
	    	
	    	
	    	
	    case "Studentname": 
	    	enterByXpathExplict(prop.getProperty("biller.student.name.xpath"),value);
	    
	    break;  
	    
	    case "Studentid": 
	    	enterByXpathExplict(prop.getProperty("biller.student.id.xpath"),value);
	    	break; 
	   
	    case "Insurance customer name": 
enterByXpathExplict(prop.getProperty("enter.insurance.name.xpath"),value);
	    	break; 

	    case "Biller Number": 
    	
	    	String amt=regvalue(value);	

	    	dropdownSelection(prop.getProperty("enter.billnumber.xpath"),amt);	    
	    break; 
	    case "Mob Biller Number": 
	    	String mobbillnum=regvalue(value);	

	    enterByXpathExplict(prop.getProperty("airtel.tele.bill.number.xpath"),mobbillnum); 
	    break; 
	    	    
	    case "short name": 
         enterByXpathExplict(prop.getProperty("enter.short.namemobile.xpath"),value);
	    	break; 

	    case "customer name": 
         enterByXpathExplict(prop.getProperty("enter.customer.name.internet.xpath"),value);
	    	break; 
	    	    

	    case "submitButton": 
	    	scrolltoelementJs(prop.getProperty("click.addbill.submit.button.xpath"));
        clickByXpathExplict(prop.getProperty("click.addbill.submit.button.xpath"));
	    	break; 
	    case "confirm": 
	    	scrolltoelementJs(prop.getProperty("click.addbill.confirm.button.xpath"));
	    	clickByXpathExplict(prop.getProperty("click.addbill.confirm.button.xpath"));
    	
	    	break; 
	   
	    case "confirmbillpay": 
	    	scrolltoelementJs(prop.getProperty("click.confirm.form.billpay.xpath"));
	    	clickByXpathExplict(prop.getProperty("click.confirm.form.billpay.xpath"));
    	
	    	break; 
	   	
	    	
	    	
	    	
       case "ValidateButton":   
	    scrolltoelementJs(prop.getProperty("click.bill.validat.button.xpath"));
	    clickByXpathExplict(prop.getProperty("click.bill.validat.button.xpath"));
	    break; 
	    
       case "verifySucess":
    	   VerifyElementPresent(prop.getProperty("verify.success.Beneficiarty.message.xpath"),"Beneficiary has added sucessfully","Beneficiary has not added successfully");
break;
	    
	    //Default case statement  
	    default:System.out.println("method has not matched");  
	    }  
		
		
		
		
		
		return this;

	}
	
	
	
	
	public BillPaymentsPage clickmobilebillerMenu(String mobilebillermenu) throws InterruptedException{
		//Thread.sleep(5000);
//clickByXpathExplict(".//p[contains(text(),'MetLife')]");	
		loadtime();
	clickByXpathExplict(".//h4[contains(text(),'"+mobilebillermenu+"')]");	
	
		//Thread.sleep(10000);
			return this;
	}
	
	
	
	
	
	public BillPaymentsPage clickmobilebillername(String mobilebillerName) throws InterruptedException{
		//Thread.sleep(30000);
	loadtime();
	
	
	Boolean a=VerifyElementpresentreturn(".//li[@class='active']//following::p[contains(text(),'"+mobilebillerName+"')]");	
	clickByXpathExplict(".//li[@class='active']//following::p[contains(text(),'"+mobilebillerName+"')]");	
	
//		clickByXpathExplict(".//p[contains(text(),'"+mobilebillerName+"')]");	
		loadtime();
		//Thread.sleep(10000);
			return this;

	}
	public BillPaymentsPage clickOnetimePay() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.onetimepay.mobile.xpath"));		
			return this;

	}	
	
	
	
	
	
	public BillPaymentsPage clickBillermenu(String billerMenu) throws InterruptedException{
		clickByXpathExplict(".//h4[@fragmentph-id='"+billerMenu+"']");		
			return this;

	}		
	

	public BillPaymentsPage getUtiityamt() throws InterruptedException{
	//	Thread.sleep(3000);
		scrolltoelementJs(prop.getProperty("utility.due.amt.xpath"));
BillDueAmount=getTextByXpath(prop.getProperty("utility.due.amt.xpath"));



		return this;

	}		

	public BillPaymentsPage getinternetamt() throws InterruptedException{
		//Thread.sleep(3000);
	//	BillDueAmount=getTextByXpath(prop.getProperty("internet.due.amt.xpath"));
scrolltoelementJs(prop.getProperty("get.internet.amt.new.xpath"));
		BillDueAmount=getTextByXpath(prop.getProperty("get.internet.amt.new.xpath"));
		
		
	//	reportStep("internet amount is "+BillDueAmount+"", "INFO");
		//System.out.println("internet amount is "+BillDueAmount+"");
				return this;

	}		
	public BillPaymentsPage getinsuranceamt() throws InterruptedException{
		//Thread.sleep(3000);
		scrolltoelementJs(prop.getProperty("insurance.due.amt.xpath"));
		BillDueAmount=getTextByXpath(prop.getProperty("insurance.due.amt.xpath"));
		//reportStep("insurance amount is "+BillDueAmount+"", "INFO");
		//System.out.println("insurance amount is "+BillDueAmount+"");
		
		return this;

	}		
	public BillPaymentsPage getbracunivamt() throws InterruptedException{
	//	Thread.sleep(3000);
		scrolltoelementJs(prop.getProperty("internet.due.amt.xpath"));
		BillDueAmount=getTextByXpath(prop.getProperty("internet.due.amt.xpath"));
		return this;

	}		
	
	
	
	
	
	public BillPaymentsPage balanceAmount() throws InterruptedException{

	Thread.sleep(2000);
Boolean a=VerifyElementpresentreturn(prop.getProperty("check.available.balance.xpath"));
if(a){	
	AccountBalance=getTextByXpath(prop.getProperty("check.available.balance.xpath"));
	reportStep("Balanec has displaying "+AccountBalance+"", "PASS");
}
else{
booleanResultFail(a, "Balanec has not displaying "+AccountBalance+"");
}

	
	return this;
	}	
	
	public BillPaymentsPage MobileBillerPayForm(String fieldname,String value) throws InterruptedException{

		
		/*
		 
regular.pay.fromacc.xpath=.//div[@id='accountid_chosen']
 1507202123474001 | BDT		
regular.pay.toacc.xpath=.//div[@id='toAccountNumber_chosen']
airtelprepaid | 01720518293
regularpay.trans.amount.xpath=.//input[@id='transactionAmount']	
	
		 */
		
		
		switch(fieldname){  
	    //Case statements  
	    case  "fromAcc":
	    	String fromaccount=regvalue(value);

	    	dropdownSelection(prop.getProperty("regular.pay.fromacc.xpath"),fromaccount);
	    break;  
	    case "toAcc": 
scrolltoelementJs(prop.getProperty("regular.pay.toacc.xpath"));
Thread.sleep(2000);
	    	String toaccount=regvalue(value);

	    	dropdownSelection(prop.getProperty("regular.pay.toacc.xpath"),toaccount);
	    
	    break;  
	    case "ClickSms": 
scrolltoelementJs(prop.getProperty("sms.billpayments.xpath"));
		clickByXpathExplict(prop.getProperty("sms.billpayments.xpath"));
	    break;  

	    case "ClickGetAmount": 
scrolltoelementJs(prop.getProperty("click.getamt.utility.xpath"));
		clickByXpathExplict(prop.getProperty("click.getamt.utility.xpath"));
	    break;  

	    case "TransAmount": 
	    	String amt=regvalue(value);
	    	scrolltoelementJs(prop.getProperty("regularpay.trans.amount.xpath"));
	    	enterByXpathExplict(prop.getProperty("regularpay.trans.amount.xpath"),amt);
	    	clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
			Thread.sleep(2000);
	    break;  
	    case "MobileTransAmount": 
	    	String amot=regvalue(value);
	    	scrolltoelementJs(prop.getProperty("mobilepay.enter.amount.xpath"));
	    	enterByXpathExplict(prop.getProperty("mobilepay.enter.amount.xpath"),amot);
	    
	    break;  
	    case "MobilepayAmount": 
	    	String amout=regvalue(value);
	    	scrolltoelementJs(prop.getProperty("mobilepayone.enter.amount.xpath"));
	    	enterByXpathExplict(prop.getProperty("mobilepayone.enter.amount.xpath"),amout);
//loadtime();
//clickByXpathExplict(prop.getProperty("click.amount.lablel.xpath"));
		Thread.sleep(2000);

	    
	    break;  
	    
	    
	    
	    
	    
	    
	    case "billPayRemarks": 
	 //   	String amot=regvalue(value);
	    	scrolltoelementJs(prop.getProperty("enter.remarks.bill.xpath"));
	    	enterByXpathExplict(prop.getProperty("enter.remarks.bill.xpath"),value);
	    
	    break;  
	    
	    
	    
	    
	    case "click PrepaidTab":
	    	scrolltoelementJs(prop.getProperty("click.prepaid.mobile.payments.xpath"));
	    	clickByXpathExplict(prop.getProperty("click.prepaid.mobile.payments.xpath"));
	    	
	    break;  
	    
	    
	    
	    
	    case "onetimepay ToAccount": 
	    	String OnePaytoaccount=regvalue(value);
	    	enterByXpathExplict(prop.getProperty("enter.mobilepayment.toacc.xpath"),OnePaytoaccount);
	    
	    break;  
	    

	    case "GetAmount": 
	    	scrolltoelementJs(prop.getProperty("click.addbill.submit.button.xpath"));
        clickByXpathExplict(prop.getProperty("click.addbill.submit.button.xpath"));
	    	break; 
	    case "Remarks": 
	    	scrolltoelementJs(prop.getProperty("billerpurpose.transfer.xpath"));
	    	Thread.sleep(2000);
	    	dropdownSelection(prop.getProperty("billerpurpose.transfer.xpath"),value);
	    	//Premium for insurance 
    	
	    	break; 
	    	
case "PayslipNumber": 
	String payslipnum=regvalue(value);
	
	
	enterByXpathExplict(prop.getProperty("enter.payslip.tuitionfees.xpath"),payslipnum);
	    	
	    	
	    	break; 
	    		


	    	
	    	
       case "ValidateButton":   
	    
	    clickByXpathExplict(prop.getProperty("click.bill.validat.button.xpath"));
	    break; 
       case "ValidateMinimumAmount":   
verifyAmountMinmsg();   	    
   	    break; 
       case "ValidateMaximumAmount":   
verifyAmountMaxmsg();
   	    break; 
   	    
	    
	    //Default case statement  
	    default:System.out.println("method has not matched");  
	    }  
		
		
		
		
				return this;
	}
	
	
	public void verifyAmountMaxmsg(){
		boolean a=VerifyElementpresentreturn(".//div[contains(@class,'ws-errorbox')][@style='display: block;']//p[contains(text(),'Maximum')]");
		booleanVerifyResult(a,"Maximum Amount Error message has dispalying", "Maximum Amount Error message has not dispalying");
		


	}

	public void verifyAmountMinmsg(){
		
		
		boolean a=VerifyElementpresentreturn(".//div[contains(@class,'ws-errorbox')][@style='display: block;']//p[contains(text(),'Minimum')]");
		booleanVerifyResult(a,"Minimum Amount Error message has dispalying", "Minimum Amount Error message has not dispalying");
		

	}

	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	public TransferPage submitOnetimePayments() throws InterruptedException{

		
		
	//	dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
			//Thread.sleep(10000);
		//enable below 
			clickByXpathExplict(prop.getProperty("onetimepay.mobilepay.sms.xpath"));
			clickByXpathExplict(prop.getProperty("click.agreecheckbox.xpath"));
			clickByXpathExplict(prop.getProperty("click.agreebtn.xpath"));

scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
			clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

			
			scrolltoelementJs(prop.getProperty("click.submit.button.fundtrans.xpath"));
			
			clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
			
//			Thread.sleep(4000);
			
			

				return new TransferPage(driver, test);
			}
	
	
	
	public TransferPage submitPayments() throws InterruptedException{

		
		
	//	dropdownSelection(prop.getProperty("click.payment.transfer.type.choosen.xpath"),remarks);
			//Thread.sleep(10000);
		//enable below 
		scrolltoelementJs(prop.getProperty("click.withinbank.sms.xpath"));
			clickByXpathExplict(prop.getProperty("click.withinbank.sms.xpath"));
			clickByXpathExplict(prop.getProperty("click.agreecheckbox.xpath"));
			clickByXpathExplict(prop.getProperty("click.agreebtn.xpath"));
scrolltoelementJs(prop.getProperty("click.paynow.button.xpath"));
			clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

			
			scrolltoelementJs(prop.getProperty("click.submit.button.fundtrans.xpath"));
			clickByXpathExplict(prop.getProperty("click.submit.button.fundtrans.xpath"));
			
//			Thread.sleep(4000);
			
			

				return new TransferPage(driver, test);
			}
	
	
	
	
	
	
	
	
	
	
	
	public BillPaymentsPage clickMobileLink() throws InterruptedException{
	//	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.mobileBill.menu.link.xpath"));	
		scrolltoelementJs(prop.getProperty("click.mobileBill.menu.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.mobileBill.menu.link.xpath"));		
	
			return this;

	}
	
	public BillPaymentsPage clickConfirmbutton() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.confirm.beneficiary.button.xpath"));
		
			
			return this;
		}
public BillPaymentsPage clickConfirm() throws InterruptedException{
		scrolltoelementJs(prop.getProperty("click.submitbene.billpay.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.submitbene.billpay.button.xpath"));
		
			
			return this;
		
}
	
	
	
	
	

	public BillPaymentsPage otpsubmits() throws InterruptedException{
		enterByXpathExplict(prop.getProperty("enter.otp.password.xpath"),"123456");
		
		clickByXpathExplict(prop.getProperty("click.submit.otp.button.xpath"));
		
			return this;
		}

	public BillPaymentsPage editbeneficiaryMobileWallet(String billno,String upadteshortname) throws InterruptedException{
		locateFrame("icanvas");
		
		String billnumber=regvalue(billno);	

		enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),billnumber);
loadtime();
		Boolean a=driver.getPageSource().contains(billnumber);
	if(a){
		

		clickByXpathExplict(".//span[text()='"+billnumber+"']/preceding::i[3]");
		clickByXpathExplict(".//span[text()='"+billnumber+"']//preceding::a[contains(text(),'edit')][1]");



	enterByXpathExplict(prop.getProperty("enter.update.nickname.within.xpath"),upadteshortname);
		scrolltoelementJs(prop.getProperty("click.within.beneficiary.xpath"));
//	clickByXpathExplict(prop.getProperty("click.withinbank.sms.xpath"));
	clickByXpathExplict(prop.getProperty("click.within.beneficiary.xpath"));

	}

	return this;
	}
	
	
	
	
	public BillPaymentsPage deleteBillerbeneficiary(String Accnum,String LinkName) throws InterruptedException{
locateFrame("icanvas");
		
		
		
		String billno=regvalue(Accnum);	

		
		enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),billno);
	

//		Boolean a=VerifyElementpresentreturn(".//span[text()='"+billno+"']");
Thread.sleep(5000);
		Boolean a=driver.getPageSource().contains(billno);

		if(a){
		


		clickByXpathExplict(".//span[text()='"+billno+"']/preceding::i[3]");
		
		
		clickByXpathExplict(".//span[text()='"+billno+"']//preceding::div[contains(@class,'option open')]//a[contains(@onclick,'Delete')]");
		clickByXpathExplict(prop.getProperty("click.deleteconfirm.biller.xpath"));
		
	defaultcontent();

		
		switch(LinkName){  
	    //Case statements  
	   

	    case "MobileLink": 
	    	clickMobileLink();
	    	break; 
	    case "Utility": 
	    	clickUtilityLink();    	
	    	break; 
	    	
       case "InternetBill":   
	    

    		clickinternetLink();
    		break; 
       case "InsurancetBill":   
   	    
    	   clickInsuranceLink();
    	   break; 
   	    case "Tuition Fees":   
   		    
   	    	clickTuitionFeesLink();	
   	    	break;  
	    
	    //Default case statement  
	    default:System.out.println("method has not matched");  

		
		
	}
	}
		else{
		booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
		
	}

	defaultcontent();
	return this;
	}

	public BillPaymentsPage deleteBillerbeneficiaryName(String shortname ,String updateshortname,String LinkName) throws InterruptedException{
		locateFrame("icanvas");
				
				
				
			//	String billno=regvalue(Accnum);	

				
				enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),shortname);
			

//				Boolean a=VerifyElementpresentreturn(".//span[text()='"+billno+"']");
		Thread.sleep(5000);
				Boolean a=driver.getPageSource().contains(shortname);

				if(a){
				


				clickByXpathExplict(".//span[text()='"+shortname+"']/preceding::i[3]");
				clickByXpathExplict(".//span[text()='"+shortname+"']//preceding::a[contains(text(),'Delete')][1]");
				clickByXpathExplict(prop.getProperty("click.deleteconfirm.biller.xpath"));
				
			defaultcontent();

				billLink(LinkName);
			}
				else {

					enterByXpathExplict(prop.getProperty("search.beneficiary.xpath"),updateshortname);
					

//					Boolean a=VerifyElementpresentreturn(".//span[text()='"+billno+"']");
			Thread.sleep(5000);
					Boolean b=driver.getPageSource().contains(updateshortname);

					if(b){
					


					clickByXpathExplict(".//span[text()='"+updateshortname+"']/preceding::i[3]");
					clickByXpathExplict(".//span[text()='"+updateshortname+"']//preceding::a[contains(text(),'Delete')][1]");
					clickByXpathExplict(prop.getProperty("click.deleteconfirm.biller.xpath"));
					
				defaultcontent();

					billLink(LinkName);
				}
					else {
						booleanNoElementPresentResult(a,"Beneficiary has not Present for deletion");
						
					}
					
					
					
				
			}

			defaultcontent();
			return this;
			}

	
	
	public void billLink(String LinkName) throws InterruptedException{
		switch(LinkName){  
	    //Case statements  
	   

	    case "MobileLink": 
	    	clickMobileLink();
	    	break; 
	    case "Utility": 
	    	clickUtilityLink();    	
	    	break; 
	    	
       case "InternetBill":   
	    

    		clickinternetLink();
    		break; 
       case "InsurancetBill":   
   	    
    	   clickInsuranceLink();
    	   break; 
   	    case "Tuition Fees":   
   		    
   	    	clickTuitionFeesLink();	
   	    	break;  
	    
	    //Default case statement  
	    default:System.out.println("method has not matched");  

		
		
	}

	}
	
	
	
	
	public BillPaymentsPage clickeditUtilityLink() throws InterruptedException{
	loadtime();
		clickByXpathExplict(prop.getProperty("click.utilty.menu.link.xpath"));	
	//	Thread.sleep(10000);
		loadtime();
			return new BillPaymentsPage(driver, test);

	}
	public BillPaymentsPage clickUtilLink() throws InterruptedException{
		loadtime();
		scrolltoelementJs(prop.getProperty("click.submenu.utility.xpath"));	
		clickByXpathExplict(prop.getProperty("click.submenu.utility.xpath"));	
		
		loadtime();
		scrolltoelementJs(prop.getProperty("click.utilty.menu.link.xpath"));
		clickByXpathExplict(prop.getProperty("click.utilty.menu.link.xpath"));	
		//	Thread.sleep(10000);
			loadtime();
				return new BillPaymentsPage(driver, test);

		}

	
	public BillPaymentsPage clickUtilityLink() throws InterruptedException{
	loadtime();
//	clickByXpathExplict(prop.getProperty("click.submenu.utility.xpath"));	
	
boolean a=VerifyElementpresentreturn(prop.getProperty("click.utilty.menu.link.xpath"));	
	scrolltoelementJs(prop.getProperty("click.utilty.menu.link.xpath"));	
	
		clickByXpathExplict(prop.getProperty("click.utilty.menu.link.xpath"));	
	//	Thread.sleep(10000);
		loadtime();
			return new BillPaymentsPage(driver, test);

	}
	public BillPaymentsPage clicknetLink() throws InterruptedException{
		loadtime();
	boolean a=	VerifyElementpresentreturn(prop.getProperty("click.submenu.internet.xpath"));
		scrolltoelementJs(prop.getProperty("click.submenu.internet.xpath"));
		clickByXpathExplict(prop.getProperty("click.submenu.internet.xpath"));
		loadtime();
		clickByXpathExplict(prop.getProperty("click.internet.menu.link.xpath"));
			return new BillPaymentsPage(driver, test);

	}	
	
	public BillPaymentsPage clickinternetLink() throws InterruptedException{
		loadtime();
		
		//clickByXpathExplict(prop.getProperty("click.submenu.internet.xpath"));
//		loadtime();
		scrolltoelementJs(prop.getProperty("click.internet.menu.link.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.internet.menu.link.xpath"));
			return new BillPaymentsPage(driver, test);

	}

	
	public BillPaymentsPage clickeditinternetLink() throws InterruptedException{
		loadtime();
		
	//	clickByXpathExplict(prop.getProperty("click.submenu.internet.xpath"));
	//	loadtime();
		
boolean a=		VerifyElementpresentreturn(prop.getProperty("click.internet.menu.link.xpath"));
		scrolltoelementJs(prop.getProperty("click.internet.menu.link.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.internet.menu.link.xpath"));
			return new BillPaymentsPage(driver, test);

	}

	public BillPaymentsPage clickInsurLink() throws InterruptedException{
		
		
		scrolltoelementJs(prop.getProperty("click.submenu.insurance.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.submenu.insurance.xpath"));
		loadtime();
		
//		scrolltoelementJs(prop.getProperty("click.insurance.menu.link.xpath"));	
		
		clickByXpathExplict(prop.getProperty("click.insurance.menu.link.xpath"));	
			return new BillPaymentsPage(driver, test);

	}	
	
	public BillPaymentsPage clickInsuranceLink() throws InterruptedException{
		
		
		
		//clickByXpathExplict(prop.getProperty("click.submenu.insurance.xpath"));
		loadtime();
		scrolltoelementJs(prop.getProperty("click.insurance.menu.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.insurance.menu.link.xpath"));	
			return new BillPaymentsPage(driver, test);

	}
	
	public BillPaymentsPage clickInsuranceeditLink() throws InterruptedException{
		
		
		
//		clickByXpathExplict(prop.getProperty("click.submenu.insurance.xpath"));
	//	loadtime();
		
		scrolltoelementJs(prop.getProperty("click.insurance.menu.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.insurance.menu.link.xpath"));	
			return new BillPaymentsPage(driver, test);

	}
	
	
	
	
	public BillPaymentsPage clickTuitionFeesLink() throws InterruptedException{
		loadtime();
		
		
		//clickByXpathExplict(prop.getProperty("click.submenu.tuition.xpath"));	
		loadtime();
		scrolltoelementJs(prop.getProperty("click.tutionfees.menu.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.tutionfees.menu.link.xpath"));	
	//	Thread.sleep(10000);
		return new BillPaymentsPage(driver, test);

}
	
	public BillPaymentsPage clickTuitionLink() throws InterruptedException{
		loadtime();
		
		scrolltoelementJs(prop.getProperty("click.submenu.tuition.xpath"));	
		clickByXpathExplict(prop.getProperty("click.submenu.tuition.xpath"));	
		loadtime();
		scrolltoelementJs(prop.getProperty("click.tutionfees.menu.link.xpath"));	

		clickByXpathExplict(prop.getProperty("click.tutionfees.menu.link.xpath"));	
	//	Thread.sleep(10000);
		return new BillPaymentsPage(driver, test);

}	
	
	public BillPaymentsPage clickeditTuitionFeesLink() throws InterruptedException{
		//loadtime();
		
		
		//clickByXpathExplict(prop.getProperty("click.submenu.tuition.xpath"));	
		loadtime();
scrolltoelementJs(prop.getProperty("click.tutionfees.menu.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.tutionfees.menu.link.xpath"));	
	//	Thread.sleep(10000);
		return new BillPaymentsPage(driver, test);

}
	
	
	
	
	
	
	
	
	
	
	
	

}
