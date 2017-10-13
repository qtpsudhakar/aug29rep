package com.wd.basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	public static WebDriver getDriver(String brName) {
		WebDriver driver;

		switch (brName.toLowerCase()) {
		case "chrome":
			// specify browser driver exe file
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

			// open new chrome window
			driver = new ChromeDriver();
			break;
		case "firefox":
			// specify browser driver exe file
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");

			// open new chrome window
			driver = new FirefoxDriver();
			break;
		case "ie":
			// specify browser driver exe file
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\iedriverserver.exe");

			// open new chrome window
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			// specify browser driver exe file
			System.setProperty("webdriver.edge.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\MicrosoftWebDriver.exe");

			// open new chrome window
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			System.out.println("no valid browser");
		}

		return driver;
	}

	public static WebDriver getRemoteDriver(String brName,String OS) throws MalformedURLException {
		WebDriver driver = null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(brName);
		
		switch (OS.toLowerCase()) {
		case "mac":
			// open new chrome window
			cap.setPlatform(Platform.MAC);
			break;
		case "win10":
			cap.setPlatform(Platform.WIN10);
			break;
		default:
			driver = null;
			System.out.println("no valid browser");
		}
		
		driver = new RemoteWebDriver(new URL( "http://192.168.238.1:4444/wd/hub/"),cap);
		return driver;
	}

}









