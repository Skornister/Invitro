package core.listeners;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * decorator
 */
public class BeforeAfterTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    public static String nameTest;

    @Override
    public void beforeTestExecution(ExtensionContext context) {

        try {
            nameTest = context.getTestMethod().get().getName() + "_" + context.getUniqueId().split("#")[1].replace("]", "");
        } catch (Exception e) {
            nameTest = context.getTestMethod().get().getName();
        }

        System.out.println("\n"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
                + "\nStarted test: " + nameTest + " -> " + context.getDisplayName()
                + "\n");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("\nFinished test: "
                + context.getTestMethod().get().getName()
                + " -> "
                + context.getDisplayName()
                + "\n"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
                + "\n");
    }
}