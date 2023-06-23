package com.mt.simpleAppium.gestures;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollGesture {
	
	@Test
	public void scrollGestureTest() throws Throwable {

		
		File f=new File("C:\\Users\\sagar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(3000)).build();
		service.start();
		
		
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
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
//		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId(),
//			    "duration", 2000
//			));
		boolean canScrollMore;
		
		do{
			
			canScrollMore =(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 525, "top", 364, "width", 525, "height", 1700,
			    "direction", "down",
			    "percent", 1.0
			));
		}
			
			
			while(canScrollMore);
		

		
//		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 525, "top", 364, "width", 525, "height", 1900,
//			    "direction", "down",
//			    "percent", 1.0
//			));
//		
//		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 525, "top", 364, "width", 525, "height", 1900,
//			    "direction", "up",
//			    "percent", 1.0
//			));
//		
//		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 525, "top", 364, "width", 525, "height", 1900,
//			    "direction", "up",
//			    "percent", 1.0
//			));
		
		
		service.close();
		
		
		
	}

}
