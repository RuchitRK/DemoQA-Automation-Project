package com.project.DemoQA;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleUploadDownload {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.8 to click on Upload & Download module
		//download
		driver.findElement(By.xpath("//*[@id=\"item-7\"]/span")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement downloadBtn = driver.findElement(By.id("downloadButton"));
		downloadBtn.click();
		String dlPath = System.getProperty("user.home")+ "/Downloads/sampleFile.jpeg";
		File dlFile = new File(dlPath);
		Thread.sleep(2000);
		//upload
		String upFile = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data_for_Web_Table_Testing.xlsx";
		WebElement uploadBtn = driver.findElement(By.id("uploadFile"));
		uploadBtn.sendKeys(upFile);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
        String resultText = driver.findElement(By.id("uploadedFilePath")).getText();
        System.out.println("Browser showed: " + resultText);
	}

}
