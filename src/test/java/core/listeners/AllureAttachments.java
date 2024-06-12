package core.listeners;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import core.config.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureAttachments implements AfterTestExecutionCallback {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        AllureAttachments.attachParameters();

        try {
            saveScreenshot(Selenide.screenshot(OutputType.BYTES));
        } catch (Exception e) {
            System.out.println("Не удалось сохранить скриншот");
        }
    }

    private static void attachParameters() {
        Allure.parameter("Browser", ConfigReader.webConfig.browser());
    }
}