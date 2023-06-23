package com.GenaralStore.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage {
	AndroidDriver driver;
	@FindBy(id="com.androidsample.generalstore:id/productName")private WebElement ProductNameInCart;
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")private WebElement CheckOutButton;
	
	public CartPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameInCart() {
		return ProductNameInCart;
	}
	
	public void checkout()
	{
		CheckOutButton.click();
	}
	public String getProductTitleInCart()
	{
		String name=ProductNameInCart.getText();
		return name;
	}
	
	

	

}
