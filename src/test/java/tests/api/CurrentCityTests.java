package tests.api;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("API current-city")
public class CurrentCityTests {

    @Test
    @DisplayName("Assert API response 'current-city'")
    @Description("""
            7. Сделать проверку бэк запроса curl -v -X GET 'https://www.invitro.ru/local/ajax/current-city.php?CODE=bajmak'
            Проверить код ответа и тело ответа.
            Сделать возможность из сценария Cucumber передачу параметра "CODE" в метод и проверить на городах: bajmak, moscow, london
            """)
    public void testCurrentCity() {
    }
}
