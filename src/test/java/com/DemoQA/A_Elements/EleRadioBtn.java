package com.DemoQA.A_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleRadioBtn {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.3 to click on Radio button module
		driver.findElement(By.xpath("//*[@id=\"item-2\"]/span")).click();
		Thread.sleep(2000);
		//1.3.1 to click on Yes radio btn
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		Thread.sleep(2000);
		//1.3.2 to click on Impressive radio btn
		driver.findElement(By.xpath("//label[text()='Impressive']")).click();
		Thread.sleep(2000);
		driver.quit();	
	}
}
