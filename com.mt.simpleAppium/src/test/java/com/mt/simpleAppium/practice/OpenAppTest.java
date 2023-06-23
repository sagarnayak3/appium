package com.mt.simpleAppium.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenAppTest {
	@Test
	public void openAppTest() throws Throwable
	{
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 API 33");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL u=new URL("http://localhost:4723");
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(AppiumBy.accessibilityId("Content")).click();
		driver.findElement(AppiumBy.accessibilityId("Storage")).click();
		
	
	}

}
