package com.GenaralStore.GenericUtilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.GenaralStore.ObjectRepository.CartPage;
import com.GenaralStore.ObjectRepository.LoginPage;
import com.GenaralStore.ObjectRepository.ProductPage;
import com.GenaralStore.ObjectRepository.WebViewPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AppiumDriverLocalService service;
	public DesiredCapabilities dc;
	public static AndroidDriver driver1;
	public AndroidDriver driver;
	public DriverUtility driverUtility;
	public FileUtility fileUtility=new FileUtility();
	public GestureUtility gestureUtility;
	public CartPage cartPage;
	public LoginPage loginPage;
	public ProductPage productPage;
	public WebViewPage webViewPage;
	
	
	
	@BeforeSuite
	public void OpenServer()
	{
		File f=new File("C:\\Users\\sagar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(3000)).build();
		service.start();
	}
	
	@BeforeMethod
	public void startTheApp() throws Throwable
	{
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, fileUtility.getPropertyData("PLATFORM_NAME"));
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, fileUtility.getPropertyData("DEVICE_NAME"));
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,fileUtility.getPropertyData("AUTOMATION_NAME"));
		dc.setCapability(MobileCapabilityType.UDID,fileUtility.getPropertyData("UDID"));
		dc.setCapability("appPackage", fileUtility.getPropertyData("appPackage"));
		dc.setCapability("appActivity", fileUtility.getPropertyData("appActivity"));
		
		URL u=new URL(fileUtility.getPropertyData("url"));
		
		driver=new AndroidDriver(u,dc);
		driverUtility=new DriverUtility(driver);
		gestureUtility=new GestureUtility(driver);
		webViewPage=new WebViewPage(driver);
		cartPage=new CartPage(driver);
		loginPage=new LoginPage(driver);
		productPage=new ProductPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver1=driver;
		
	}
	
	@AfterMethod
	public void closeTheApp() {
		driver.quit();
	}
	
	@AfterSuite
	public void closeTheServer()
	{
		service.close();
	}

}
