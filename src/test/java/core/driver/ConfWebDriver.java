package core.driver;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfWebDriver {
    public static void configure() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--no-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--lang=en-en");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        //Configuration.browserVersion = "124";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }
}
