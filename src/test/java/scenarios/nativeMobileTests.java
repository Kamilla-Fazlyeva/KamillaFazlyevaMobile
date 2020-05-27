package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static utils.TestProperties.getProperties;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Check that after registration and login there is expected page opened")
    public void nativeAppRegisterTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {
        // register new account
        getPageObject().getWelement("registerBtn").click();
        // fill the fields
        getPageObject().getWelement("emailField").sendKeys(getProperties().getProperty("email"));
        getPageObject().getWelement("usernameField").sendKeys(getProperties().getProperty("username"));
        getPageObject().getWelement("passwordField").sendKeys(getProperties().getProperty("password"));
        getPageObject().getWelement("confirmPasswordField").sendKeys(getProperties().getProperty("password"));
        // complete registration
        getPageObject().getWelement("registerAccountBtn").click();
        // perform sign in
        getPageObject().getWelement("loginEmail").sendKeys(getProperties().getProperty("email"));
        getPageObject().getWelement("loginPassword").sendKeys(getProperties().getProperty("password"));
        getPageObject().getWelement("signInBtn").click();
        // check that page title is "BudgetActivity"
        assertEquals(getPageObject().getWelement("pageTitle").getText(), getProperties().getProperty("page"));
    }
}
