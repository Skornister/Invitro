package hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class AfterStepHooks {

    @After
    public void tearDown() {
        String screenshotName = System.currentTimeMillis() + ".png";
        Selenide.screenshot(screenshotName);
        System.out.println("Screenshot taken: " + screenshotName);
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
