package com.googletest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class GoogleTest extends TestBase {

    @BeforeClass
    public void beforeClass() {
        ;
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterClass
    public void afterClass() {
        ;
    }

    @Test
    public void explicitWaitTest() {
        driver.findElement(By.name("q")).sendKeys("tito" + Keys.ENTER);
        Long secs = Long.valueOf(10);
        WebElement we = new WebDriverWait(driver, secs)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        System.out.println("we -> ".concat(we.getText()));
    }

    @Test
    public void fluentWaitTest() {
        driver.findElement(By.name("q")).sendKeys("tito" + Keys.ENTER);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("result-stats"));
            }
        });
        System.out.println("foo is: ".concat(we.getText()));
    }
}
