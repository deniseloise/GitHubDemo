package com.pages;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	@Parameters({"guru99Url"})
	public void setup(@Optional("Abc") String guru99Url) {

		if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			driver = new ChromeDriver();

		} else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			driver = new FirefoxDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().clearResolutionCache().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(guru99Url);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
