package testdlspages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import dev.sharaf.dlspages.ExtendedLoginPage;

public class TestExtendedLoginDls {
    ExtendedLoginPage login;

    @BeforeMethod
    void setup() {
        login = new ExtendedLoginPage("chrome"); 
    }

    @AfterMethod
    void teardown() {
        login.quit(); 
    }

    @Test
    void testLoginSuccess() {
        login.with("user", "user");
        assertThat(login.successBoxPresent()).isTrue();
    }

    @Test
    void testLoginFailure() {
        login.with("bad-user", "bad-password");
        assertThat(login.successBoxPresent()).isFalse();
    }

}