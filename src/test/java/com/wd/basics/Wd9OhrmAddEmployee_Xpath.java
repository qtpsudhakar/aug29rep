package com.wd.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Wd9OhrmAddEmployee_Xpath {

	public static void main(String[] args) {
		
		//open new chrome window
		WebDriver driver = DriverFactory.getDriver("chrome");
		
		//specify page load
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//specify element wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//maximize window
		driver.manage().window().maximize();
		
		//goto orange hrm login page
		driver.get("http://opensource.demo.orangehrmlive.com");
		
		//enter text on username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		
		//enter text on password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		
		//click on login button
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//click on PIM link
		driver.findElement(By.xpath("//a[.='PIM']")).click();
		
		//click on add employee link
		driver.findElement(By.xpath("//a[contains(text(),'Add Emp')]")).click();
		
		//enter text on first name
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("selenium");
		
		//enter text on last name
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("hq");
				
		//click on save button
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		//close browser
		driver.quit();
	}

}












