package com.DemoQA.C_AlertsFramesAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class nestedFramesTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");
    }
    @Test
    public void testNestedFrames() {
        driver.switchTo().frame("frame1");
        String parentText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Parent Frame Text: " + parentText);
        Assert.assertTrue(parentText.contains("Parent frame"));
        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrameElement);
        String childText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Child Frame Text: " + childText);
        Assert.assertTrue(childText.contains("Child Iframe"));
        driver.switchTo().parentFrame();
        String textBackInParent = driver.findElement(By.tagName("body")).getText();
        System.out.println("Back in Parent: " + textBackInParent);
        driver.switchTo().defaultContent();
        System.out.println("Back on Main Page");
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
}