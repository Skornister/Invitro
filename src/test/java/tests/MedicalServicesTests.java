package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.HelperWeb;
import io.qameta.allure.Description;

@DisplayName("Medical services")
public class MedicalServicesTests extends TestBase {

    @Test
    @DisplayName("Menu on the medical services page")
    @Description("""
            в разделе медицинские услуги https://www.invitro.ru/radiology/ сделать прокликивание всего меню.
            в том числе с прокликиванием по подгруппам""")
    public void testMenuMedicalServices() {
        HelperWeb.openUrl("https://www.invitro.ru/radiology/");
        medicalServicesPage.clickAllMenu();
    }
}
