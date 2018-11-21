package com.szkolenie.appium;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("All framework testing tol")
@Feature("Feature tag szkoleniea Appium")
public class SecondAppiumTest {
	
	@Test(groups = {"smoke", "regresion"})
	@Story("This is story for first test")
	@Description("Description for first test")
	public void firstName() {
	}
	
	@Test(groups = "regresion")
	@Story("This is story for second test")
	@Description("Description for second test")
	public void secondName() {
	}
}
