package com.sgtesting.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithOutWebElementDemo1 {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		withWebElementsApproach();
		
	}
	
	static void launchBrowser()
	{
		try
		{	
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.navigate().to("http://localhost/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void withWebElementsApproach()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("DemoUser1");
			Thread.sleep(1000);
			oBrowser.findElement(By.id("username")).clear();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("username")).sendKeys("DemoUser2");
			Thread.sleep(1000);
			oBrowser.findElement(By.id("username")).clear();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("username")).sendKeys("DemoUser3");
			Thread.sleep(1000);
			String attrVal=oBrowser.findElement(By.id("username")).getAttribute("value");
			System.out.println("Attribute Value :"+attrVal);
			Thread.sleep(1000);
			oBrowser.findElement(By.id("username")).clear();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
