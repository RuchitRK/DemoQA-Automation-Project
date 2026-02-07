package com.DemoQA.C_AlertsFramesAndWindows;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class browserWindows {
    WebDriver driver;
    WebDriverWait wait;
    String mainWindowID;

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainWindowID = driver.getWindowHandle();
    }
    @Test(priority = 0)
    public void testNewTab() {
        driver.findElement(By.id("tabButton")).click();
        handleWindowAndVerify("This is a sample page");
    }
    @Test(priority = 1)
    public void testNewWindow() {
        driver.findElement(By.id("windowButton")).click();
        handleWindowAndVerify("This is a sample page");
    }
    @Test(priority = 2)
    public void testWindowMessage() {
        driver.findElement(By.id("messageWindowButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowID = driver.getWindowHandles();
        for (String id : allWindowID) {
            if (!id.equals(mainWindowID)) {
                driver.switchTo().window(id);
                System.out.println("Switched to MSG Window ID: " + id);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowID);
    }
    public void handleWindowAndVerify(String expectedText) {
        Set<String> allWindowID = driver.getWindowHandles();
        for (String childID : allWindowID) {
            if (!mainWindowID.equalsIgnoreCase(childID)) {
                driver.switchTo().window(childID);
                System.out.println("Switched to ID: " + childID);
                WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
                String text = heading.getText();
                System.out.println("Text Found: " + text);
                Assert.assertEquals(text, expectedText);
                driver.close(); 
            }
        }
        driver.switchTo().window(mainWindowID);
        Assert.assertTrue(driver.getCurrentUrl().contains("browser-windows"));
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
}