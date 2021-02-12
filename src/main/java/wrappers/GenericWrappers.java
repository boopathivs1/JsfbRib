package wrappers;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.eclipse.jetty.io.UncheckedPrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

import afu.org.checkerframework.checker.formatter.FormatUtil.ExcessiveOrMissingFormatArgumentException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.Reporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericWrappers extends Reporter implements Wrappers {
	public static RemoteWebDriver driver;

	public static boolean frameStatus;
	
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;String url2;
	public String environment="https://";
	public List<String>Bznme=new ArrayList<String>();
    public static String getrefnumer=null;
    public static String datatag=null;
    public String StatementBalanceAmount;
    public String finalBalanceAmount;
    public static String BillDueAmount="";
    public static String randomdata1=null;
    public String otpcode="777777";
    public static String AuthUsername=null;
    public static List<String> statuscheck=null;

    public static String digitone="";
    public static String digittwo="";
	public static Boolean LogoutStatus=null;
	public static String usertype=null;
	
	//Db Variables
	static final String DB_URL ="jdbc:oracle:thin:@//10.5.41.200:1590/ubaprod";
	static final String USER = "RIB_UAT_APP_USER_R2";
	static final String PASS = "rib_UAT_APP_USER_R2321";
	static final String cif_id = "00117434";
	public static String DbOTP="";
	//
	private static String encryptMD5Key = "AA5B3D4D1E7FBA9CDF7B3D4D1E3AB927145B23456E7FBA22";

	
	
	
	public GenericWrappers() {	
		Properties prop = new Properties();
		//
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		}
	
	
	public void DBOTP_function() throws InterruptedException {
		try {
			readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

	try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.5.41.200:1590:BRAC_UAT_R2",USER,PASS);	
		System.out.println("------------------------------------");
		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@//172.25.15.17:1590/ubadevdb","RIB_UAT_APP_USER_R2","rib_UAT_APP_USER_R2321");
		Statement stmt=con.createStatement();  
		//ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance tatus_id='PENDING' order by generated_datetime desc"); 
//		ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where status_id='PENDING' order by generated_datetime desc");  			
	

		ResultSet rs=stmt.executeQuery("select otp_number from user_otp_maintenance where cif_number='00117434'and status_id='PENDING' order by id desc");  

		

		for(int i=0; i<1; i++)
		{
			
		
		
		System.out.println("------Result fetched---------");			
		while(rs.next())  {
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			String otp =rs.getString("otp_number");
			System.out.println(otp+"finalvalue");
			String decrptedOtp=		decryptUsingMD5(otp);
			System.out.println(decrptedOtp);
			
			if (i  == 0)
			{
//				DbOTP = otp ;
				DbOTP = decrptedOtp ;
	
				
				break;
			}
		}
		
		
		}
		
		stmt.close();
		con.close(); 
		reportStep("DB retrieved OTP Value is "+DbOTP, "Pass");
}
catch(Exception e){
	reportStep("Unable to retrieved OTP Value from DB  ", "FAIL");
} 
}	
	public static String decryptUsingMD5(String input) throws Exception {
		String decText = null;
		Key key1 = null;
		byte[] message = java.util.Base64.getDecoder().decode(input);
		int index = message.length - 9;
		byte[] encTxt = new byte[index];
		byte[] iv1 = new byte[8];
		byte[] len = new byte[1];		
		System.arraycopy(message, 0, encTxt, 0, index);
		System.arraycopy(message, index, iv1, 0, 8);
		System.arraycopy(message, index + 8, len, 0, 1);
		int length = (int) len[0];
		try {

			final MessageDigest md = MessageDigest.getInstance("md5");
			final byte[] digestOfPassword = md.digest(encryptMD5Key.getBytes("utf-8"));
			final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			for (int j = 0, k = 16; j < 8;) {
				keyBytes[k++] = keyBytes[j++];
			}
			DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			key1 = keyfactory.generateSecret(spec);
			final IvParameterSpec iv = new IvParameterSpec(iv1);
			final Cipher decipher = Cipher.getInstance("DESede/CBC/NoPadding");
			decipher.init(Cipher.DECRYPT_MODE, key1, iv);
			final byte[] plainText = decipher.doFinal(encTxt);
			byte[] decByte = new byte[length];
			System.arraycopy(plainText, 0, decByte, 0, length);
			decText = new String(decByte, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Decrypted :: " + decText);
		return decText;
	}
	
	
	public void isjQueryLoad(WebDriver driver) {
        System.out.println("Waiting for ready state complete");
        (new WebDriverWait(driver, 80)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                System.out.println("Ready State: " + readyState);
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
	}
	public static String randomStringGeneration() throws InterruptedException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
	randomdata1 = sb.toString();
		//System.out.println(output);
	
		
		return randomdata1;

	}
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	public void verifyElementVisible(WebElement element){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElements(element));



    }
	
	
	
	
	
	
	
	
	public boolean waitForJSandJQueryToLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
		
	public void verifyTextMatchlistByXpath(String xpath,String Status){
		//waitForElement(xpath, 41);
	
		WebDriverWait wait;
		try{
		List<String>a1=new ArrayList<String>();
		Thread.sleep(8000);
	 wait= new WebDriverWait(driver,41);
List<WebElement> elem=driver.findElements(By.xpath(xpath));

System.out.println(elem.size());
Thread.sleep(6000);
for (int i = 0; i <elem.size(); i++) {
	String elestatus=elem.get(i).getText();
	System.out.println(elestatus);
	System.out.println(Status);
if(elestatus.equalsIgnoreCase(Status)){
	System.out.println(elem.get(i).getText());
}
else{
	throw new RuntimeException("list has not matched");
	
}
}
reportStep("Status has matched in this List", "Pass");
		}
catch (Exception e) {
	reportStep( ""+Status+"has not matched in List", "Fail");
	}
}

	
	
	
	

	 public void waitpageLoad(WebDriver driver) throws InterruptedException {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	String result = js.executeScript("return document.readyState").toString();
	    if (!result.equals("complete")) {
	     Thread.sleep(1000);
	    } 
	}
	 public void waitLoading(WebDriver driver) {


	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }

	
	
	
	public void verifyTextlistcontainXpath(String xpath,String Status){
		WebDriverWait wait;
		
		try{
			Thread.sleep(3000);
			  	wait= new WebDriverWait(driver,41);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
		System.out.println(arrval);		
		   }
	
	System.out.println(Status);
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	System.out.println(arrval);
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	       System.out.println(j); 
if(j==1){
	reportStep(Status+" has matched in this List", "PASS");
}else{
	reportStep(Status+" has not matched in this List", "FAIL");

}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has not matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextlistnotcontainXpath(String xpath,String Status){
		try{
			  		WebDriverWait wait= new WebDriverWait(driver,41);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
		System.out.println(arrval);		
		   }
	
	System.out.println(Status);
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	System.out.println(arrval);
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	       System.out.println(j); 
if(j==0){
	reportStep(Status+" has not matched in this List", "PASS");
}else{
//	reportStep(Status+" has matched in this List", "FAIL");
throw new RuntimeException();
}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextsizecontainslistByXpath(String xpath,int Status){
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver,41);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);

int a=element.size();
System.out.println(a);
if(a==Status){
	
reportStep(Status+" has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(Status+" has not matched in this list","FAIL");
	}
}
	
	
	public void verifyExactTextcontainslistByXpath(String xpath,String Status){
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 41);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(20000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();
System.out.println(cate);
		a1.add(cate);
	}
		Thread.sleep(5000);

		
		
		int k=0;
		for (int i = 0; i <a1.size(); i++) {
			System.out.println("iiiiiiiiiiiiii");
			System.out.println(a1.get(i));
			if(a1.get(i).contains(Status)){
				k=1;
				reportStep(" Text has matched in this List", "PASS");
		
				break;
		}
		}	
			if(k==0){
				reportStep(" Text has not matched in this List", "FAIL");
				
			}
		}
		
			
		catch (Exception e) {
			reportStep(Status+" Text has not matched in this List", "FAIL");
		}
		}
		
		
	public void verifyExactTextcontainslistReg(String xpath,String Status) throws InterruptedException{
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		Thread.sleep(7000);
		
		
		
		
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 41);
		Thread.sleep(3000);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(8000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();
		String a=regvalue(cate);
		System.out.println("after reg from trans");
		System.out.println(a);
		System.out.println("end");		
		String str = a;
		String digits="";
		for (int i = 0; i < str.length(); i++) {
		    char chrs = str.charAt(i);
		    if (Character.isDigit(chrs)){
		        digits = digits+chrs;
		}
		    System.out.println("final digits");
		System.out.println(digits);

				}


		String		firsttwonum = digits.substring(0,2);

		
		
		
		
		
		
		
		
		System.out.println("firsttwonum");
		
		System.out.println(firsttwonum);
		a1.add(firsttwonum);
	}
		Thread.sleep(4000);

		
		
		int k=0;
		for (int i = 0; i <a1.size(); i++) {
			System.out.println("iiiiiiiiiiiiii");
			System.out.println(a1.get(i));
			if(a1.get(i).contains(Status)){
				k=1;
				reportStep(" Transaction has matched in this List", "PASS");
		
				break;
		}
		}	
			if(k==0){
				reportStep(" Transaction has not matched in this List", "FAIL");
				
			}
		}
		
			
		catch (Exception e) {
			reportStep(" Transaction has not matched in this List", "FAIL");
		}
		}
		
			
	
	
	
	
	
	public void verifyTextcontainslistByXpath(String xpath,String Status){
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 41);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();
System.out.println(cate);
		a1.add(cate);
	}
		Thread.sleep(5000);

