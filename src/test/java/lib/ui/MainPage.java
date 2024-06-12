package lib.ui;

import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import io.qameta.allure.Step;

public class MainPage {

    @Step("Conform cookie")
    public MainPage conformCookie() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Conform cookie");
        ss("onboarding.cookie.conform.button").should(Condition.visible).click();
        ss("onboarding.cookie.conform.button").shouldNot(Condition.visible);
        return this;
    }

    @Step("Open page Get results")
    public GetResultsPage openPageGetResults() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open page Get results");
        ss("header.get_result").should(Condition.visible).click();
        ss("get_result.title.text").should(Condition.visible, Duration.ofSeconds(20))
                .should(Condition.text("Результаты поиска"));
        return new GetResultsPage();
    }
}
