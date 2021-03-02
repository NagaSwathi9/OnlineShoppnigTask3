package com.tcs.onlineshopping;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class OnlineShopping {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bewakoof.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement mc=driver.findElement(By.xpath("//span[text()='MOBILE COVERS']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(mc).perform();
		
		WebElement onePlus=driver.findElement(By.linkText("OnePlus 8T"));
		Actions a2=new Actions(driver);
		a2.doubleClick(onePlus).perform();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement scrollDown=driver.findElement(By.xpath("//img[starts-with(@title,'Mickey')]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollDown);
		scrollDown.click();
		
		WebElement qty=driver.findElement(By.xpath("//select[contains(@class,'form-control')]"));
		Select s1=new Select(qty);
		s1.selectByIndex(1);
		qty.click();
		
		WebElement addToCart=driver.findElement(By.xpath("//button[contains(@id,'addToCart')]"));
		addToCart.click();
		
		WebElement goToCart=driver.findElement(By.xpath("//span[contains(@class,'atc_to_gtc')]"));
		goToCart.click();
		
		String message=driver.findElement(By.cssSelector(".qty")).getText();
		System.out.println(message);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("C://Users/HELLO/workspace/selenium/Task3/screenshot/screen.png"));
		System.out.println("Screenshot taken");
		
		String total=driver.findElement(By.xpath("//div[contains(@class,'pmts-pr')]")).getText();
		System.out.println(total);
		driver.quit();
	}

}
