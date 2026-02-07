package com.DemoQA.C_AlertsFramesAndWindows;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class alertsTest {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 0)
    public void testSimpleAlert() {
        driver.findElement(By.id("alertButton")).click();
        // Switch to Alert
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Alert Text: " + simpleAlert.getText());
        // Click OK
        simpleAlert.accept(); 
    }
    @Test(priority = 1)
    public void testTimerAlert() {
        driver.findElement(By.id("timerAlertButton")).click();
        //Wait Until Alert is present on screen
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        System.out.println("Timer Alert Text: " + timerAlert.getText());
        timerAlert.accept();
    }
    @Test(priority = 2)
    public void testConfirmAlert1() {
        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = driver.switchTo().alert();
        //Click Cancel
        confirmAlert.dismiss(); 
        String result = driver.findElement(By.id("confirmResult")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("Cancel"));
    }
    @Test(priority = 3)
    public void testConfirmAlert2() {
        driver.findElement(By.id("confirmButton")).click();
        Alert confirmAlert = driver.switchTo().alert();
        //Click OK
        confirmAlert.accept(); 
        String result = driver.findElement(By.id("confirmResult")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("Ok"));
    }
    @Test(priority = 4)
    public void testPromptAlert() {
        // Scroll down to see the button
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(By.id("promtButton")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Text: " + promptAlert.getText());
        // Type in alert box
        String myName = "Ruchit";
        promptAlert.sendKeys(myName);
        // Click OK
        promptAlert.accept();
        String result = driver.findElement(By.id("promptResult")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains(myName));
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
}