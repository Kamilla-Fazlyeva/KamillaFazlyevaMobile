package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

import static org.testng.Assert.*;
import static utils.TestProperties.getProperties;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Check that google search has no empty results")
    public void googleSearchTest() throws IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        // open Google page
        getDriver().get(getProperties().getProperty("url"));

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        // type in the search field
        getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(getProperties().getProperty("search"));
        // click search button
        getDriver().findElement(By.xpath("//button[@class='Tg7LZd']")).click();
        // check that results are not empty
        assertTrue(getDriver().findElement(By.cssSelector("#rso > div")).isDisplayed());
    }
}
