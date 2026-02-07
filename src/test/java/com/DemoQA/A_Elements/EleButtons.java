package com.DemoQA.A_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleButtons {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.5 to click on Buttons module
		driver.findElement(By.xpath("//*[@id=\"item-4\"]/span")).click();
		Thread.sleep(2000);
		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		WebElement justClick = driver.findElement(By.xpath("//button[text()='Click Me']"));
		Actions actions = new Actions(driver);
		Action a1 = actions.moveToElement(doubleClick).doubleClick().build();
		a1.perform();
		Thread.sleep(2000);
		Action a2 = actions.moveToElement(rightClick).contextClick().build();
		a2.perform();
		Thread.sleep(2000);
		Action a3 = actions.moveToElement(justClick).click().build();
		a3.perform();
	}

}
