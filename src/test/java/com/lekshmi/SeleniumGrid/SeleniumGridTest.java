package com.lekshmi.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridTest {

	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeMethod
	public void setup() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(cap);

		try {
			driver.set(new RemoteWebDriver(new URL("http://192.168.0.17:4444"), chromeOptions));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test1() {
		driver.get().get("https://github.com/");
		Assert.assertEquals("GitHub: Let’s build from here · GitHub", driver.get().getTitle());
	}

	@Test
	public void test2() {
		driver.get().get("https://www.google.com/");
		Assert.assertEquals("Google", driver.get().getTitle());
	}

	@Test
	public void test3() {
		driver.get().get("https://www.amazon.ca/");
		Assert.assertEquals("Amazon.ca: Low Prices – Fast Shipping – Millions of Items", driver.get().getTitle());
	}

	@Test
	public void test4() {
		driver.get().get("https://stackoverflow.com/");
		Assert.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", driver.get().getTitle());
	}

	@Test
	public void test5() {
		driver.get().get("https://www.selenium.dev/");
		Assert.assertEquals("Selenium", driver.get().getTitle(), "Incorrect Title");
	}
	@Test
	public void test6() {
		driver.get().get("https://www.guru99.com/");
		Assert.assertEquals("Meet Guru99 – Free Training Tutorials & Video for IT Courses", driver.get().getTitle());
	}

	@Test
	public void test7() {
		driver.get().get("https://aws.amazon.com/");
		Assert.assertEquals("Cloud Computing Services - Amazon Web Services (AWS)", driver.get().getTitle());
	}

	@Test
	public void test8() {
		driver.get().get("https://www.walmart.ca/en");
		Assert.assertEquals("Online Shopping Canada: Everyday Low Prices at Walmart.ca!", driver.get().getTitle());
	}

	@Test
	public void test9() {
		driver.get().get("https://www.bestbuy.ca/en-ca");
		Assert.assertEquals("Best Buy: Shop Online For Deals & Save | Best Buy Canada", driver.get().getTitle());
	}

	@Test
	public void test10() {
		driver.get().get("https://demoqa.com/");
		Assert.assertEquals("ToolsQA", driver.get().getTitle(), "Incorrect Title");
	}


	@AfterMethod
	public void teardown() {
		driver.get().quit();
	}
}
