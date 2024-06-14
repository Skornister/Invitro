package core.driver;

import com.codeborne.selenide.Configuration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import core.config.ConfigReader;

public class ConfWebDriver {
    public static void configure() {
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
        Configuration.browser = ConfigReader.webConfig.browser();
        Configuration.browserSize = ConfigReader.webConfig.browserSize();
        Configuration.browserVersion = ConfigReader.webConfig.browserVersion();
        //Configuration.timeout = 10000;
    }
}
