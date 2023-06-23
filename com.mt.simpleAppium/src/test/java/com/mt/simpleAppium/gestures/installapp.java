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
import io.appium.java_client.service.local.flags.ServerArgument;

public class installapp {
	
	@Test
	public void installapptest() throws Throwable {
		

//		File f=new File("C:\\Users\\sagar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
//		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(3000)).build();
//		service.start();
		
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "sowmya's Honor 9 Lite");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"9SF3Y18220006174");
		//dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\sagar\\Desktop\\testyantra\\sowmya sir\\com.davemorrissey.labs.subscaleview.sample.apk");
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		
		URL u=new URL("http://localhost:4723");
		AndroidDriver driver=new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		WebElement element = driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		
		//pinch open
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 1.00
			));
		
		Thread.sleep(3000);
		//pinch close
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 1.00
			));
		
//		service.close();
		
		
	}

}
