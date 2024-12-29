package dev.sharaf.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButtonLocator = By.cssSelector("button");
    By successBox = By.id("success");

    public LoginPage(WebDriver driver, int timeout) {
        super(driver);
        setTimeoutInSecs(timeout);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        visitUrl("localhost:8080");
    }

    public void loginWith(String username, String password) {
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(submitButtonLocator);
    }

    public boolean successBoxPresent() {
        try {
            return isDisplayed(successBox);
        } catch (TimeoutException e) {
            log.info(e.getMessage());
        }
        return false;
    }
    
}
