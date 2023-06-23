package com.mt.drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallTheApp {
	
	@Test
	
	public void installTheApp() throws Throwable {
		
		
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 API 33");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "sowmya's Honor 9 Lite");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//		dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		dc.setCapability(MobileCapabilityType.UDID,"9SF3Y18220006174");
//		dc.setCapability("appPackage", "com.androidsample.generalstore");
//		dc.setCapability("appActivity", ".SplashActivity");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL u=new URL("http://localhost:4723");
		
		AndroidDriver driver=new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		// install app and uninstall
//		driver.installApp("C:\\Users\\sagar\\Desktop\\testyantra\\sowmya sir\\General-Store.apk");
//		System.out.print(driver.isAppInstalled("com.androidsample.generalstore"));
		//driver.removeApp("com.androidsample.generalstore");
		
		//runn app in the background
//		driver.runAppInBackground(Duration.ofSeconds(30));
//		System.out.print(driver.queryAppState("com.androidsample.generalstore"));
		
		//orientation of the screen
		Thread.sleep(5000);
		
		ScreenOrientation s=driver.getOrientation();
		driver.rotate(s.LANDSCAPE);
		
		Thread.sleep(3000);
		driver.rotate(s.PORTRAIT);
		
		driver.openNotifications();
		
		
		
	}

}
