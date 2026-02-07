package com.DemoQA.A_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleTextBox {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click(); //"//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]"
		Thread.sleep(2000);
		//1.1 to click on Text Box module
		driver.findElement(By.xpath("//*[@id=\"item-0\"]/span")).click();
		Thread.sleep(2000);
		//1.1.1 to fill Full Name text box
		driver.findElement(By.id("userName")).sendKeys("RK Test1");
		Thread.sleep(2000);
		//1.1.2 to fill Email
		driver.findElement(By.id("userEmail")).sendKeys("ruchittest1@gmail.com");
		Thread.sleep(2000);
		//1.1.3 to fill Current Address
		driver.findElement(By.id("currentAddress")).sendKeys("45, 10th Avenue, Highland Park, New York, 10001");
		Thread.sleep(2000);
		//1.1.4 to fill Permanent Address
		driver.findElement(By.id("permanentAddress")).sendKeys("45, 10th Avenue, Highland Park, New York, 10002");
		Thread.sleep(2000);
		//1.1.5 to click submit button
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
	}
}