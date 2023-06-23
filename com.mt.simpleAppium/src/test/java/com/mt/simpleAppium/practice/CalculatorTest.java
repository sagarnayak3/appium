package com.mt.simpleAppium.practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CalculatorTest {
	@Test
	
	public void AddTwoNumbersUsingTheCalculator() throws Throwable {
		File f=new File("C:\\Users\\sagar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(3000)).build();
		service.start();
		
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 API 33");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		dc.setCapability("appPackage", "com.google.android.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL u=new URL("http://localhost:4723");
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement n1=driver.findElement(AppiumBy.accessibilityId("5"));
		System.out.print(n1.getText());
		Thread.sleep(3000);
		n1.click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		WebElement n2=driver.findElement(AppiumBy.accessibilityId("8"));
		String k=n2.getText();
		n2.click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		WebElement result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
		
		System.out.print(result.getText());
		
		service.close();
		
		
		
	}

}
