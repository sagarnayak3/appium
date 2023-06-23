package com.GenaralStore.TestScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.GenaralStore.GenericUtilities.BaseClass;
import com.GenaralStore.GenericUtilities.GestureUtility;
import com.GenaralStore.ObjectRepository.LoginPage;
import com.google.common.util.concurrent.Service;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GeneralStoreLoginTest extends BaseClass{
	
	@Test
	public void generalStoreLoginTest() throws Throwable {
		
		loginPage.loginAsIndianUser("India","Sagar",gestureUtility);
		
		//driver.findElement(AppiumBy.accessibilityId(""));
		
	//	Service.close();
		
	}

}
