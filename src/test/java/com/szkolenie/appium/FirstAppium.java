package com.szkolenie.appium;

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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;
import com.szkolenie.appium.pages.SearchPO;


public class FirstAppium {
	private SearchPO searchPO;
	
	@BeforeMethod
	public void setUp(ITestContext context) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = getAndroidDriver();
		FluentWait wait = getWait(driver);
		context.setAttribute("driver", driver);
		context.setAttribute("wait", wait);
		searchPO = new SearchPO(context);
	}

	@DataProvider(name = "imiona")
	public Object[][] createData1() {
		return new Object[][] {
				{ "Cedric"},
				{ "Anne"},
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
		final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "5.1.1");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiomi");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "68a0e62f");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability("appPackage", "com.android.vending");
		desiredCapabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		
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
