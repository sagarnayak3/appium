package com.GenaralStore.GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {
	
	 AndroidDriver driver;
	/**
	 * This method helps to scroll till particular text on the page
	 * @param value
	 */
	 
	 public GestureUtility(AndroidDriver driver){
		 this.driver=driver;
	 }
	 
	 
	public void scrollingGesture(String value) {
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
		
	}
	
	/**
	 * This method helps to long click on particular webelement.
	 * @param driver
	 * @param element
	 */
	public void longClickGesture(AndroidDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	
	
	/**
	 * This method helps us to click the particular element using JavascriptExecutor
	 * @param driver
	 * @param element
	 */
	public void clickGesture(AndroidDriver driver,WebElement element)
	{
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	}
	
	/**
	 * This method helps to drag and drop particular webelement to defined x y cordinates using  JavascriptExecutor
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void dragAndDropGesture(AndroidDriver driver,WebElement element,int x,int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	
	/**
	 * This method helps to drag and drop particular item on webpage from x y cordinate to defined end x y cordinates using  JavascriptExecutor
	 * @param driver
	 * @param element
	 * @param startx
	 * @param starty
	 * @param x
	 * @param y
	 */
	public void dragAndDropUsingCordinatesGesture(AndroidDriver driver,WebElement element,int startx,int starty,int x,int y) {
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "startX",startx,
				    "startY",starty,
				    "endX", x,
				    "endY", y
				));	
		
	}
	
	/**
	 * This method helps to pinch and zoom particular webElement using JavascriptExecutor
	 * @param driver
	 * @param element
	 */
	public void pinchOpenGesture(AndroidDriver driver,WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
		
	}
	
	/**
	 * This method helps to pinch and zoomout already zoomed in  particular webElement using JavascriptExecutor
	 * @param driver
	 * @param element
	 */
	public void pinchCloseGesture(AndroidDriver driver,WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "percent", 0.75
			));
	}
	
	/**
	 * This method will help us to swipe left on webpage using JavascriptExecutor
	 * @param driver
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void swipeToLeftGesture(AndroidDriver driver,int left,int top,int width, int height)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", "left",
			    "percent", 0.75
			));
		
		
	}
	
	/**
	 *  This method will help us to swipe right on webpage using JavascriptExecutor
	 * @param driver
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void swipeToRightGesture(AndroidDriver driver,int left,int top,int width, int height)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", "right",
			    "percent", 0.75
			));
		
		
	}
	
	/**
	 * This method will help us to scroll down on appPage using JavascriptExecutor
	 * @param driver
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void scrollDownGesture(AndroidDriver driver,int left,int top,int width, int height)
	{
		 ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", left, "top", top, "width", width, "height", height,
			    "direction", "down",
			    "percent", 1.0
			));
	}
	
	
	/**
	 * This method will help us to scroll up on apppage using JavascriptExecutor
	 * @param driver
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void scrollUpGesture(AndroidDriver driver,int left,int top,int width, int height)
	{
		 ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", left, "top", top, "width", width, "height", height,
			    "direction", "up",
			    "percent", 1.0
			));
	} 
	
	
	/**
	 * This method will scroll till the end of the page designed using do while loop with help of JavascriptExecutor
	 * @param driver
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 */
	public void scrollTillTheEndOfThePage(AndroidDriver driver,int left,int top,int width, int height) {
		
		
		boolean canScrollMore;
		
		do{
			
			canScrollMore =(Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", left, "top", top, "width", width, "height", height,
			    "direction", "down",
			    "percent", 1.0
			));
		}
			
			
			while(canScrollMore);
	}
	
	
	
	

}
