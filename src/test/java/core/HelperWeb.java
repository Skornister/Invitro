package core;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Selenide;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WindowType;

import java.time.Duration;

import io.qameta.allure.Step;

public class HelperWeb {

    @Step("Open {url}")
    public static void openUrl(String url) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open " + url);
        Selenide.open(url);
    }

    @Step("Create new tab")
    public static void newTab() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Create new tab");
        getWebDriver().switchTo().newWindow(WindowType.TAB);
    }

    @Step("Change browser window size to {width}x{height}")
    public static void resizeWindow(int width, int height) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Change browser window size to " + width + "x" + height);
        getWebDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Step("Switch to {number} tab")
    public static void switchToTab(int number) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Switch to " + number + " tab");
        getWebDriver().switchTo().window(getWebDriver().getWindowHandles().toArray()[(number - 1)].toString());
    }

    @Step("Assert: page contains '{url}'")
    public static void assertUrlContaining(String url) {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: page contains '" + url + "'");
        webdriver().shouldHave(urlContaining(url), Duration.ofSeconds(4));
    }

    @Step("Close active tab")
    public static void closeTab() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Close active tab");
        getWebDriver().close();
    }

    @Step("Get url")
    public static String getUrl() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get url");
        return getWebDriver().getCurrentUrl();
    }

    @Step("Refresh page")
    public static void refreshPage() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Refresh page");
        Selenide.refresh();
    }
}