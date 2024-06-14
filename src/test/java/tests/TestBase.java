package tests;

import com.codeborne.selenide.Selenide;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import core.InitClass;
import core.config.ConfigReader;
import core.driver.ConfWebDriver;
import core.listeners.AllureAttachments;
import core.listeners.BeforeAfterTestExtension;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.runner.RunWith;

@ExtendWith({AllureAttachments.class, BeforeAfterTestExtension.class, AllureJunit5.class})
public class TestBase extends InitClass {

    String invitroUrl = ConfigReader.webConfig.invitroUrl();

    @BeforeAll
    public static void setUp() {
        ConfWebDriver.configure();
    }

    @BeforeEach
    public void startDriver() {
        //HelperWeb.openUrl(invitroUrl);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}