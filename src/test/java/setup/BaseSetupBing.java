package setup;

import enums.BrowserType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import static utils.Constants.*;
public class BaseSetupBing {
    protected static WebDriver driver;
    private static String actualResult;

    public static void selectBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case CHROME_HEADLESS:
                ChromeOptions chromeOpt = new ChromeOptions();
                chromeOpt.addArguments("--headless");
                driver = new ChromeDriver(chromeOpt);
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions firefoxOpt = new FirefoxOptions();
                firefoxOpt.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOpt);
                break;
        }
    }
    public static void setWait(byte seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void navigateToUrl(String siteName) {
        switch (siteName.toLowerCase()) {
            case "google":
                driver.get(GOOGLE_URL);
                break;
            case "bing":
                driver.get(BING_URL);
                break;
        }
    }

    public static void typeSearchText (String searchFieldId) {
        WebElement searchField = driver.findElement(By.id(searchFieldId));
        searchField.sendKeys(SEARCH_ITEM);
    }

    public static void submitSearch (String searchButtonPath) {
        WebElement searchButton = driver.findElement(By.xpath(searchButtonPath));
        searchButton.submit();
    }

    public static void assertFirstResult(String firstResultPath) {
        WebElement firstResult = driver.findElement(By.xpath(firstResultPath));
        actualResult = firstResult.getText();

        Assertions.assertEquals(WEBSITE_TITLE, actualResult);
    }
}
