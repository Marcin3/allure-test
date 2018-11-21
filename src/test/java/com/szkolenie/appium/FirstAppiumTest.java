package com.szkolenie.appium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szkolenie.appium.framework.ComplexDesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import com.szkolenie.appium.pages.SearchPO;
import io.appium.java_client.remote.MobileCapabilityType;


public class FirstAppiumTest {
	private SearchPO searchPO;
	private DesiredCapabilities desiredCapabilities;
	
	@BeforeMethod
	public void setUp(ITestContext context) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = getAndroidDriver();
		FluentWait wait = getWait(driver);
		context.setAttribute("driver", driver);
		context.setAttribute("wait", wait);
		context.setAttribute("desiredCapabilities", desiredCapabilities);
		searchPO = new SearchPO(context);
	}
	
	@DataProvider(name = "imiona")
	public Object[][] createData1() {
		return new Object[][]{
				{"Cedric"},
				{"Anne"},
		};
	}
	
	@Test(dataProvider = "imiona")
	public void verifyData1(String n1) {
		searchPO.searchInStore(n1);
		Assert.assertEquals(searchPO.getTextFromSearchField(), n1);
	}
	
	@Test
	public void firstString() {
		searchPO.searchInStore("Supertext XPATH ");
		Assert.assertEquals(searchPO.getTextFromSearchField(), "Supertext XPATH ");
	}
	
	@Test
	public void firstId() {
		searchPO.searchInStore("SupertextId");
		Assert.assertEquals(searchPO.getTextFromSearchField(), "SupertextId");
	}
	
	private AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("./src/test/resources/capabilities.json"));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ComplexDesiredCapabilities complexDesiredCapabilities = gson.fromJson(bufferedReader, ComplexDesiredCapabilities.class);
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, complexDesiredCapabilities.getVersion());
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, complexDesiredCapabilities.getDeviceName());
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, complexDesiredCapabilities.getUdid());
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, complexDesiredCapabilities.getPlatformName());
		desiredCapabilities.setCapability("appPackage", complexDesiredCapabilities.getAppPackage());
		desiredCapabilities.setCapability("appActivity", complexDesiredCapabilities.getAppActivity());
		desiredCapabilities.setCapability("autoGrantPermissions", complexDesiredCapabilities.getAutoGrantPermissions());
		
		return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), desiredCapabilities);
	}
	
	private FluentWait<WebDriver> getWait(final AndroidDriver driver) {
		return new WebDriverWait(driver, 20)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NullPointerException.class)
				.ignoring(ClassCastException.class)
				.ignoring(NoSuchElementException.class);
	}
	
}
