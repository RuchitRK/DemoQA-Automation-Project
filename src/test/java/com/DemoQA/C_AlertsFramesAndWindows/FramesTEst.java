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

public class FramesTEst {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
    }
    @Test
    public void testFrames() {  
        System.out.println("Starting Frame Test: ");
        driver.switchTo().frame("frame1");
        WebElement heading1 = driver.findElement(By.id("sampleHeading"));
        String text1 = heading1.getText();
        System.out.println("Frame 1 Content: " + text1);
        Assert.assertEquals(text1, "This is a sample page");
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page.");

        driver.switchTo().frame("frame2");
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        String text2 = heading2.getText();
        System.out.println("Frame 2 Content: " + text2);
        Assert.assertEquals(text2, "This is a sample page");
        driver.switchTo().defaultContent();
        System.out.println("Returned to main page again.");
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
}