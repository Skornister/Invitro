package lib.ui;

import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;

public class SearchPage {

    @Step("Input text in search line")
    public SearchPage inputTextInSearchLine(String text) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Input text in search line");
        ss("searchLine").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .val(text);
        return this;
    }

    @Step("Click search button")
    public SearchPage clickSearchButton() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click search button");
        ss("searchLine.button").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @Step("Assert: Exist search result with '{text}'")
    public SearchPage assertExistSearchResult(String text) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: Exist search result with '{text}'");
        String textActual = ss("searchResult.product.number").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText();
        Assertions.assertEquals(text, textActual.replaceAll("[^0-9]", ""), "Search result not found");
        return this;
    }
}
