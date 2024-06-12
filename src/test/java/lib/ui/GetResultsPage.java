package lib.ui;

import static com.codeborne.selenide.Selenide.sleep;
import static core.BaseMethods.s$$;
import static core.PropertyReader.s;
import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;

public class GetResultsPage {

    @Step("Assert title page")
    public GetResultsPage assertTitlePage(String textTitle) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert title page");
        ss("get_result.title.text").should(Condition.visible, Condition.text(textTitle))
                .highlight();
        return this;
    }

    @Step("Click Get results")
    public GetResultsPage clickGetResults() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click Get results");
        ss("get_result.find.button").should(Condition.visible)
                .highlight()
                .click();
        return this;
    }

    @Step("Assert text error '{textError}' if empty fields")
    public GetResultsPage assertErrorEmptyFields(String textError) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert text error '" + textError + "' if empty fields");
        String text = ss("get_result.error.empty_fields").getOwnText()
                .replaceFirst(" ", " " + s$$(s("get_result.error.textBold"))
                        .texts()
                        .toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "")
                ).replace("\n", "");
        Assertions.assertEquals(textError, text);
        System.out.println("text: " + text);
        System.out.println("textError: " + textError);
        return this;
    }

    @Step("Input '{textInput}' code INZ")
    public GetResultsPage inputCodeInzAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Input '" + textInput + "' code INZ");
        ss("get_result.input.orderNumber").should(Condition.visible)
                .setValue(textInput);
        ss("get_result.input.orderNumber").should(Condition.attribute("value", textInput));
        return this;
    }

    @Step("Input '{textInput}' birthday")
    public GetResultsPage inputBirthdayAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Input '" + textInput + "' birthday");
        ss("get_result.input.birthday").should(Condition.visible).click();
        sleep(1000);
        ss("get_result.input.birthday").press("Home");
        ss("get_result.input.birthday").sendKeys(textInput);
        ss("get_result.input.birthday").should(Condition.attribute("value", textInput));
        return this;
    }

    @Step("Input '{textInput}' lastName")
    public GetResultsPage inputLastNameAndCheck(String textInput) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Input '" + textInput + "' lastName");
        ss("get_result.input.lastName").should(Condition.visible).setValue(textInput);
        ss("get_result.input.lastName").should(Condition.attribute("value", textInput));
        return this;
    }
}
