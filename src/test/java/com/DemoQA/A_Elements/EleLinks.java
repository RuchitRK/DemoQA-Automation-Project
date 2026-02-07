package com.DemoQA.A_Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleLinks {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(1000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(1000);
		//1.6 to click on Links module
		driver.findElement(By.xpath("//*[@id=\"item-5\"]/span")).click();
		String tab1= driver.getWindowHandle();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(1000);
		driver.switchTo().window(tab1);
		Thread.sleep(1000);
		String dynLink = driver.findElement(By.id("dynamicLink")).getText();
		System.out.println(dynLink);
		//driver.findElement(By.id("dynamicLink")).click();
		driver.findElement(By.xpath("//a[starts-with(text(), 'Home') and text() != 'Home']")).click();
		Thread.sleep(1000);
		driver.switchTo().window(tab1);
		//api links
		//created
		System.out.println("Checking Created link");
		driver.findElement(By.id("created")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement response = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
		String actualResponse = response.getText();
		if (actualResponse.contains("201") && actualResponse.contains("Created")) {
			System.out.println("Created Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("Created Link didnt worked");
			System.out.println(actualResponse);
		}
		Thread.sleep(1000);
		//no content
		System.out.println("Checking NO Content link");
		driver.findElement(By.id("no-content")).click();
		Thread.sleep(1000);
		response = driver.findElement(By.id("linkResponse"));
		actualResponse = response.getText();
		if (actualResponse.contains("204") && actualResponse.contains("No Content")) {
			System.out.println("No Content Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("No Content Link didnt worked");
			System.out.println(actualResponse);
		}
		Thread.sleep(1000);
		//moved
		System.out.println("Checking Moved link");
		driver.findElement(By.id("moved")).click();
		Thread.sleep(1000);
		response = driver.findElement(By.id("linkResponse"));
		actualResponse = response.getText();
		if (actualResponse.contains("301") && actualResponse.contains("Moved Permanently")) {
			System.out.println("Moved Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("Moved Link didnt worked");
			System.out.println(actualResponse);
		}
		//Unauthorized
		System.out.println("Checking Unauthorized link");
		driver.findElement(By.id("unauthorized")).click();
		Thread.sleep(1000);
		response = driver.findElement(By.id("linkResponse"));
		actualResponse = response.getText();
		if (actualResponse.contains("401") && actualResponse.contains("Unauthorized")) {
			System.out.println("Unauthorized Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("Unauthorized Link didnt worked");
			System.out.println(actualResponse);
		}
		//forbidden
		System.out.println("Checking Forbidden link");
		driver.findElement(By.id("forbidden")).click();
		Thread.sleep(1000);
		response = driver.findElement(By.id("linkResponse"));
		actualResponse = response.getText();
		if (actualResponse.contains("403") && actualResponse.contains("Forbidden")) {
			System.out.println("Forbidden Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("Forbidden Link didnt worked");
			System.out.println(actualResponse);
		}
		//Not Found - invalid-url
		System.out.println("Checking Forbidden link");
		driver.findElement(By.id("invalid-url")).click();
		Thread.sleep(1000);
		response = driver.findElement(By.id("linkResponse"));
		actualResponse = response.getText();
		if (actualResponse.contains("403") && actualResponse.contains("Not Found")) {
			System.out.println("Not Found Link Worked");
			System.out.println(actualResponse);
		}
		else {
			System.out.println("Not Found Link didnt worked");
			System.out.println(actualResponse);
		}
	}

}
