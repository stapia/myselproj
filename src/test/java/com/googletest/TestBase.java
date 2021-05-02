package com.googletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeTest
    public void testInit() {
//        ChromeDriverService service = ChromeDriverService.createDefaultService();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        driver = new ChromeDriver(service, options);
        driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
    }

    @AfterTest
    public void testTeardown() {
        driver.quit();
    }
}
