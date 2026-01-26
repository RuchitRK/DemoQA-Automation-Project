package com.project.DemoQA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleWebTables {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.4 to click on Web Tables module
		driver.findElement(By.xpath("//*[@id=\"item-3\"]/span")).click();
		Thread.sleep(2000);
		clearTable(); //for deleting existing data
	}
	public static void clearTable() {
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//span[@title='Delete']"));
		while (deleteButtons.size() > 0) {
			deleteButtons.get(0).click();
			wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
			deleteButtons = driver.findElements(By.xpath("//span[@title='Delete']"));
		}
	}
}