if(a1.contains(Status)){
	
	System.out.println("*********");
System.out.println(a1);
System.out.println("*********");
reportStep(Status+" Reference number has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+"Reference number has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "FAIL");
	}
}
	
	
	
	
	
	public void verifytextmatches(String a ,String b){
if(a.equalsIgnoreCase(b)) {
	reportStep(a+"Matches with the value "+b, "PASS");
	
}
	else {
		reportStep(a+"does not Matches withe value "+b, "FAIL");
	}
	}
	public void verifyNottextmatches(String a ,String b){
		if(!a.equalsIgnoreCase(b)) {
			reportStep(a+"not Matches with the value "+b, "PASS");
			
		}
			else {
				reportStep(a+" Matches withe value "+b, "FAIL");
			}
			}
	public void verifyNottextmatches(String a ,String b,String validmsg,String invalidmsg){
		if(!a.equalsIgnoreCase(b)) {
			reportStep(a+""+validmsg+""+b, "PASS");
			
		}
			else {
				reportStep(a+""+invalidmsg+" "+b, "FAIL");
			}
			}
	
	public void verifyGreaterValues(int a ,int b,String validMsg,String InvalidMsg){
		
	if(a>b){
		
		reportStep(validMsg,"PASS");
	}
	else {
		reportStep(InvalidMsg,"FAIL");
		
	}
	
	
	
	}
	
	
	
	public void StatusUpdate(String msg,String status) {
		try{
			if("PASS".equalsIgnoreCase(status))
			{
				reportStep(msg, "PASS");
			}
			else {
				reportStep(msg, "FAIL");
			}
					}
		catch (Exception e) {
			reportStep("Element not found", "FAIL");
		}
	}
	public void del() throws IOException{
		try{	
		FileUtils.cleanDirectory(new File("./reports"));
		}catch(Exception ie){
			
		}
		}

	
	
	
	
	
	
	
	
	
	public void verifyTextcontainslistandSetuserid(String xpath,String Status){
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 41);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(4000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();
System.out.println(cate);
		a1.add(cate);
	}	
		Thread.sleep(4000);
				
