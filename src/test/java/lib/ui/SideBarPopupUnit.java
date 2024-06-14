package lib.ui;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static core.BaseMethods.s$$;
import static core.PropertyReader.s;
import static core.PropertyReader.ss;

public class SideBarPopupUnit {

    public enum Section {
        PATIENT("Пациентам"),
        DOCTORS("Врачам"),
        FRANCHIZE("Франчайзинг"),
        MEDICAL("Корпоративным клиентам"),
        ABOUT("Прессе");

        private final String displayName;

        Section(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @Step("Open sideBar popup")
    public SideBarPopupUnit openSideBarPopup() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open sideBar popup");
        ss("header.sideBar.popup").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @Step("Select section '{section}'")
    public SideBarPopupUnit selectSection(String section) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Select section '" + section + "'");

        s$$(s("header.sideBar.popup.item")).find(Condition.text(section))
                .should(Condition.visible);

        if (s$$(s("header.sideBar.popup.item")).find(Condition.text(section))
                .is(Condition.attributeMatching("class", ".*active.*"))) {
            closeSideBarPopup();
        } else {
            s$$(s("header.sideBar.popup.item")).find(Condition.text(section))
                    .should(Condition.visible)
                    .highlight()
                    .click();
        }
        return this;
    }

    @Step("Close sideBar popup")
    public SideBarPopupUnit closeSideBarPopup() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Close sideBar popup");
        ss("header.sideBar.popup.close").should(Condition.visible)
                .highlight()
                .click();
        ss("header.sideBar.popup.close").shouldNot(Condition.visible);
        return this;
    }

    @Step("Assert: Selected section '{section}'")
    public SideBarPopupUnit assertSelectedSection(String section) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: Selected section '" + section + "'");

        ss("header.sideBar.popup").should(Condition.visible, Condition.text(section))
                .highlight();
        return this;
    }
}
