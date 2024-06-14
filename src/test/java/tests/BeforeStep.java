package tests;

import core.HelperWeb;
import core.driver.ConfWebDriver;
import io.cucumber.java.en.Given;

public class BeforeStep {

    @Given("Open url {string}")
    public void openUrl(String url) {
        ConfWebDriver.configure();
        HelperWeb.openUrl(url);
    }
}
