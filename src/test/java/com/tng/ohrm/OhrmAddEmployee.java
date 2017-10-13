package com.tng.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wd.basics.DriverFactory;


public class OhrmAddEmployee {
	WebDriver driver ;
	@BeforeClass
	public void OpenApplication() {
		//open new chrome window
		driver = DriverFactory.getDriver("chrome");
		
		//specify page load
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//specify element wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//maximize window
		driver.manage().window().maximize();
		
		//goto orange hrm login page
		driver.get("http://opensource.demo.orangehrmlive.com");
	}
	
	@Test
	public void Login() {
		//enter text on username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		
		//enter text on password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");
		
		//click on login button
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
	}
	
	@Test(dependsOnMethods="Login")
	public void AddEmployee() {
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

	}
	
	@AfterClass
	public void closeApplication() {
		driver.quit();
	}
}










