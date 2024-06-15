package steps.ui.core;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WindowType;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HelperWeb {

    @Given("Open url {string}")
    public static void openUrl(String url) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open " + url);
        Selenide.open(url);
    }

    public static void newTab() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Create new tab");
        getWebDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void resizeWindow(int width, int height) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Change browser window size to " + width + "x" + height);
        getWebDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void switchToTab(int number) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Switch to " + number + " tab");
        getWebDriver().switchTo().window(getWebDriver().getWindowHandles().toArray()[(number - 1)].toString());
    }

    public static void assertUrlContaining(String url) {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: page contains '" + url + "'");
        webdriver().shouldHave(urlContaining(url), Duration.ofSeconds(4));
    }

    public static void closeTab() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Close active tab");
        getWebDriver().close();
    }

    public static String getUrl() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get url");
        return getWebDriver().getCurrentUrl();
    }

    public static void refreshPage() {
        System.out.println("> " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Refresh page");
        Selenide.refresh();
    }
}