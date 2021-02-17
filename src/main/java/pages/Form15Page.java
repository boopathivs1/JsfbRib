package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Form15Page  extends ProjectWrapp{
	public  Form15Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

		
	
	public Form15Page ClickDownloadForm() throws InterruptedException{
		
		   clickByXpathExplict(prop.getProperty("click.download.form15.xpath"));

			return this;
		}
		
	
	public Form15Page DownloadForm(String Years) throws InterruptedException{
		
		   clickByXpathExplict("//div[@class='ui dropdown selection']");
		   
		   clickByXpathExplict("//div[.='"+Years+"']");
		   
		   clickByXpathExplict(prop.getProperty("click.pdf.download"));

			return this;
		}
	
	}
