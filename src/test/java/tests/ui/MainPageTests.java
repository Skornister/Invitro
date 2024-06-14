package tests.ui;

import core.HelperWeb;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import lib.ui.SideBarPopupUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tests.TestBase;

@DisplayName("Main page")
public class MainPageTests extends TestBase {

    @ParameterizedTest
    @EnumSource(SideBarPopupUnit.Section.class)
    @DisplayName("Select section in sideBar popup")
    @Description("""
            6. создать параметризованный шаг с четким указанием значений
            выбираю раздел Пациентам
            где вместо "Пациентам" можно указать значения: Пациентам, Врачам, Франчайзинг, Корпоративным клиентам, Прессе.
            другие значения нельзя будет указать
            
            
            Открыть боковую панель
            Выбрать секцию '{section}' из enum
            Проверка: Выбрана секция '{section}'""")
    @Features({@Feature("SideBarPopup"), @Feature("Header")})
    public void selectSection(SideBarPopupUnit.Section section) {
        HelperWeb.openUrl("https://www.invitro.ru");
        sideBarPopupUnit.openSideBarPopup()
                .selectSection(section.getDisplayName())
                .assertSelectedSection(section.getDisplayName());
    }
}
