package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;
import static steps.ui.core.BaseMethods.s$$;

public class GetResultsPage {

    @Given("Нажать кнопку 'получить результаты анализов'")
    public GetResultsPage clickGetResults() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Нажать кнопку 'получить результаты анализов'");
        s$(Strings.get_result_find_button).should(Condition.visible)
                .highlight()
                .click();
        return this;
    }

    @And("Проверка: заголовок страницы '{string}'")
    public GetResultsPage assertTitlePage(String textTitle) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: заголовок страницы '" + textTitle + "'");
        s$(Strings.get_result_title_text).should(Condition.visible, Condition.text(textTitle))
                .highlight();
        return this;
    }

    @And("Проверка: сообщение ошибки '{string}' если пустые поля")
    public GetResultsPage assertErrorEmptyFields(String textError) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: сообщение ошибки '" + textError + "' если пустые поля");
        String text = s$(Strings.get_result_error_empty_fields).getOwnText()
                .replaceFirst(" ", " " + s$$(Strings.get_result_error_textBold)
                        .texts()
                        .toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "")
                ).replace("\n", "");
        Assert.assertEquals(textError, text);
        System.out.println("text: " + text);
        System.out.println("textError: " + textError);
        return this;
    }

    @And("В поле код ИНЗ ввести '{string}' и проверить")
    public GetResultsPage inputCodeInzAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": В поле код ИНЗ ввести '" + textInput + "' и проверить");
        s$(Strings.get_result_input_orderNumber).should(Condition.visible)
                .setValue(textInput);
        s$(Strings.get_result_input_orderNumber).should(Condition.attribute("value", textInput));
        return this;
    }

    @And("В поле Дата рождения ввести '{string}' и проверить")
    public GetResultsPage inputBirthdayAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": В поле Дата рождения ввести '" + textInput + "' и проверить");
        s$(Strings.get_result_input_birthday).should(Condition.visible).click();
        s$(Strings.get_result_input_birthday).press("Home");
        s$(Strings.get_result_input_birthday).sendKeys(textInput);
        s$(Strings.get_result_input_birthday).should(Condition.attribute("value", textInput));
        return this;
    }

    @And("В поле Фамилия ввести '{string}' и проверить")
    public GetResultsPage inputLastNameAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": В поле Фамилия ввести '" + textInput + "' и проверить");
        s$(Strings.get_result_input_lastName).should(Condition.visible).setValue(textInput);
        s$(Strings.get_result_input_lastName).should(Condition.attribute("value", textInput));
        return this;
    }
}
