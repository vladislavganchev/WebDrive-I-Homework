package bingtests;

import enums.BrowserType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSetupBing;
import java.time.Duration;
import static utils.Constants.*;

public class SearchWithChromeHeadless extends BaseSetupBing {
    @Test
    public void search_With_Chrome() {
        selectBrowser(BrowserType.CHROME_HEADLESS);
        setWait(WAIT_LIMIT);
        navigateToUrl(BING_WEBSITE_NAME);
        typeSearchText(BING_SEARCH_FIELD);
        submitSearch(BING_SEARCH_BUTTON_PATH);
        WebDriverWait webDriver = new WebDriverWait(driver, Duration.ofSeconds(WAIT_LIMIT));
        webDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BING_FIRST_RESULT)));
        assertFirstResult(BING_FIRST_RESULT);
    }
}
