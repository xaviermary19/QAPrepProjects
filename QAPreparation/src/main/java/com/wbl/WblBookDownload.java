package com.wbl;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WblBookDownload {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\antoj\\eclipse-workspace\\QAPreparation\\QAPreparation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void bookDownload() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.whiteboxqa.com/");
		
		driver.findElement(By.xpath("//*[@id='loginButton']//parent::li")).click();
		driver.findElement(By.cssSelector("#username")).sendKeys("xaviermary19@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Mary@4012");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		Actions action =  new Actions(driver);
		WebElement resource = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[4]/a"));
		action.moveToElement(resource).perform();
		
		WebElement presentations = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[4]/ul/li[2]/a"));
		presentations.click();
		
		driver.findElement(By.xpath("//a[@id='books']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"books\"]/div/div/div/div/table/tbody/tr[9]/td[2]/a")).click();
		
		//driver.navigate().to("https://drive.google.com/u/0/uc?id=0B2Z9J2D1hx7UM0xnRkF3aG5mZ0E&export=download");
		//Thread.sleep(5000);
		Set<String> windowsCount = driver.getWindowHandles();
		Iterator<String> itr = windowsCount.iterator();
		
		String parentId=itr.next();
		String childId=itr.next();
		
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div[2]/div[2]/div[3]/div")).click();
	}
	
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}

}
