package com.project.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleCheckBox {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.2 to click on Check Box module
		driver.findElement(By.xpath("//*[@id=\"item-1\"]/span")).click();
		Thread.sleep(2000);
		//1.2.1 to click on Home check box expand arrow
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/ol/li/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
		Thread.sleep(2000);
		//1.2.1.1 to click on Desktop check box expand arrow
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/ol/li/ol/li[1]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")).click();
		Thread.sleep(2000);
		//1.2.1.2 to click on Documents check box expand arrow
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")).click();
		Thread.sleep(2000);
		//1.2.1.2.1 to click on WorkSpace check box expand arrow
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")).click();
		Thread.sleep(2000);
		//1.2.1.2.2 to click on Office check box expand arrow
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")).click();
		Thread.sleep(2000);
		//1.2.1.3 to click on Downloads check box expand arrow
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")).click();
		Thread.sleep(2000);
		//checking check boxes after expanding
		//driver.findElement(By.cssSelector("svg.rct-icon.rct-icon-uncheck")).click();
		// This clicks the "Home" text specifically
		driver.findElement(By.xpath("//span[@class='rct-title'][text()='Home']")).click();
	}
}
