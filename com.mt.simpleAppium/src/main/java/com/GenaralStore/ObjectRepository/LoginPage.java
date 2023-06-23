package com.GenaralStore.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenaralStore.GenericUtilities.GestureUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	AndroidDriver driver;
	@FindBy(xpath="//android.widget.TextView[@text='India']") 
	private WebElement IndiaDDButton;
	@FindBy(id="com.androidsample.generalstore:id/nameField")private WebElement NameFieldTB;
	@FindBy(id="com.androidsample.generalstore:id/radioMale")private WebElement GenderRButton;
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")private WebElement SubmitButton;
	@FindBy(id="android:id/text1")private WebElement NextButton;
//	@FindBy()private WebElement ;
//	
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getIndiaDDButton() {
		return IndiaDDButton;
	}

	public WebElement getNameFieldTB() {
		return NameFieldTB;
	}

	public WebElement getGenderRButton() {
		return GenderRButton;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	
	public void loginAsIndianUser(String country,String name,GestureUtility gestureUtility) {
		NextButton.click();
		gestureUtility.scrollingGesture(country);
		IndiaDDButton.click();
		NameFieldTB.sendKeys(name);
		GenderRButton.click();
		SubmitButton.click();
		
	}
}
