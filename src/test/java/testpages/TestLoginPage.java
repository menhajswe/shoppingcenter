package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import dev.sharaf.pages.LoginPage;

class TestLoginPage {

    WebDriver driver;
    LoginPage login;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        login = new LoginPage(driver);
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

    @Test
    void testLoginSuccess() {
        login.loginWith("user", "user");
        assertThat(login.successBoxPresent()).isTrue();
    }

    @Test
    void testLoginFailure() {
        login.loginWith("bad-user", "bad-password");
        assertThat(login.successBoxPresent()).isFalse();
    }

}