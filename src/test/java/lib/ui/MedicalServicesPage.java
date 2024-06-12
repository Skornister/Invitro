package lib.ui;

import static core.BaseMethods.s$;
import static core.BaseMethods.s$$;
import static core.PropertyReader.s;
import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;

public class MedicalServicesPage {

    @Step("Click on all menu and check titlePage")
    public MedicalServicesPage clickAllMenuAndCheckTitlePage() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on all menu and check titlePage");

        ss("MedicalServices.side-bar.item.second.text").should(Condition.visible);

        String itemSecond = s("MedicalServices.side-bar.item.second.text");
        String itemThird = s("MedicalServices.side-bar.item.third.active.text");

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

    @Step("Click on menu '{index}' and check titlePage")
    private MedicalServicesPage clickMenuAndCheckTitlePage(int index) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on menu '" + index + "' and check titlePage");

        String itemSecond = s("MedicalServices.side-bar.item.second.text");

        s$$(itemSecond).get(index)
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight()
                .click();
        String titlePage = s$$(itemSecond).get(index)
                .getText();
        ss("titlePage").should(Condition.visible, Condition.text(titlePage))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }

    @Step("Click on submenu '{index}' and check titlePage")
    private MedicalServicesPage clickSubmenuAndCheckTitlePage(int index) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click on submenu '" + index + "' and check titlePage");

        String itemThird = s("MedicalServices.side-bar.item.third.active.text");

        s$$(itemThird).get(index)
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight()
                .click();
        String titlePage = s$$(itemThird).get(index)
                .getText();
        ss("titlePage").should(Condition.visible, Condition.text(titlePage))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }
}
