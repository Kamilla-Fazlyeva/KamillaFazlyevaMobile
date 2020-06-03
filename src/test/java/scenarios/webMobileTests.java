package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static utils.TestProperties.getProperties;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Check that google search has no empty results")
    public void googleSearchTest() throws IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        // open Google page
        getDriver().get(getProperties().getProperty("url"));

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        // type in the search field
        getPageObject().getWelement("searchField").sendKeys(getProperties().getProperty("search"));
        // click search button
        getPageObject().getWelement("searchBtn").click();
        // check that results are not empty
        List<WebElement> searchResults = waitVisibilityOfElements(getPageObject()
                .getWelements("searchResults"));
        assertTrue(!searchResults.isEmpty());
    }
}
