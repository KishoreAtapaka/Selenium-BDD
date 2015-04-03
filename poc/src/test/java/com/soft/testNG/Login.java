package com.soft.testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;  

	public enum cross{

		FIREFOX, CHROME, DEFAULT
	}

	@Test(dataProvider="LoginData", dataProviderClass=TestData.class)
	public void login(String un,String pw,String br){

		cross browser=cross.valueOf(br.toUpperCase());

		switch(browser){

		case CHROME:
			System.setProperty("webdriver.chrome.driver","./util/chromedriver.exe");
			driver=new ChromeDriver();
			break;

		case FIREFOX:			
			driver=new FirefoxDriver();
			break;	

		case DEFAULT:			
			driver=new FirefoxDriver();
			break;	
		}
		driver.get("http://cashkaro.com");
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("SIGN IN")).click();
		WebElement frame=driver.findElement(By.xpath("//*[@id='cboxLoadedContent']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("uname")).sendKeys(un);	  
		driver.findElement(By.id("pwd-txt")).click();
		driver.findElement(By.id("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//input[contains(@value,'Sign in')]")).click();	  
		driver.findElement(By.linkText("LOGOUT")).click();
		System.out.println("Login successful");
		driver.close();
	}   
	@AfterClass
	public void shutBrowser(){
		driver.quit();
	}

}