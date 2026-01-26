package com.project.DemoQA;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EleWebTables {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(2000);
		//1. to click on Elements
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(2000);
		//1.4 to click on Web Tables module
		driver.findElement(By.xpath("//*[@id=\"item-3\"]/span")).click();
		Thread.sleep(2000);
		clearTable(); //for deleting existing data
		//Now for adding data
		String excelPath = "src\\test\\resources\\Excel_Data_for_Web_Table_Testing.xlsx";
		FileInputStream fis = new FileInputStream(new File(excelPath));
		Workbook wb1 = new XSSFWorkbook(fis);
		Sheet sheet = wb1.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		int rowCount = sheet.getLastRowNum();
		//System.out.println("Found " +rowCount);
		
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			String fName = formatter.formatCellValue(row.getCell(0));
            String lName = formatter.formatCellValue(row.getCell(1));
            String age = formatter.formatCellValue(row.getCell(2));
            String email = formatter.formatCellValue(row.getCell(3));
            String salary = formatter.formatCellValue(row.getCell(4));
            String dept = formatter.formatCellValue(row.getCell(5));
            
            addNewEntry(fName, lName, email, age, salary, dept);
            
		}
		wb1.close();
		fis.close();
	}
	public static void clearTable() {
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//span[@title='Delete']"));
		while (deleteButtons.size() > 0) {
			deleteButtons.get(0).click();
			wait.until(ExpectedConditions.stalenessOf(deleteButtons.get(0)));
			deleteButtons = driver.findElements(By.xpath("//span[@title='Delete']"));
		}
	}
	public static void addNewEntry(String fName, String lName, String email, String age, String salary, String dept) {
        // Click Add btn
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();

        // Filling Form in Add
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(fName);
        driver.findElement(By.id("lastName")).sendKeys(lName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(dept);

        // click Submit btn
        driver.findElement(By.id("submit")).click();
    }
}
