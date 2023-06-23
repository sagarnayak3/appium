package com.GenaralStore.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	AndroidDriver driver;
	@FindBy(xpath="//android.widget.TextView[@text='Air Jordan 1 Mid SE']")private WebElement ProductTitle;
	@FindBy(xpath="//android.widget.TextView[@text='Air Jordan 1 Mid SE']/../..//*[@text='ADD TO CART']")private WebElement AddProductToCartButton;
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")private WebElement CartButton;
//	@FindBy()private WebElement ;
//	@FindBy()private WebElement ;
	
	public ProductPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductTitle() {
		return ProductTitle;
	}

	public WebElement getAddProductToCartButton() {
		return AddProductToCartButton;
	}

	public WebElement getCartButton() {
		return CartButton;
	}
	
	public void addToCart(String Productname)throws Throwable	{
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+Productname+"']/../..//*[@text='ADD TO CART']")).click();
	
		CartButton.click();
	}
	
	public String getProductName()
	{
		String name=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']")).getText();
		return name;
	}

}
