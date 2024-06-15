package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;

public class ChangeCityUnit {

    @Given("Открыть меню Выбор города")
    public ChangeCityUnit openUnitCity() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Открыть меню Выбор города");
        s$(Strings.header_unit_city_label).should(Condition.visible)
                .click();
        s$(Strings.header_unit_city_label_change).should(Condition.visible);
        return this;
    }

    @And("Нажать кнопку 'Выбрать город'")
    public ChangeCityUnit clickChooseAnotherCity() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Нажать кнопку 'Выбрать город'");
        s$(Strings.header_unit_city_label_change_button).should(Condition.visible)
                .click();
        s$(Strings.search_city).should(Condition.visible)
                .highlight();
        return this;
    }

    @And("Ввести текст {string} в поле поиска города и проверить наличие города в результатах поиска")
    public ChangeCityUnit inputSearchCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Ввести текст в поле поиска города " + city);
        s$(Strings.search_city_input).should(Condition.visible)
                .setValue(city);
        s$(Strings.search_city_result).should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }

    @And("Нажать на результат поиска {string}")
    public ChangeCityUnit clickResultCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click result city '" + city + "'");
        s$(Strings.search_city_result).should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .click();
        return this;
    }

    @Then("Проверка: Выбранный город {string}")
    public ChangeCityUnit assertSelectedCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: Выбранный город '" + city + "'");
        s$(Strings.header_unit_city_label).should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }
}
