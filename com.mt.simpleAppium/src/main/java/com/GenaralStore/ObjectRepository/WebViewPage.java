package com.GenaralStore.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class WebViewPage {
	AndroidDriver driver;
	
	@FindBy(xpath="//input[@name='q']")private WebElement SearchButton;
	
	
	public WebViewPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void vebwiewPage(String keys)
	{
		SearchButton.sendKeys(keys);
		SearchButton.submit();
	}
}
