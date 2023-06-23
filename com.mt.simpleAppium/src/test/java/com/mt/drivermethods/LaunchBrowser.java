package com.mt.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchBrowser {
	
	@Test

	public void launchBrowser() throws Throwable {
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "honor");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.UDID,"9SF3Y18220006174");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//dc.setCapability("chromedriverExecutables","C:\\Users\\sagar\\Desktop\\testyantra\\sowmya sir\\chromedriver.exe");
		
		URL u=new URL("http://localhost:4723");
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://facebook.com");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("6360423459");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ggggg");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
	}
}
