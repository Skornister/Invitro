package tests;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import core.HelperWeb;
import core.InitClass;
import core.driver.ConfWebDriver;

public class TestBase extends InitClass {

    @BeforeAll
    public static void setUp() {
        ConfWebDriver.configure();
    }

    @BeforeEach
    public void startDriver() {
        HelperWeb.openUrl("https://www.invitro.ru");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}