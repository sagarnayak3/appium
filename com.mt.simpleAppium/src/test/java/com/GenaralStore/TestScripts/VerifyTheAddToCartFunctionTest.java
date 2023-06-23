package com.GenaralStore.TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenaralStore.GenericUtilities.BaseClass;
import com.GenaralStore.GenericUtilities.GestureUtility;
import com.GenaralStore.ObjectRepository.CartPage;
import com.GenaralStore.ObjectRepository.LoginPage;
import com.GenaralStore.ObjectRepository.ProductPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VerifyTheAddToCartFunctionTest extends BaseClass{
	
	@Test
	public void verifyTheAddToCartFunctionTest() throws Throwable 
	{
		
		
		loginPage.loginAsIndianUser("India","Sagar",gestureUtility);
		String actual=productPage.getProductName();
		System.out.println(actual);
		productPage.addToCart("Air Jordan 1 Mid SE");
		
		Thread.sleep(3000);
		String expected=cartPage.getProductTitleInCart();
		Assert.assertEquals(actual, expected);
		Reporter.log("Test passed",true);
			
		
		
	}

}
