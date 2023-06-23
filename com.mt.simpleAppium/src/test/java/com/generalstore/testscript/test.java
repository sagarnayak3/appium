package com.generalstore.testscript;

import org.testng.annotations.Test;

import com.GenaralStore.GenericUtilities.FileUtility;

public class test{

	@Test
	public void test() throws Throwable
	{
		FileUtility fileUtility=new FileUtility();
		System.out.println(fileUtility.getDataFromJson("url"));
	}
}
