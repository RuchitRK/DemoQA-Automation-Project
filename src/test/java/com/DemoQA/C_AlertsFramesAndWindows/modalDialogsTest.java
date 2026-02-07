package com.DemoQA.C_AlertsFramesAndWindows;

import java.time.Duration;
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

public class modalDialogsTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 0)
    public void testSmallModal() {
        driver.findElement(By.id("showSmallModal")).click();
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-sm")));
        System.out.println("Small Modal Title: " + modalTitle.getText());
        Assert.assertEquals(modalTitle.getText(), "Small Modal");
        String bodyText = driver.findElement(By.className("modal-body")).getText();
        System.out.println("Body Text: " + bodyText);
        Assert.assertTrue(bodyText.contains("This is a small modal"));
        driver.findElement(By.id("closeSmallModal")).click();
        wait.until(ExpectedConditions.invisibilityOf(modalTitle));
        System.out.println("Small Modal closed successfully");
    }
    @Test(priority = 1)
    public void testLargeModal() {
        driver.findElement(By.id("showLargeModal")).click();
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        System.out.println("Large Modal Title: " + modalTitle.getText());
        Assert.assertEquals(modalTitle.getText(), "Large Modal");
        String bodyText = driver.findElement(By.className("modal-body")).getText();
        System.out.println("Large Body Text Length: " + bodyText.length() + " chars");
        driver.findElement(By.id("closeLargeModal")).click();
        System.out.println("Large Modal closed successfully.");
    }
    @AfterMethod
    public void shutDown() {
        driver.quit();
    }
}