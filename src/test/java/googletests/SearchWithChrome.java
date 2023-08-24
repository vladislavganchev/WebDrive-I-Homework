package googletests;

import enums.BrowserType;
import org.junit.jupiter.api.Test;
import setup.BaseSetupGoogle;
import static utils.Constants.*;

public class SearchWithChrome extends BaseSetupGoogle {

    @Test
    public void search_With_ChromeTest() {
        selectBrowser(BrowserType.CHROME);
        setWait(WAIT_LIMIT);
        navigateToUrl(GOOGLE_WEBSITE_NAME);
        consentCookies(GOOGLE_AGREE_BUTTON_ID);
        typeSearchText(GOOGLE_SEARCH_FIELD_NAME);
        submitSearch(GOOGLE_SEARCH_BUTTON_NAME);
        assertFirstResult(GOOGLE_FIRST_RESULT);

        }
    }


