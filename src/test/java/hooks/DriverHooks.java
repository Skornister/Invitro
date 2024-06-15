package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHooks {

    @Before
    public void setUpDriverBeforeScenario() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-gpu");
        chromeOptions.addArguments("--lang=ru-RU");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 10000;
    }
}
