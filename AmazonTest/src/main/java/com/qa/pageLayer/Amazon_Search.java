package com.qa.pageLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testBase.TestBase;

public class Amazon_Search extends TestBase{
	
	public Amazon_Search()
	{
		PageFactory.initElements(driver, this);
	}
	
	//search amazon
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchAmazon;
	
	//select amazon link
	
	@FindBy(css="#rso > div:nth-child(1) > div > div > div > div > div > div > div > div.yuRUbf > a > h3")
	private WebElement selectAmazon;
	
	//click on All
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	private WebElement selectAll;
	
	//search for dell computer 
	@FindBy(xpath="//input[ @id='twotabsearchtextbox']")
	private WebElement searchdellComputer;
	
	//Apply Filter
	@FindBy(xpath="//input[ @id='low-price']")
	private WebElement minValue;
	
	@FindBy(xpath="//input[ @id='high-price']")
	private WebElement maxValue;
	
	public void search_AmazonAndPrintAllResult()
	{
		searchAmazon.sendKeys("amazon",Keys.ENTER);
		
		//print all result
		
		List<WebElement> allResult=driver.findElements(By.xpath("//*[@id='search']//following::h3//following::div/cite"));
		
		for(WebElement links: allResult)
		{
			System.out.println(links.getText());
		}
		
	}
	
	public void selectAmazonLinkAndClick()
	{
		selectAmazon.click();
	}
	
	public void selectAllAndSelectElectronic()
	{
		selectAll.click();
		Select s= new Select(selectAll);
		//s.selectByVisibleText("Electronics");
		s.selectByIndex(16);
	}
	
	public void searchDellComputer()
	{
		searchdellComputer.sendKeys("Dell computer", Keys.ENTER);
	}
	
	public void PrivideValueToFilter()
	{
		minValue.sendKeys("30000");
		
		maxValue.sendKeys("50000");
		
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
	}
	
	public  void ListOutAllProductOfFirst2Pages()
	{
		
		List<WebElement> productPrice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		productPrice.size();
		//for(int j = 1 ; j < productPrice.size() ; j++) {                
	     //   if (j <= 2) {
	      //      driver.findElement(By.xpath("//a[@aria-label='Go to next page, page 2']")).click(); // navigate to page number 2
	      //  }   
		System.out.println(productPrice.size());
		Map<WebElement,Integer> map=new HashMap<WebElement,Integer>();
		for(int i=0;i<productPrice.size();i++)
		{
		
			if(productPrice.get(i).getText()!="")
			{
			map.put(productPrice.get(i),Integer.parseInt(productPrice.get(i).getText().replaceAll(",", "")));
			}
			
		}
		
		//use Arraylist for sorting ...first cover map to arralist
		List<Entry<WebElement,Integer>> list=new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		System.out.println(list.size());
		for(int i=0;i<=list.size();i++)
		{
			if(i>30000 || i<50000)
			{
				System.out.println("All value shows as per filtered");
			}
		}
		
           
	}
	public void VerifyStar() throws Exception
	{
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='a-size-base']"));
		System.out.println(elements);
		System.out.println(elements.size());
		double starsExpected=5.0;
		if (elements.size() == starsExpected){
			for (WebElement e : elements){
				   String text = e.getText(); // get current element text, like `1`, `2`... `5`
				   if(Integer.parseInt(text) == starsExpected){ 
				      System.out.println("5 Out of 5 stars"+text);
				   }
				   
				   else
					{
						System.out.println("All are below 5 rating");
					}
		}
			
			

		
		   
		   //first product
		   ((Entry<WebElement, Integer>) elements.get(0)).getKey().click();
		  
		}
	}
	
	
	
}
