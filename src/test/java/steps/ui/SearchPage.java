package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;


public class SearchPage {

    @Given("Ввести в поисковую строку '{string}'")
    public SearchPage inputTextInSearchLine(String text) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": сти в поисковую строку " + text);
        s$(Strings.searchLine).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .val(text);
        return this;
    }

    @When("Нажать кнопку Поиск")
    public SearchPage clickSearchButton() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Нажать кнопку Поиск");
        s$(Strings.searchLine_button).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @Then("Проверка: Отображается продукт с кодом '{string}'")
    public SearchPage assertExistSearchResult(String text) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: Отображается продукт с кодом " + text);
        String textActual = s$(Strings.searchResult_product_number).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText();
        Assertions.assertEquals(text, textActual.replaceAll("[^0-9]", ""), "Search result not found");
        return this;
    }
}
