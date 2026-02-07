package com.DemoQA.A_Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleDynamicProperties {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.9 to click on Dynamic Properties module
		driver.findElement(By.xpath("//*[@id=\"item-8\"]/span")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enableBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableBtn.click();
        System.out.println("Will enable 5 seconds clicked");
        WebElement visibleBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleBtn.click();
        System.out.println("Hidden button clicked");
    }
}
