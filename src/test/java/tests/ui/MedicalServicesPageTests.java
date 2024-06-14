package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.HelperWeb;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import tests.TestBase;

@DisplayName("Medical services")
@Features({@Feature("Medical services page")})
public class MedicalServicesPageTests extends TestBase {

    @Test
    @DisplayName("Menu on the medical services page")
    @Description("""
            1. в разделе медицинские услуги https://www.invitro.ru/radiology/ сделать прокликивание всего меню.
            в том числе с прокликиванием по подгруппам
            
            
            Открыть сайт https://www.invitro.ru/radiology/
            Выбрать элемент меню второго уровня
            """)
    public void testMenuMedicalServices() {
        HelperWeb.openUrl("https://www.invitro.ru/radiology/");
        medicalServicesPage.clickAllMenuAndCheckTitlePage();
    }
}