if(a1.contains(Status)){

	AuthUsername=Status;
	System.out.println("*********");
System.out.println(a1);
System.out.println("*********");
reportStep(Status+"  has matched in this List", "Pass");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "Fail");
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	public void navigate(String url) {
		try {
			 url2=environment+url;
			System.err.println(url2);
			driver.navigate().to(url2);
		/*	for (int i = 0; i<5; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}*/
			reportStep("Now the page has landed with this url"+url2, "PASS");
		
		}
		catch (NoSuchWindowException e) {
			reportStep("Window was unfortunately closed"+url2, "FAIL");
		}
		catch (TimeoutException e) {
			reportStep("Timeout Exception has occured"+url2, "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Now the page has not landed with this url"+url2, "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpathexplictwaitalert(String xpath, String text) throws InterruptedException{
		try{
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}}

		catch (Exception e) {		
				reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void enterBycssXpathExplict(String xpathVal, String mobileNo) {
		try{
		
			Thread.sleep(6000);
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xpathVal)));
					element.sendKeys(mobileNo);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
			catch (Exception e) {
		System.out.println(e);
				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}

public void clicklistByxpathExplicitwaitindex(String xpathValue,int i) {
	try {
		WebDriverWait wait= new WebDriverWait(driver, 41);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(i).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
			System.out.print(e);
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}
	public String Data(String data) throws InterruptedException {
	Random r = new Random();
	int Low = 1;
	int High = 5;
	int R = r.nextInt(High-Low) + Low;			
//alphabit	
	String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
	int character=(int)(Math.random()*26);	
	System.out.println(character);
	String s=alphabet.substring(character, character+1);	
	
	String bizname=data+s;
	Bznme.add(bizname);
return bizname;
	}
	
	

	
	
	
	
	
	
	public void verifyElementtwoelementpresentByXpathExplicitwait(String xpath,String xpaths,String validmsg,String errorvalid){
		try {
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//String sText = element.getText();
			if (element1.isDisplayed()&&element2.isDisplayed()){
				reportStep(validmsg+xpath, "PASS");
			}else{
				reportStep(errorvalid +xpath, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep(errorvalid+xpath, "FAIL");

		}
	}
	
	public void verifyTextcontainsurls( String url,String text){
		try {
				if (url.contains(text)){
				reportStep("The text: "+url+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+url+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	public Boolean VerifyElementpresentSec(String xpath) {
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,5);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
		
	public Boolean VerifyElementpresent15Sec(String xpath) {
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,15);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	public Boolean VerifyElementDisplay(String xpath) {
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		Boolean B=false;
		try{
			Thread.sleep(2000);
		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}


	public Boolean VerifyElementpresentreturn(String xpath) {
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,80);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
		
	
	
	public Boolean VerifyElementvisible(String xpath) {
		
	
		
		Boolean B=false;
		try{
			
	WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
//			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
		
	

	
public Boolean VerifyWaitElementpresentreturn(String xpath) {
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,41);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
	//		reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	public Boolean VerifyElementWARNreturn(String xpath) {
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);

			wait = new WebDriverWait(driver,41);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	//WebElement e  =driver.findElement(By.xpath(xpath));
		
		
		if(e.isDisplayed())
		{

			B=true;
			//System.out.println("*********Element is present"+e.getText()+"*********");
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		//	System.out.println("*********Element is not present"+e.getText()+"*********");
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	
	public void pageRefresh( ){
		try {
				driver.navigate().refresh();
				reportStep("Page has refresh sucessfully", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has refresh sucessfully", "FAIL");
		}
	}
	
	
	
	
	public void verifybyAttributescontainsxpathvalidinvalid(String xpath, String attributes ,String compText,String validmsg,String errorvalid) throws InterruptedException {
		try{
			Thread.sleep(3000);
			String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
	System.out.println(sText);
			if (sText.contains(compText)){
				
				reportStep(sText+ "contains the value  "+ validmsg, "PASS");
			}else{
				System.out.println("******************"+sText+"***************");
				System.out.println("+++++++"+compText+"++++++++++++");
				
				
				reportStep(sText+ "does not contains the value  " +errorvalid, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
	}


	public void verifyTextnotPresentCONTAINSByXpath(String xpath, String text){
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();

			if (sText.contains(text)){
				System.out.println("*****************"+sText+"***********");				
				reportStep(text,"FAIL");	
			}
	

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
			
			
		
	}


	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}

	

	public void invokeApp(String browser) throws IOException {
						invokeApp(browser,false);
			}

	
	 

	
	public void invokeApp(String browser, boolean bRemote) {
		try {
//sabb	
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			
			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivers.exe");
					
					
					driver = new ChromeDriver();
			
				}else{
						System.setProperty("webdriver.gecko.driver", "./drivers/geckodrivers.exe");
					driver = new FirefoxDriver();
			
				}
			}
		
			/*
			Dimension dime= new Dimension(3560,2680); 
			driver.manage().window().setSize(dime);
			System.out.println(driver.manage().window().getSize());
			
			*/
			
			driver.manage().timeouts().implicitlyWait(41, TimeUnit.SECONDS);



driver.manage().window().maximize();
			

//driver.manage().window().maximize();
//driver.manage().deleteAllCookies();
//driver.manage().deleteCookieNamed("https://sabbcorpdev1.sabb.com/Corporate/");
//driver.manage().deleteCookieNamed("https://sabbcorpdev.sabb.com/Corporate/");
//driver.get("chrome://settings/clearBrowserData");

		//	driver.get("chrome://settings/clearBrowserData");
		//    driver.findElementByXPath("//settings-ui").sendKeys(Keys.ENTER);

//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
			
			
//Thread.sleep(3000);			


		//	url2=environment+sUrl;
  		//	driver.get(url2);
//  			Thread.sleep(1000);			

  		//	driver.get(url2);
  //	
  			getnewurl();
  		//	driver.get(url2);
  			//Thread.sleep(2000);
 // 			getnewurl();
  		  	
  			try {
  				readytimes();
  				readystate();
  				jqueryload();
  			} catch (InterruptedException e1) {
  			}
  			
  			
			primaryWindowHandle = driver.getWindowHandle();		
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	
	
		
	
			

public ArrayList<WebElement>arraylisting(String xpath)    {

ArrayList<WebElement>li=(ArrayList<WebElement>) driver.findElements(By.xpath(xpath));
return(li);
}
	

public void Scrollup() {
	try {
//		readywithtime(xpathVal);
	
		readytimes();
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	try{
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,0)");
		
		
		reportStep("Page has sucessfully scrolled", "PASS");

	}
	catch (Exception e) {
		//reportStep("Page has not sucessfully scrolled", "FAIL");
	}
}





	
	
	public void pageScrollup() {
		try{
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	public void pageScroll() {
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,700)", "");
	Thread.sleep(3000);
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
public void clickJswait(String xpath){
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		
wait = new WebDriverWait(driver,41);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" is clicked.", "FAIL");

}	
}

public void clickJs(String xpath){
	try{
		Thread.sleep(2000);
WebElement element=driver.findElement(By.xpath(xpath));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" could not be clicked.", "FAIL");

}	
}

	public void scrolltoelementJs(String xpathtext) throws InterruptedException{
	//	loadingMethod(xpathtext);
		
		
		
try{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(2000);
	WebElement Element = driver.findElement(By.xpath(xpathtext));

	js.executeScript("arguments[0].scrollIntoView();", Element);

	try {
		readywithtime(xpathtext);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}


reportStep("Scroll to element: "+xpathtext+" is clicked.", "PASS");
	
	
	
	}
catch (Exception e) {

	reportStep("Unable to scroll to this element: "+xpathtext+".", "FAIL");

}
	}	
	public void MouseHoverByXpathExplict(String xpathVal) {
		WebDriverWait wait;
//		waitForElement(xpathVal,60);
		try{
			Thread.sleep(2000);
			Actions actions = new Actions(driver);

			WebElement element = driver.findElement(By.xpath(xpathVal));

		    // waits until Home link is visible on the web page

		  wait = new WebDriverWait(driver, 41);
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		    actions.moveToElement(element).perform();


	reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

	
	
	try {
		readywithtime(xpathVal);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}

	
		}
		
		catch (Exception e) {
			reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
		}

		
	}

	
	public void pageScroll1400(String xpath) throws InterruptedException {
	//	loadingMethod(xpath);
		try{
			 JavascriptExecutor js = (JavascriptExecutor) driver;

			 WebElement Element = driver.findElement(By.xpath(xpath));

			        //This will scroll the page till the element is found		
			        js.executeScript("arguments[0].scrollIntoView();", Element);

	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void pageScroll400() {
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void openwindow() {
		try{
	
	if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("window.open();");
        }
	reportStep("New window has opened", "PASS");

		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	public void windowhandless(int j) {
		try{
	
	
	
	
	Set<String> childwindow=driver.getWindowHandles();
	childwindow=driver.getWindowHandles();
    String[] individualHandle = new String[childwindow.size()];
    Iterator<String> it = childwindow.iterator();
    int i =0;
    while(it.hasNext())
    {
        individualHandle[i] = (String) it.next();
        i++;
    }

driver.switchTo().window(individualHandle[j]);
	
	

reportStep("New window has opened", "PASS");

	
		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	

	public void geturl(String url) {
		try{
	
		driver.get(url);
		driver.get(url);
		
	reportStep("Page has landed on " +url, "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not landed on " +url, "FAIL");
		}
	}
	

	
	public void navigateback() {
		
	try {
		driver.navigate().back();
		reportStep("Page has navigated back sucessfully", "PASS");

	}
		catch (Exception e) {
		}
		
	}
	
	/*
	public void clickByXpathExplict(String xpathVal) {
		WebDriverWait wait;
		try{
		
			Thread.sleep(2000);

wait = new WebDriverWait(driver,80);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));

System.out.println(element+"element will click");	

element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
	}
	
	*/
	
	public  void waitForElement(String objectName,int timeout) 
	{
		try{
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

		for(int i=1;i<=timeout;i++)
		{
			
		try{

			
		Boolean a=VerifyWaitElementpresentreturn(objectName);
if(a){
break;
}
		}
		catch(InvalidSelectorException e)
		{
			
			
			System.out.println("InvalidSelectorException occured. Retrying..............");
			waitTimeForException(1);
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("StaleElementReferenceException occured. Retrying..............");
			waitTimeForException(1);
			System.out.println(e.toString());
		}
		catch(NoSuchElementException e)
		{

			System.out.println("Info NoSuchElementException occured. Retrying..............");
			waitTimeForException(1);
		}
		catch(ElementNotVisibleException e){
			System.out.println("ElementNotVisibleException occured. Retrying..............");
			waitTimeForException(1);
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("Unreachable exception. Retrying..............");
			
		}
		catch(WebDriverException e){
			
			System.out.println("WebDriverException occured. Retrying..............");
			waitTimeForException(1);
			System.out.println(e.toString());
		}
		
		if(i==timeout)
		{
			System.out.println(" "+objectName+" element not found within '"+timeout+"' seconds timeout ");
		}
		}
		}
		catch(Exception e)
		{
//			stepFailed(e.toString());
			System.out.println(e.toString());
		}
		finally
		{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			
  }


public void waitTimeForException(int sec)
	{
		try{
			Thread.sleep(sec*1000);
		}
		catch(Exception e)
		{
	System.out.println(e.toString());
		}
	}
	
	
public void MouseHoverXpathExplict(String xpathVal) {
	WebDriverWait wait;
//	waitForElement(xpathVal,41);
	try{
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver, 41);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    actions.moveToElement(element).perform();


reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

	}
	
	catch (Exception e) {
		reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
	}

	
}

void waitForLoading(WebDriver driver) {
	ExpectedCondition<Boolean> pageLoadCondition = new
	    ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	WebDriverWait wait = new WebDriverWait(driver, 120);
	wait.until(pageLoadCondition);
	}

public void loadtime() throws InterruptedException{
	try {
		readytimes();

//readystate();
jqueryload();
	} catch (InterruptedException e1) {
	}
	
}




public void pagesourceload(String keyword) throws InterruptedException{
	for(int i=1;i<60;i++){

	try{
	boolean a=driver.getPageSource().contains(keyword);
	if(a){
		System.out.println("page source dash board load" +i);

		break;
	}
	else if(!a){
		Thread.sleep(1000);
		System.out.println("page source dash board load !" +i);

		break;
	}
     else {
System.out.println("page source  dash board loading " +i);
Thread.sleep(1000);
}			
	}			
	
catch (Exception e) {
// TODO: handle exception
}
	
	}
	}	






public void loadingMethod(String xpathVal) throws InterruptedException{
	for(int i=1;i<180;i++){
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;		
	        String loadstate = js.executeScript("return document.readyState").toString();
	     
	        
	        System.out.println("qqqqqqqqqqqqqq");
	        System.out.println(loadstate);
	        System.out.println("qqqqqqqqqqqqqq");
if (loadstate.contains("complete")){
Thread.sleep(1000);
System.out.println(xpathVal);
System.out.println(loadstate);
System.out.println("page has loaded");
System.out.println(i);
break;
}
else{
Thread.sleep(1000);

System.out.println("loading page......");
System.out.println(i);
System.out.println(loadstate);





//break;
}	}

}


void waitForElementLoad(WebDriver driver) {
	ExpectedCondition<Boolean> pageLoadCondition = new
	    ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	WebDriverWait wait = new WebDriverWait(driver, 120);
	wait.until(pageLoadCondition);
	}
public static boolean isClickable(WebElement el, WebDriver driver) 
{
try{
    WebDriverWait wait = new WebDriverWait(driver,120);
    wait.until(ExpectedConditions.elementToBeClickable(el));
    return true;
}
catch (Exception e){
    return false;
}
}


/*

public void clickByXpathExplict(String xpathVal) {
	WebDriverWait wait;
	try{	
Thread.sleep(2000);
wait = new WebDriverWait(driver,40);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
System.out.println(element+"element will click");	
waitForElementLoad(driver);
for(int i=1;i<30;i++){
Boolean a=isClickable(element, driver);
if(a){
	System.out.println(a);
	element.click();
	break;
}
else{
	System.out.println("loading for element enable "+i+"secs");
	Thread.sleep(1000);
}
}
reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");	
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		//System.out.println(e.getMessage());
	}
}
*/

public void isjQueryLoaded(WebDriver driver) {
    System.out.println("Waiting for ready state complete");
    (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            JavascriptExecutor js = (JavascriptExecutor) d;
            String readyState = js.executeScript("return document.readyState").toString();
            System.out.println("Ready State: " + readyState);
            return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
        }
    });
}


public void readywithtime(String xpathVal) throws InterruptedException{
	
	try{
	
	for(int i=1;i<150;i++){
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;		
	     String loadstate = js.executeScript("return document.readyState").toString();
	     
	        
	 
if (loadstate.contains("complete")){
Thread.sleep(1000);
break;
}
else{
Thread.sleep(1000);






//break;
}	}
	}
	
	catch(Exception e){
		
	}
}

public void readytimes() throws InterruptedException{

	try{
	for(int i=1;i<120;i++){
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;		
	     String loadstate = js.executeScript("return document.readyState").toString();
	     
	        
	 
if (loadstate.contains("complete")){
Thread.sleep(1000);

break;
}
else{
Thread.sleep(1000);





//break;
}	}

	
}	
	catch(Exception e){
		
	}

}
public void readystate(){
WebDriverWait wait;

try{
  wait = new WebDriverWait(driver,120);


//wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 

  wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
}
catch(Exception e){
	
}


}

public void jqueryload() throws InterruptedException{
try{
	JavascriptExecutor js = (JavascriptExecutor) driver;
int count =0;
if((Boolean)js.executeScript("return window.jQuery != undefined"))
{
	while(!(Boolean) js.executeScript("return jQuery.active == 0"))
	{ 

		Thread.sleep(1000); 
		if(count>150) 
			break;
		count++;
		} 
	}
}
catch(Exception e){
	
}


}	
	

public void clickByXpathExplict(String xpathVal) throws InterruptedException {

	
	try {
		//Thread.sleep(2000);
		readywithtime(xpathVal);
	//	readystate();
		jqueryload();
	} catch (Exception e1) {
		//reportStep("jquery wait has supporting", "FAIL");
		
		
	}
	
	WebDriverWait wait;
	try{	
Thread.sleep(2000);

wait = new WebDriverWait(driver,60);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
System.out.println(element+"element will click");	

//waitForLoad(driver);
element.click();

reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");

	
	

	
	
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		//System.out.println(e.getMessage());
	}

	
	
		}





	
	public void clickBylocatorswait(String xpathVal) throws InterruptedException {
		

WebDriverWait wait;
		try{
			Thread.sleep(2000);
		  wait = new WebDriverWait(driver, 50);
	WebElement element=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));	
element.click();
	

reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		
//jqueryload();


		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
		
		}
	
		
		
			
	public String regvalue(String Accno){
		String Accnumber = null;
		try{
	String userAccNo= Accno;   
	userAccNo = userAccNo.replaceAll("[^a-zA-Z0-9]", " ");  
	Accnumber = userAccNo .replaceAll("\\s","");
	System.out.println(Accnumber);
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return Accnumber;
	}
	public void clickByXpathwait(String xpathVal) {
	
		WebDriverWait wait;
		try{
		
			
wait = new WebDriverWait(driver,41);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));

System.out.println(element+"element will click");	

element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
		    ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		        }
		    };
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(pageLoadCondition);
		}
	
	
	
	
	
	
	
	
	
	
	
	public void doubleclickByXpathExplict(String xpathVal) {
		try{
	
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,41);
			//WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			
			action.doubleClick(element).perform();
			
		
		} 
		
		
			
	
		//catch (TimeoutException e) {
			//reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
		
		
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
			//System.out.println(e.getMessage());
		}
	}
	
	
	public void locateFrame(String framename) throws InterruptedException {
		try {
			readytimes();
			//readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		try{
			driver.switchTo().frame(framename);
		
			frameStatus=true;
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	public void locateFrameById(String xpath) {
		try{
			WebElement iframeElement = driver.findElement(By.id(xpath));
			driver.switchTo().frame(iframeElement);
			
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	public void defaultcontent() {
		try{
			driver.switchTo().defaultContent();
			
			frameStatus=false;
			reportStep("Now switched to default content", "PASS");
		} 
		
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}
		
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
		
		
	}
	
	
	
	
	public void verifyElementpresentByXpathExplicitwait(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		}

		try {
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			reportStep("Element is not Displayed with xpath " +xpath, "FAIL");

		}
	}
	
	public void belliconFail(String xpath) throws InterruptedException{
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				throw new RuntimeException("bell icon not display Reference number");
			}
		}
		
		catch (Exception e) {
			clickByXpathExplict(prop.getProperty("click.buttonclosepopup.xpath"));
			reportStep("Bell icon not display Reference number "+xpath, "FAIL");
			
		}
	}

	
public void submitOtp(String otp) throws InterruptedException{
	enterByXpathExplict(prop.getProperty("enter.otp.xpath"),otp);
	clickByXpathExplict(prop.getProperty("click.submitotp.xpath"));
	}
	
	
	public void verifyElementpresentByXpathExplicitw(String xpath){
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
			reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			//reportStep("Unknown Exception has occured", "FAIL");

		}
	}
	
public void loadendtimecalc(String xpath,String loadmsg) throws InterruptedException {
	int loadtime = 0;
	long servicestart=  System.currentTimeMillis();	
	//for(int k=0;k<=50;k++){
		Thread.sleep(500);
	//	System.out.println(k);
	
	//VerifyElementPresent(xpath);
	verifyElementpresentByXpathExplicitw(xpath);
//	Thread.sleep(10000);		
	
	long serviceend =  System.currentTimeMillis();
			long serviceload = serviceend - servicestart;
			float loadsec=serviceload/1000;
		//	serviceloadtime = Integer.toString((int) loadsec);	
			
		 loadtime=(int)loadsec;
			
System.out.println(loadtime+"***********");

			//	System.out.println("Time taken to land in to service module in seconds : "+serviceloadtime);
//break;



//	}
	

	if(loadtime>10||loadtime==11)
	{
		reportStep(loadmsg+ " more than 10 seconds and actual loading time is "+loadtime , "FAIL");

		
	}
	else {
		reportStep(loadmsg+ " less than 10 seconds  and actual loadtime is " +loadtime, "PASS");

	}

}






	

	
	
	
	
	
	
	public void enterByXpathExplict(String xpathVal, String data)    {
	//Boolean a=VerifyElementpresentreturn(".//div[@class='ajax-loader'][@style='display: none;']");
	try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			 wait = new WebDriverWait(driver,41);

			 
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");
System.out.println(e);
				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}

	public void fileUploadByXpathExplict(String xpathVal, String data) {
	//	WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
//wait = new WebDriverWait(driver,100);
//WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));

WebElement e=driver.findElement(By.xpath(xpathVal));

		e.sendKeys(data);
		
	
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");
System.out.println(e);
				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}
	
	
	
	
	public void uploadfile(String xpathVal, String data) {
		try{
		
			//driver.findElement(By.xpath(xpathVal)).clear();
			WebDriverWait wait = new WebDriverWait(driver,41);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
		//	WebElement element = driver.findElement(By.name("uploadsubmit"));
			//To input the filename along with path
			//		element.sendKeys("D:/file.txt");
			
					
			reportStep("file has been uploaded "+xpathVal +"", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");
System.out.println(e);
reportStep("file has not been uploaded "+xpathVal +"", "FAIL");
		}
	}
	
	
	
	



public void clicklistByxpath(String xpathValue) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}

	
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(6000);
		System.out.println(list.size());

		list.get(0).click();		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL");
	}
		catch (Exception e) {
			System.out.print(e);
			
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL");
}
}

public void comparevalues(int a,int b) {
	
		if (a!=b){
			reportStep("size is not equal pass", "PASS");
		}else{
			reportStep("size is  equal failed", "FAIL");
		}
	}

public void comparevaluesGreater(int a,int b,String validmsg,String errormsg) {
	
	if (a<b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}




public void comparevaluesEqual(int a,int b,String validmsg,String errormsg) {
	
	if (a==b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}

public void verifybyAttributesPreselectxpath(String xpath, String attribute,String comptext,String validmsg,String errorvalidmsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attribute);
		System.out.println(sText);
		System.out.println(comptext);
		
		if (sText.equalsIgnoreCase(comptext)){
			reportStep(validmsg, "PASS");
		}else{
			reportStep(errorvalidmsg, "FAIL");
		}
	}
	catch (Exception e) {
		reportStep("The "+comptext+" Value does not matched" , "FAIL");
	}
	
	
}







public void verifybyAttributesxpath(String xpath, String text) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
	//	e1.printStackTrace();
	}

	try{
		String sText = driver.findElementByXPath(xpath).getAttribute("value");
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void booleanVerifyResult(Boolean a,String b,String c)
{
	if(a){
		reportStep(b, "PASS");
	}
	else{
		reportStep(c, "FAIL");
	}
	

}


public void booleanResult(Boolean a,String b)
{
	if(a){
		reportStep(b, "WARN");
	}
	
}


public void booleanResultFail(Boolean a,String b)
{
	if(!a){
		reportStep(b, "FAIL");
	}
	
}


public void booleanLogoutNoElementResult(Boolean a,String b)
{
	
	try {
		readytimes();
		//readywithtime(xpathVal);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	if(!a){
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void booleanNoElementPresentResult(Boolean a,String b)
{
	
	if(!a){

		reportStep(b, "INFO");
	}
	
}

public void booleanelementInfo(Boolean a,String b)
{
	if(a){

		reportStep(b, "INFO");
	}
	
}

public void booleanNoElementResult(Boolean a,String b)
{
	if(!a){
		reportStep(b, "WARN");
	}
	
}



public void LogoutbooleanResult(Boolean a,String b)
{
	if(a){
		
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void verifybyAttributesxpath(String xpath, String text,String attributval) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}

	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attributval);
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public String getAttributesxpath(String xpath, String text) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
	//	e1.printStackTrace();
	}

	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(text);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
	
	return sText;
}
public String getAttrixpath(String xpath, String text) {
		
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(text);
		}
	
	catch (Exception e) {
	}
	
	return sText;
}




public void AttributesVerifyxpath(String xpath, String value,String valtext) {
	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(value);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
		verifytextmatches(sText, valtext);
		
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" returned attribute", "FAIL");
	}
	
}



public void verifybyAttributesPresentxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);

		if (sText.equalsIgnoreCase("true")){
			
			reportStep("Attributes has preselected", "PASS");
		}else{
			System.out.println("******************"+sText+"***************");
			System.out.println("+++++++"+compText+"++++++++++++");
			
			
			reportStep("Attributes has not preselected", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifyxpathcontainselement(String xpath ,String compText) throws InterruptedException {
	try{
		Thread.sleep(2000);
		String sText = xpath;

		
		if (sText.contains(compText)&&driver.findElement(By.xpath(xpath)).isDisplayed()){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
			System.out.println("******************"+sText+"***************");
			System.out.println("+++++++"+compText+"++++++++++++");
			
			
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifybyAttributescontainsxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
System.out.println(sText);
		if (sText.contains(compText)){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
			System.out.println("******************"+sText+"***************");
			System.out.println("+++++++"+compText+"++++++++++++");
			
			
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}




public void verifybycheckboxpresent(String xpath, String attributes ,String compText,String validmsg,String errormsg) throws InterruptedException {
	try{
		Thread.sleep(3000);
		System.out.println("atttributes*****"   +attributes);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
System.out.println(sText+ "******");
		if (sText.equalsIgnoreCase(compText)){
			
			reportStep(validmsg+":", "PASS");
		}else{
			System.out.println("******************"+sText+"***************");
			
			
			reportStep(errormsg+":", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}

	catch (Exception e) {
		reportStep("unKnown Exception occur while verify", "FAIL");
	}



}







public void clicklistByxpathExplicitwaitfirst(String xpathValue) {
	
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, 41);
	
		
	//List <WebElement> myIput=(List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
	
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	
	
	myIput.get(0).click();
		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	

	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");


}
}





public void clicklistByxpathExplicitwait(String xpathValue) {
	
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		WebDriverWait wait= new WebDriverWait(driver, 41);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(0).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
			System.out.print(e);
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}


public void clicklistByxpathNosnap(String xpathValue) {
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(4000);
		System.out.println(list.size());

		list.get(0).click();	

reportStep("The element with id: "+xpathValue+" is clicked.", "PASS",false);

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL",false);
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL",false);
	}
		catch (Exception e) {
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL",false);
}
}


public void VerifyElementPresent(String xpath) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
//		e1.printStackTrace();
	}

	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		//System.out.println("*********Element is present"+e.getText()+"*********");
		reportStep("The element with xpath: "+xpath+" is present.", "PASS");

	}
	
	else {
	//	System.out.println("*********Element is not present"+e.getText()+"*********");
		reportStep("The element with id: "+xpath+" is not present .", "PASS");

	}
	
	
}
	
public void VerifyElementEnable(String xpath) {
	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isEnabled())
	{
		System.out.println("*********Element is present"+e.getText()+"*********");

	}
	
	else {
		System.out.println("*********Element is not present"+e.getText()+"*********");

	}
	
	
}
	





	
	















public void VerifyElementPresent(String xpath,String validmsg,String ErrorvalidMsg) throws InterruptedException {
	
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
	//	e1.printStackTrace();
	}
	
	
	
	WebDriverWait wait;
	
	try {
		Thread.sleep(2000);
		 wait = new WebDriverWait(driver,41);
			Thread.sleep(1000);
		 WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	
	
	if(e.isDisplayed())
	{
		reportStep( "Element is present: " +validmsg, "PASS");

	}
		
	
	}

	
	catch (Exception e) {
		System.out.println(e);
		reportStep(""+ErrorvalidMsg+"", "FAIL");
	}
	
	
	
}





public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	try {
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}

}

/*
public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {

	try{
		
WebElement e=driver.findElement(By.xpath(xpath));
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	
	catch (Exception e) {
		reportStep("Element has not found" +validmsg , "PASS");
	}
	
	
	
}
*/



public void VerifyElementenabledORdisabled(String xpath,String msg1,String status1,String Msg2,String Status2) {
	
	try {
		
		
		WebDriverWait wait = new WebDriverWait(driver,41);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	if(e.isEnabled())
	{
		
		reportStep( msg1+ " Element is ENABLED" , status1);

	}
	
	else if(!e.isEnabled()) {
				reportStep(Msg2+ " Element is disabled"  , Status2);

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}
	
	
	
}

















	

	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	public void enterByIdfileupload(String idValue, String data) {
		try {
			//driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	
	@Override
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		}
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		 catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}

	}

	
	@Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}

	}

	
	@Override
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		String currentUrl = null;
		String url= null;
		try{
			Thread.sleep(4000);
			
			if (driver.getTitle().equalsIgnoreCase(title)){
				
				
				currentUrl=driver.getCurrentUrl();
			 url="  "+currentUrl;
				reportStep("The title of the page matches with the value :"+title+url , "PASS");
				bReturn = true;
			}else
				System.out.println();
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title+ url, "SUCCESS");

		}
		
		catch (TimeoutException e) {
			reportStep(" while verifying the title Timeout Exception has occured"+title+ url, "FAIL");
		}
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title"+title+ url, "FAIL");
		}
		return bReturn;
	}

	@Override
	public void verifyTextByXpath(String xpath, String text){
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	

	

	
	
	public void verifyTextByXpathExplicitwait(String xpath, String text){
		
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
	
		
		
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	public void verifyTextByXpathOR(String xpath1,String xpath2, String xpath1text,String xpath2text){
		String verifytextone = null;
		String verifytexttwo = null;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
			
			
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
		
			
			verifytextone=element.getText();
			verifytexttwo=element1.getText();
			
			 if(element.isDisplayed()&&verifytextone.contains(xpath1text)){
				 
				 reportStep("The text: "+element.getText()+" matches with the value :"+xpath1text, "PASS");
			 }
			 else if (element1.isDisplayed()&&verifytexttwo.contains(xpath2text)) {
				 reportStep("The text: "+element1.getText()+" matches with the value :"+xpath2text, "PASS");				
			}
			
		}
			 catch (Exception e) {
			reportStep("The : "+verifytextone+ "or "+verifytexttwo+ "text does not matched"  , "FAIL");
		}
	}
	
	
	
	
	
	
	
	public void verifyTextContainsByXpathexplictwait(String xpath, String text) throws InterruptedException{
	//	loadingMethod(xpath);
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		}
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextnumberContainsByXpathexplictwait(String xpath, String text){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			WebDriverWait wait = new WebDriverWait(driver,41);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();

			String veritext=sText.replaceAll("[^0-9]", "");
						if (veritext.contains(text)){
				reportStep("The text: "+veritext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+veritext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextContainsByXpathexplictwaitint(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			String comptext=sText.replaceAll("[^0-9]", "");

						if (comptext.contains(text)){
							
				reportStep("The text: "+comptext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+comptext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	
	

	public String ReturnXpathtext(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		String sText = null;
		try{
		sText = driver.findElementByXPath(xpath).getText();
		reportStep(sText, "PASS");

		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		return sText;
	
	}
	
	
	public void ReferenceNo(String Refno,String Msg){
		
		try{
		reportStep( Msg+""+Refno, "PASS");

		}
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyTextContainsByXpath(String xpath, String text){
		//waitForElement(xpath,2);
		WebDriverWait wait;
		try{
			Thread.sleep(3000);
			
wait = new WebDriverWait(driver,41);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

			String sText = element.getText();
			
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpavalidMsg(String xpath, String text,String validmsg,String Errorvalidmsg){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep(validmsg, "PASS");
			}else{
				reportStep(Errorvalidmsg, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyUserdashboardPageLanding_TextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	
	
    
    public void ScrollclickByXpath(String xpath) {
		try{
			JavascriptExecutor JE = driver;  
		    WebElement scroll= driver.findElement(By.xpath(xpath));
		    JE.executeScript("arguments[0].scrollIntoView(true);",scroll);    
		    scroll.click();
		    reportStep("The Page has scrolled element with id: "+xpath+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+xpath+" could not be clicked.", "FAIL");
		}
	}

    
    
    
    
	
	//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(xpathVal)));
			
			
			
			public void verifyUserdashboardPageLanding_TextContainsByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,41);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			public void verifyUserdashboardPageLanding_TextContainsORoperatorByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,41);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			
			
			
			
	
	
	public void verifySecondaryLCFopencontainsByXpath(String xpath, String text){
		try{
			
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			
			
			String sText = element.getText();
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value & Secondary LCF has opened:"+text, "PASS");
			}else{
				reportStep("Fail: "+sText+" Did not contain the value & Secondary LCF has not opened:"+text, "FAIL");
			}
		}
		
		//catch (NoSuchElementException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	//	}
		
		//catch (TimeoutException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
			reportStep("The "+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	public void verifyTextRadioBoxType(String id, String text) {
		try{
			

			Thread.sleep(4000);
			
			if (id.contains(text)){
				reportStep("The text: "+text+" contains the value with this :"+id+ " So it allows only single locality", "PASS");
			}else{
				reportStep("The text: "+text+" did not contain the value with this:"+id+" So it allows Multiple locality", "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not  contain " +text+ ".Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not   contain "+text+".Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	

	public void closeAllBrowsers() {
		try {
		driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}

	}
	
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}
	}


	@Override
	public void clickById(String id) {
		try{
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByClassName(String classVal) {
		try{
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByName(String name) {
		try{
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByLink(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	
		

	public void clickByXpath(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}
	
	
	
	
	public void clickByXpathcontactFind(String xpathVal) {
	
			driver.findElement(By.xpath(xpathVal)).click();
			//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		
	}
	public void clickXpathFind(String xpathVal) {
		
		driver.findElement(By.xpath(xpathVal)).click();
		
		
		
		//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
	
}
	
	
	public void closeSecondaryLCFclickByXpathExplcitwait(String xpathVal) {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver,41);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
               element.click();	
			reportStep("The element : "+xpathVal+" is clicked.and secondary LCF has closed", "PASS");
		} 
		
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked Because No such Element Exception has occured.and secondary LCF has closed", "FAIL");
		}
	}
	
	
	
	
	

	@Override
	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS",false);
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}

	}

	@Override
	public void clickByXpathNoSnap(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS",false);
		
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}		
	}

	
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	public void mouseOverByLinkText(String linkName) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		catch (Exception e) {
			reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
	}

public void dropdownSelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
//Thread.sleep(1000);
	
	
	
//clickBylocatorswait(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}



public void dropdowncitySelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(3000);
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}


public List<WebElement> elementListReturn(String xpath1) throws InterruptedException{ 
	List<WebElement>ele = null;
	try{
	ele=driver.findElements(By.xpath(xpath1));
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return ele;
}





public void dropdownSelectionAutoComplete(String xpath1,String xpath2,String xpath3) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(2000);
enterByXpathExplict(xpath2, xpath3);
Thread.sleep(1000);

	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath3+"')]");
	
}

public void dropdownSelectionindex(String xpath1,String xpath2,int i) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(1000);

//(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])
//	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])[10]");
System.out.println(xpath1);
System.out.println(xpath2);
	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')])["+i+"]");


}
		





	public String getTextByXpath(String xpathVal){
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		}
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	
	public void comparevalues(String startbalance,String endbalance,String valmsg,String invalidmsg){
		
		
		
		try{

			//Converting String into int using Integer.parseInt()  
			int initialamount=Integer.parseInt(startbalance);  
			int endamount=Integer.parseInt(endbalance);  
			if(initialamount!=endamount){
				reportStep(valmsg , "PASS");
			}
			else {
				reportStep(invalidmsg , "FAIL");
			}
			
		}
		
		
		
		catch (Exception e) {
			reportStep(invalidmsg, "FAIL");
		}
		 
	}

	
	
	
	
	public int getSizeByXpath(String xpathVal){
		int elesize = 0 ;
		try{
		List<WebElement>ele=driver.findElements(By.xpath(xpathVal));
		elesize=ele.size();
		
		reportStep("element size is "+elesize+"", "PASS");

		}
		
		
		
		catch (Exception e) {
			reportStep("unable to get size", "FAIL");
		}
		return elesize; 
	}
	

	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void selectVisibileTextById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}


	public void selectVisibileTextByXPath(String xpath, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
			reportStep("The element with xpath: "+xpath+" is selected with value :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}
	public void selectIndexByxpath(String element, int value) {
		try{
			new Select(driver.findElement(By.xpath(element))).selectByIndex(value);
			reportStep("The element with id: "+element+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void selectIndexById(String id, int value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);
			reportStep("The element with id: "+id+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void switchToParentWindow() {
		try {
						
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}


	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	
	@Override
	public String getAlertText() {		
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;

	}


	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	

	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			//FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
			
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
			
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "INFO");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "INFO");
		}
		return number;
	}

	
/*		
	
	@Override
	public long takeSnap() {
		//String scrPath="./reports/images";
	//	File file = new File(scrPath);
	  //  file.mkdir();
		
	long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
try
	{
		
   
	        Robot robot = new Robot();
	        Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
	        
	        File outputfile = new File("./reports/images/"+number+".jpg");
//	        File outputfile = new File(scrPath+"/"+number+".png");
	        ImageIO.write(bufferedImage, "png", outputfile);       
	    }
catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} 
catch (IOException e) {
			reportStep("The snapshot could not be taken", "FAIL");
		} catch (AWTException e) {
			reportStep("The snapshot could not be taken", "FAIL");
			}
		return number;
	}


*/

	public void firstwindow(String primarywindow){
		try{
			driver.switchTo().window(primarywindow);

			System.out.println(driver.getTitle());
		}


		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		

		catch(WebDriverException e){
			reportStep("The window could not be switched to the first window.", "FAIL");
		}


	}


	public void lastwindowhandle(){
		try{

			System.out.println(driver.getTitle());


			Set<String> lastWindow = driver.getWindowHandles();
			for (String allWindow : lastWindow) {
				driver.switchTo().window(allWindow);
			}
			System.out.println(driver.getTitle());

		}
		
		
		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}

	

	
	
	public void closeOverLCFwindow(String xpath){
		try{

			driver.findElement(By.xpath(xpath)).click();
			reportStep("The window could not be switched to the last window.", "PASS");

		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}
	public void zip() throws Exception{

	
	  String sourceFolderName =  "D:\\Automation\\LsWeb_Sanity\\reports";
      String outputFileName = "D:\\Automation\\LsWeb_Sanity\\reports\\report.zip";

      FileOutputStream fos = new FileOutputStream(outputFileName);
      ZipOutputStream zos = new ZipOutputStream(fos);
      //level - the compression level (0-9)
      zos.setLevel(9);

      System.out.println("Begin to compress folder : " + sourceFolderName + " to " + outputFileName);
      addFolder(zos, sourceFolderName, sourceFolderName);

      zos.close();
      System.out.println("Program ended successfully!");
  }
	
	public void selectedElementClick(String xpath,String xpathone,String text) throws Exception{

	
List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 41);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	System.out.println(cate);
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(text)){
		
	int j=i+1;
			clickByXpathExplict("("+xpathone+")["+j+"]");
			Thread.sleep(10000);

		}}


	}
	public static void addFolder(ZipOutputStream zos,String folderName,String baseFolderName)throws Exception{
    File f = new File(folderName);
    if(f.exists()){

        if(f.isDirectory()){
            //Thank to peter 
            //For pointing out missing entry for empty folder
            if(!folderName.equalsIgnoreCase(baseFolderName)){
                String entryName = folderName.substring(baseFolderName.length()+1,folderName.length()) + File.separatorChar;
                System.out.println("Adding folder entry " + entryName);
                ZipEntry ze= new ZipEntry(entryName);
                zos.putNextEntry(ze);    
            }
            File f2[] = f.listFiles();
            for(int i=0;i<f2.length;i++){
                addFolder(zos,f2[i].getAbsolutePath(),baseFolderName);    
            }
        }else{
            //add file
            //extract the relative name for entry purpose
            String entryName = folderName.substring(baseFolderName.length()+1,folderName.length());
            System.out.print("Adding file entry " + entryName + "...");
            ZipEntry ze= new ZipEntry(entryName);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(folderName);
            int len;
            byte buffer[] = new byte[1024];
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            System.out.println("OK!");

        }
    }else{
        System.out.println("File or directory not found " + folderName);
    }

    
    
    
}



public void getnewurl(){
	try{
		//uat
	geturl(sUrl);
		reportStep(sUrl, "PASS");
	
	//sit	
	//	geturl("https://uba-api.bracbank.com/ib-retail-web/tenant/index");
	//		reportStep("https://test-astha.bracbank.com/ib-retail-web/tenant/index has passed", "PASS");

			
//		reportStep("https://uba-api.bracbank.com/ib-retail-web/tenant/index has passed", "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}



public void getnewurl(String url){
	try{
		geturl(url);
		reportStep(url, "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}


public void AdminDatelinePageBuzz(String auth1,String auth2,String Datelinekeyword) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 41);
//List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])")));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
System.out.println(cate);
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(Datelinekeyword)){
		//Corporate User Profile Creation Request
int j=i+1;
getrefnumer=ReturnXpathtext("(.//div[contains(@class,'text-right')]//span[contains(@class,'text-info')])["+j+"]");
/*		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");*/
System.out.println("**************ref");	
System.out.println(getrefnumer);
System.out.println("**************ref");

Thread.sleep(10000);
break;
	}

}

/*
clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));

if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}

*/
defaultcontent();

	}
catch (Exception e) {
	reportStep(""+e+"", "FAIL");
}
}








public void CorporateAdminAuthorizeRequest() throws InterruptedException{
try{
	
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 41);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(15000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	System.out.println(cate);
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(8000);
	System.out.println("clicked beneficiary aac no for authorize");	
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(20000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(15000);

			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
//	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='confirm']");
	Thread.sleep(30000);


	break;
	}
		
	}
}
catch (Exception e) {

	reportStep("Unable to find Reference  number", "FAIL");
}



}		




public WebElement fluentwaitsClick(By locator)
{
  Wait wait = new FluentWait(driver)
      .withTimeout(60, TimeUnit.MILLISECONDS)
      .pollingEvery(4, TimeUnit.MILLISECONDS)
      .ignoring(NoSuchElementException.class);
  WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() 
  {

    public WebElement apply(WebDriver driver)
    {
      return driver.findElement(locator);
    }
  });
  return element;
}












}

