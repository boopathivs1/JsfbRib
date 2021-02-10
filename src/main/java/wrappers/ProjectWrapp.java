package wrappers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DataInputProvider;
import utils.Dataproviders;

public class ProjectWrapp extends GenericWrappers{

	public static String AccountBalance;
	public static final String USERNAME = "automationtesting@vayana.in";
	 public static final String AUTOMATE_KEY = "ip9DgQrFVYNDS6g7AzAp";
//	 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	public static String logid=null;
	public static String logpwd=null; 
	
	
	public String dataSheet="Brac";
	
	 
	 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	 
	 //browerstack

	
	public String browserName;
	public String dataSheetName;

	@BeforeSuite(groups={"common"})
	public void beforeSuite() throws IOException{
		//del();
		String os = System.getProperty("os.name").toLowerCase();
System.out.println("os ********************");
		System.out.println(os);
		System.out.println("os ********************");
		startResult();
	}

	
    
	
	@BeforeTest(groups={"common"})
	public void beforeTest(){
		loadObjects();
	}
/*
@Parameters({"Browser"})
@BeforeMethod(groups={"common"})
public void beforeMethods(String Browser) throws IOException{
	test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(Browser);
	
	}	
*/
	
	
	
	

	 
	 
		@BeforeMethod(groups={"common"})
	public void beforeMethods() throws IOException{
			test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(browserName);
		System.out.println("************");
//		  JavascriptExecutor js = (JavascriptExecutor)driver;
//String a=js.executeScript("return document.readyState").toString();
//System.out.println(a);
//System.out.println("***********");

		}
	
		
	@AfterSuite(groups={"common"})
	public void afterSuite() throws Exception{

		endResult();
	
		//zip();
	}

	@AfterTest(groups={"common"})
	public void afterTest(){
		unloadObjects();
	}
	
	
/*	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
try{
		defaultcontent();
logout(LogoutStatus,usertype);	
		endTestcase();
//	closeAllBrowsers();
	closeBrowser();
	reportStep("Application has logged out Successfully", "PASS");

	
}
catch (Exception e) {
	reportStep("Application has not logged out Successfully", "FAIL");

	// TODO: handle exception
}

	
	
	}
	*/
	
	
	
	
	
	
	
	
	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
		endTestcase();
	closeAllBrowsers();

	
	
	}

	
	
	
	

	
	
	
	
	@DataProvider(name="fetch")
	public Object[][] getDataExcel() throws IOException{
		return Dataproviders.geta("./data/"+dataSheet+".xlsx",testKeyword);		
	}	
	
public void logout() throws InterruptedException{
	loadtime();
//	Thread.sleep(4000);

	defaultcontent();
	loadtime();
//	pageScrollup();
	
	//window.scrollTo(0,document.body.scrollHeight)
	//scrolltoelementJs(prop.getProperty("click.dashboard.icon.xpath"));	
	//Scrollup();
//	Thread.sleep(4000);
clickByXpathExplict(prop.getProperty("click.dashboard.icon.xpath"));
	//Thread.sleep(5000);
	loadtime();
	clickByXpathExplict(prop.getProperty("click.dashboard.icon.xpath"));
	
loadtime();
//	defaultcontent();
	//Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.logout.button.xpath"));
	loadtime();
//	clickByXpathExplict(prop.getProperty("click.logout.button.xpath"));

	//Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("click.confirm.logout.button.xpath"));	
	
	Thread.sleep(3000);


}
	

	
	}