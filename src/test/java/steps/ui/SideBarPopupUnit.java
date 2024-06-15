package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;
import static steps.ui.core.BaseMethods.s$$;

public class SideBarPopupUnit {

    @Given("Открыть боковую панель popup")
    public SideBarPopupUnit openSideBarPopup() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Открыть боковую панель popup");
        s$(Strings.header_sideBar_popup).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @When("Выбрать секцию '{string}'")
    public SideBarPopupUnit selectSection(String section) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Выбрать секцию '" + section + "'");

        s$$(Strings.header_sideBar_popup_item).find(Condition.text(section))
                .should(Condition.visible);

        if (s$$(Strings.header_sideBar_popup_item).find(Condition.text(section))
                .is(Condition.attributeMatching("class", ".*active.*"))) {
            closeSideBarPopup();
        } else {
            s$$(Strings.header_sideBar_popup_item).find(Condition.text(section))
                    .should(Condition.visible)
                    .highlight()
                    .click();
        }
        return this;
    }

    @When("Закрыть боковую панель popup")
    public SideBarPopupUnit closeSideBarPopup() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Закрыть боковую панель popup");
        s$(Strings.header_sideBar_popup_close).should(Condition.visible)
                .highlight()
                .click();
        s$(Strings.header_sideBar_popup_close).shouldNot(Condition.visible);
        return this;
    }

    @Then("Проверка: Выбрана секция '{string}'")
    public SideBarPopupUnit assertSelectedSection(String section) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: Выбрана секция '" + section + "'");

        s$(Strings.header_sideBar_popup).should(Condition.visible, Condition.text(section))
                .highlight();
        return this;
    }
}
