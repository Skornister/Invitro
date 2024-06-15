package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;
import static steps.ui.core.BaseMethods.s$$;

public class MedicalServicesPage {

    @Given("Прокликать все меню, проверяя заголовок страницы")
    public MedicalServicesPage clickAllMenuAndCheckTitlePage() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on all menu and check titlePage");

        s$(Strings.MedicalServices_side_bar_item_second_text).should(Condition.visible);

        String itemSecond = Strings.MedicalServices_side_bar_item_second_text;
        String itemThird = Strings.MedicalServices_side_bar_item_third_active_text;

        int countItemSecond = s$$(itemSecond).size();

        for (int i = 0; i < countItemSecond; i++) {
            clickMenuAndCheckTitlePage(i);

            if (s$(itemThird).is(Condition.visible)) {
                int countItemThird = s$$(itemThird).size();

                for (int y = 0; y < countItemThird; y++) {
                    clickSubmenuAndCheckTitlePage(y);
                }
            }
        }
        return this;
    }

    private MedicalServicesPage clickMenuAndCheckTitlePage(int index) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on menu '" + index + "' and check titlePage");

        String itemSecond = Strings.MedicalServices_side_bar_item_second_text;

        s$$(itemSecond).get(index)
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight()
                .click();
        String titlePage = s$$(itemSecond).get(index)
                .getText();
        s$(Strings.titlePage).should(Condition.visible, Condition.text(titlePage))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }

    private MedicalServicesPage clickSubmenuAndCheckTitlePage(int index) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on submenu '" + index + "' and check titlePage");

        String itemThird = Strings.MedicalServices_side_bar_item_third_active_text;

        s$$(itemThird).get(index)
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight()
                .click();
        String titlePage = s$$(itemThird).get(index)
                .getText();
        s$(Strings.titlePage).should(Condition.visible, Condition.text(titlePage))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }
}
