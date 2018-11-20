package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.MobileElement;

public class WebElementUtils {
	private FluentWait wait;
	
	public WebElementUtils(final FluentWait wait) {
		this.wait = wait;
	}
	
	public String getText(final By by){
		final WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.getText();
	}
	
	public void setText(final By by, final String text) {
		final WebElement elementInput = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		elementInput.sendKeys(text);
	}
	
	public void clickElement(final By SEARCH_ICON) {
		final MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ICON));
		element.click();
	}
}
