package com.DemoQA.A_Elements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleLinksImagesBroken {
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.7 to click on Broken Links - Images module
		driver.findElement(By.xpath("//*[@id=\"item-6\"]/span")).click();
		Thread.sleep(2000);
	        List<WebElement> images = driver.findElements(By.tagName("img"));
	        System.out.println("Total images found: " + images.size());
	        for (WebElement img : images) {
	            String src = img.getAttribute("src");
	            //to skip images with no source
	            if (src == null || src.isEmpty()) {
	                System.out.println("Image found without a valid source.");
	                continue;
	            }
	            Object result = ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalWidth", img);
	            long naturalWidth = 0;
	            if (result instanceof Long) {
	                naturalWidth = (Long) result;
	            } 
	            else if (result instanceof Double) {
	                naturalWidth = ((Double) result).longValue();
	            }
	            if (naturalWidth > 0) {
	                System.out.println("VALID IMAGE: " + src);
	            } else {
	                System.out.println("BROKEN IMAGE DETECTED: " + src);
	            }
	        }
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        for (WebElement link : links) {
	            String url = link.getAttribute("href"); 
	            // Skip empty links or javascript
	            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
	                continue;
	            }
	            verifyUrl(url, "LINK");
	        }
	}
	public static void verifyUrl(String urlString, String type) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("HEAD"); 
            connection.connect();
            int respCode = connection.getResponseCode();
            if (respCode >= 400) {
                System.out.println("BROKEN " + type + ": " + urlString + " (Status: " + respCode + ")");
            }
            else {
                System.out.println("VALID " + type + ": " + urlString + " (Status: " + respCode + ")");
            }
        }
        catch (Exception e) {
            System.out.println("ERROR checking " + type + ": " + urlString);
        }
	}
}
