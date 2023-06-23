package com.GenaralStore.GenericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtility {
	
	AndroidDriver driver;
	
	/**
	 * constructor to load the android driver to the class
	 * @param driver
	 */
	public DriverUtility(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	
	/**
	 * this method helps to install the particular app on android device by passing the .apk file path
	 * @param Path
	 */
	public void appInstallation(String Path)
	{
		driver.installApp(Path);
	}
	
	
	/**
	 * this method helps to validate whether the app is installed in system or not by passing the app package name . return type is boolean
	 * @param Package
	 */
	public void validateTheAppExistance(String Package)
	{
		System.out.print(driver.isAppInstalled(Package));
	
	}
	
	/**
	 * this method helps to uninstall  the particular app on android device by passing the app package name
	 * @param Package
	 */
	public void uninstallTheApp(String Package)
	{
		driver.removeApp(Package);
	}
	
	
	/**
	 * this method helps to run the  particular app on android device in background for particular period of seconds , we have to pass seconds , eg 30
	 * @param seconds
	 */
	public void runAppInTheBackground(int seconds)
	{
		driver.runAppInBackground(Duration.ofSeconds(seconds));
	}
	
	/**
	 *  this method helps to validate whether the app is running in background or not by passing the app package name, return type is boolean
	 * @param Package
	 */
	public void validateTheAppRunningInBackground(String Package)
	{
		System.out.print(driver.queryAppState(Package));
	}
	
	/**
	 * this method helps to change orientation of the app to landscape.
	 */
	public void changeOrientationToLandscape()
	{
		ScreenOrientation s=driver.getOrientation();
		driver.rotate(s.LANDSCAPE);
	}
	
	/**
	 * this method helps to change orientation of the app to portrait.
	 */
	public void changeOrientationToPortrait()
	{
		ScreenOrientation s=driver.getOrientation();
		driver.rotate(s.PORTRAIT);
	}
	
	/**
	 * this method helps to open the notifications panel of the android device
	 */
	public void openNotifications()
	{
		driver.openNotifications();
	}
	
	/**
	 * this method helps to hide keyboard of the android device
	 */
	public void hideKeyBoard()
	{
		driver.hideKeyboard();
	}
	
	/**
	 * Get the names of available contexts.
	 */
	public void getCotextHandles()
	{
		Set<String> context = driver.getContextHandles();
		for(String s:context)
		{
			System.out.print(s);
		}
	}
	
	/**
	 * this method helps to switch the context in the app.
	 * @param context
	 */
	public void switchToContext(String context)
	{
		driver.context(context);
	}
	
	
}
