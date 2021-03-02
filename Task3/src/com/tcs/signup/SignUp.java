package com.tcs.signup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr303003");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ynUhUgu");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		driver.findElement(By.linkText("Delete Customer")).click();
		driver.findElement(By.xpath("//input[contains(@name,'cusid')]")).sendKeys("4327");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		Alert alert = driver.switchTo().alert();		
        String message=driver.switchTo().alert().getText();	
        System.out.println(message);
        Thread.sleep(5000);	
        
        alert.dismiss();
        
        driver.quit();
        
		
		
	}

}
