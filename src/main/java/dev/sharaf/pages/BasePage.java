package dev.sharaf.pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {
    // static final Logger log = getLogger(lookup().lookupClass());
    static final Logger log = Logger.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;
    int timeoutInSecs = 5;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutInSecs));
    }

    public void setTimeoutInSecs(int timeoutSec) {
        this.timeoutInSecs = timeoutSec;
    }

    public void visitUrl(String url) {
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        find(element).click();
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public boolean isDisplayed(By locator) throws TimeoutException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }


}
