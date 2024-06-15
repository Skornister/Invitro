package steps.ui;

import com.codeborne.selenide.Condition;
import steps.ui.core.Strings;

import java.time.Duration;

import static steps.ui.core.BaseMethods.s$;

public class MainPage {

    public MainPage conformCookie() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Conform cookie");
        s$("onboarding.cookie.conform.button").should(Condition.visible).click();
        s$("onboarding.cookie.conform.button").shouldNot(Condition.visible);
        return this;
    }

    public GetResultsPage openPageGetResults() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open page Get results");
        s$(Strings.header_get_result).should(Condition.visible).click();
        s$(Strings.get_result_title_text).should(Condition.visible, Duration.ofSeconds(20))
                .should(Condition.text("Результаты поиска"));
        return new GetResultsPage();
    }
}
