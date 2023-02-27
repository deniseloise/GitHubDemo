package com.pages;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().clearResolutionCache().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
