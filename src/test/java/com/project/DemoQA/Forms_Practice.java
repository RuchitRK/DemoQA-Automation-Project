package com.project.DemoQA;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forms_Practice {
	WebDriver driver;
	
	@BeforeClass
	public void driverSetup() throws InterruptedException {
	  WebDriverManager.edgedriver().setup();
	  driver= new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com");
	  Thread.sleep(2000);
	  
	}
	@Test
	public void openDemoQA() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[normalize-space()='Practice Form']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("firstName")).sendKeys("RK00");
	  Thread.sleep(1000);
	  driver.findElement(By.id("lastName")).sendKeys("RRK00");
	  Thread.sleep(1000);
	  driver.findElement(By.id("userEmail")).sendKeys("ruchit@gmail.com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[text()='Male']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[text()='Female']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[text()='Other']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("userNumber")).sendKeys("7788778877");
	  Thread.sleep(1000);
	  driver.findElement(By.id("dateOfBirthInput")).click();
	  Thread.sleep(1000);
	  WebElement monthDropDown = driver.findElement(By.className("react-datepicker__month-select"));
	  Select selectMonth = new Select(monthDropDown);
	  selectMonth.selectByVisibleText("November");
	  WebElement yearDropDown = driver.findElement(By.className("react-datepicker__year-select"));
	  Select selectYear = new Select(yearDropDown);
	  selectYear.selectByValue("1999");//react-datepicker__week
	  Thread.sleep(2000);
	  int date = 13;
	  if (date>9) {
		  driver.findElement(By.xpath("//div[contains(concat (' ' ,normalize-space(@class), ' '), 'react-datepicker__day react-datepicker__day--0"+date+"')]")).click();
	  }else {
		  //driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--00"+date+"']")).click();
		  driver.findElement(By.xpath("//div[contains(concat (' ' ,normalize-space(@class), ' '), 'react-datepicker__day react-datepicker__day--00"+date+"')]")).click();
	  }
	  Thread.sleep(1000);
	  WebElement subject = driver.findElement(By.id("subjectsInput"));
	  subject.click();
	  Thread.sleep(2000);
	  subject.sendKeys("Math");
	  Thread.sleep(2000);
	  subject.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  WebElement sportsCheckBox = driver.findElement(By.id("hobbies-checkbox-1"));
	  WebElement readingCheckBox = driver.findElement(By.id("hobbies-checkbox-2"));
	  WebElement musicCheckBox = driver.findElement(By.id("hobbies-checkbox-3")); 
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", sportsCheckBox);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//label[normalize-space()='Sports']")).click();
	  boolean sportsSelected = sportsCheckBox.isSelected();
	  if(sportsSelected) {
		  System.out.println("PASS: Sports checkbox is checked");
	  } else {
		  System.out.println("FAIL: Sports checkbox is NOT checked");
	  }
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[normalize-space()='Reading']")).click();
	  boolean readingSelected = readingCheckBox.isSelected();
	  if(readingSelected) {
		  System.out.println("PASS: Reading checkbox is checked");
	  } else {
		  System.out.println("FAIL: Reading checkbox is NOT checked");
	  }
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[normalize-space()='Music']")).click();
	  boolean musicSelected = musicCheckBox.isSelected();
	  if(musicSelected) {
		  System.out.println("PASS: Music checkbox is checked");
	  } else {
		  System.out.println("FAIL: Music checkbox is NOT checked");
	  }
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadPicture")));
	  String upFilePath = System.getProperty("user.home") + "\\Downloads\\sampleFile.jpeg";
	  driver.findElement(By.id("uploadPicture")).sendKeys(upFilePath);
	  Thread.sleep(1000);
	  driver.findElement(By.id("currentAddress")).sendKeys("123 Selenium Street, Automate City, 400001");
	  Thread.sleep(1000);
	  driver.findElement(By.id("state")).click();
	  driver.findElement(By.xpath("//div[text()='NCR']")).click();
	  driver.findElement(By.id("city")).click();
	  driver.findElement(By.xpath("//div[text()='Delhi']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("submit")).click();
	  //enhancing of all the codes will be done after some time
	}
}
