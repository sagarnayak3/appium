package com.GenaralStore.TestScripts;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenaralStore.GenericUtilities.BaseClass;
import com.GenaralStore.GenericUtilities.DriverUtility;
import com.GenaralStore.GenericUtilities.GestureUtility;
import com.GenaralStore.ObjectRepository.CartPage;
import com.GenaralStore.ObjectRepository.LoginPage;
import com.GenaralStore.ObjectRepository.ProductPage;
import com.GenaralStore.ObjectRepository.WebViewPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AddToCartTest  extends BaseClass {
	
	@Test
	public void addToCartTest() throws Throwable {

		
		loginPage.loginAsIndianUser("India","Sagar",gestureUtility);
		String actual=productPage.getProductName();
		System.out.println(actual);
		productPage.addToCart("Air Jordan 1 Mid SE");
		
		Thread.sleep(3000);
		String expected=cartPage.getProductTitleInCart();
		Assert.assertEquals(actual, expected);
		Reporter.log("Test passed",true);
			
		cartPage.checkout();
		Reporter.log("Test passed",true);
		DriverUtility du= new DriverUtility(driver);
		du.getCotextHandles();
		Thread.sleep(3000);
		du.switchToContext("WEBVIEW_com.androidsample.generalstore");
		webViewPage.vebwiewPage(expected);
		du.switchToContext("NATIVE_APP");
		driver.navigate().back();
		
		
		
	}

}
