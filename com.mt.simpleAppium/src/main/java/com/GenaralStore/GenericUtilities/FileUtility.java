package com.GenaralStore.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.parser.JSONParser;

import io.appium.java_client.android.AndroidDriver;

public class FileUtility {
	
	
	public String getPropertyData(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants1.PropertyfilePath);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(Key);
		return data;
		
	}
	
	public String getDataFromJson(String Key)throws Throwable
	{
		//step1: convert physical file into java reference
		FileReader fr=new FileReader(IPathConstants1.JsonfilePath);
		//step2: convert json to java object
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(fr);
		
		//step 3: read data
		HashMap hp=(HashMap)obj;	
		String value=(String) hp.get(Key);
		return value;
	}
}
