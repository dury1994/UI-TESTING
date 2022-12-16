package com.qa.testLayer;


import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

public class TestCase_Amazon extends TestBase {
	
	@Test (priority=1)
	public void SerchAmazonAndGetResult() throws Exception 
	{
		amazon.search_AmazonAndPrintAllResult();
		Thread.sleep(3000);
		amazon.selectAmazonLinkAndClick();
		Thread.sleep(3000);
		amazon.selectAllAndSelectElectronic();
		Thread.sleep(5000);
		amazon.searchDellComputer();
		Thread.sleep(3000);
		amazon.PrivideValueToFilter();
		Thread.sleep(3000);
		amazon.ListOutAllProductOfFirst2Pages();
		Thread.sleep(3000);
		amazon.VerifyStar();
		Thread.sleep(3000);
	}

}
