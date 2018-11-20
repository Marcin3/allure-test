package com.szkolenie.appium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import utils.WebElementUtils;

public class SearchPO {
	private final static By SEARCH_ICON = By.id("com.android.vending:id/search_box_idle_text");
	private final static By SEARCH_FIELD = By.id("com.android.vending:id/search_box_text_input");
	private final static By SEARCH_RESULT = By.id("com.android.vending:id/search_box_active_text_view");
	
	private final WebElementUtils utils;
	private final AndroidDriver<AndroidElement> driver;
	
	public SearchPO(ITestContext context) {
		this.driver = (AndroidDriver<AndroidElement>) context.getAttribute("driver");
		FluentWait<WebDriver> wait = (FluentWait<WebDriver>) context.getAttribute("wait");
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		utils = new WebElementUtils(wait);
	}
	
	public SearchPO searchInStore(final String apkToFind) {
		utils.clickElement(SEARCH_ICON);
		utils.setText(SEARCH_FIELD, apkToFind);
		driver.pressKeyCode(66);
		return this;
	}
	
	public String getTextFromSearchField() {
		return utils.getText(SEARCH_RESULT);
	}
	
}
