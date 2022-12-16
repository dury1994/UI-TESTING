package com.qa.testBase;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pageLayer.Amazon_Search;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver ;
	public static Logger logger;
	
	public Amazon_Search amazon;

	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Amazon Reports");
		PropertyConfigurator.configure("Log4j.properties");
	}
	@AfterClass
	public void stop()
	{
		
	}
	@Parameters("browser")          
	@BeforeMethod
	public void setUp(String br)
	{
		if(br.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser Launched");
		}
		else if (br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("firefox Launches");
		}
		 else if (br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("edge Launches");
		}
		else 
		{
			System.out.println("Please enter valid browser name");
		}
		
		driver.manage().window().maximize();
		logger.info("browser maximize");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		logger.info("url get launced");
		amazon=new Amazon_Search();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser closed");
	}

}
