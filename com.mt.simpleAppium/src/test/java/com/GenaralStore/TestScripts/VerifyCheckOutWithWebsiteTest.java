package com.GenaralStore.TestScripts;


import static org.junit.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.GenaralStore.GenericUtilities.BaseClass;
@Listeners(com.GenaralStore.GenericUtilities.ListenerImp.class)
public class VerifyCheckOutWithWebsiteTest extends BaseClass {
	@Test
	
	public void verifyCheckOutWithWebsiteTest ()throws Throwable {
	
		
		loginPage.loginAsIndianUser("India","Sagar",gestureUtility);
		String actual=productPage.getProductName();
		System.out.println(actual);
		Assert.fail();
		productPage.addToCart("Air Jordan 1 Mid SE");		
		Thread.sleep(3000);
		String expected=cartPage.getProductTitleInCart();
		Assert.assertEquals(actual, expected);
		cartPage.checkout();
		Reporter.log("Test passed",true);
		
		
		
		
		
	}

}
