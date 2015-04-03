package com.soft.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {

	/**
	 * @param args
	 */
	@Test
	public void explicitWait(){
		System.setProperty("webdriver.chrome.driver","./util/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://cashkaro.com");
		driver.manage().window().maximize();	
		WebDriverWait wait=new WebDriverWait(driver,30);		  
		driver.findElement(By.linkText("SIGN IN")).click();
		//explicit wait		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cboxLoadedContent']/iframe")));
		WebElement frame=driver.findElement(By.xpath("//*[@id='cboxLoadedContent']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("uname")).sendKeys("test2.test@test.com");	  
		driver.findElement(By.id("pwd-txt")).click();
		driver.findElement(By.id("pwd")).sendKeys("password");
		driver.findElement(By.xpath("//input[contains(@value,'Sign in')]")).click();
		//explicit wait		  
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login_msg"))));		  
		if(driver.findElement(By.id("login_msg")).getText().contains("Invalid Username or Password"))
			System.out.println("Unable to login due to invalid credentials");
		driver.close();

	}


}
