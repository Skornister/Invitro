package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.HelperWeb;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import tests.TestBase;

@DisplayName("Change City")
@Features({@Feature("Change city unit")})
public class ChangeCityUnitTests extends TestBase {

    @Test
    @DisplayName("Change city to 'Омск'")
    @Description("""
            2. поменять город. нажать на город (например Москва) -> нажать "выбрать другой" -> ввести в поиск "Омск". 
            произвести поиск и убедиться что поиск верный и после клика на результат поиска "Омск" отобразился "Омск"
            
            
            нажать на город (например Москва)
            нажать "выбрать другой"
            ввести в поиск "Омск"
            произвести поиск
            убедиться что поиск верный
            клик на результат поиска "Омск"
            отобразился "Омск\"""")
    public void testChangeCity() {
        HelperWeb.openUrl("https://www.invitro.ru");

        String city = "Омск";

        changeCityUnit.openUnitCity()
                .clickChooseAnotherCity()
                .inputSearchCity(city)
                .clickResultCity(city)
                .assertSelectedCity(city);
    }
}
