package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.HelperWeb;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import tests.TestBase;

@DisplayName("Get Results")
@Features({@Feature("Get Results Page")})
public class GetResultsPageTests extends TestBase {

    @Test
    @DisplayName("Fill the fields")
    @Description("""
            нажать "получить результаты анализов", проверить заголовок страницы, что равен "Введите индивидуальный номер заказа, чтобы посмотреть результаты анализов".\s
            не заполнять поля и нажать "Найти результаты". проверить что поля выделены красным и появилось предупреждение "Поля Код ИНЗ Дата рождения Фамилия обязательны для заполнения"
                        
            заполнить поля. Пример:
            код ИНЗ:231231231
            Дата рождения: 11.12.2000
            Фамилия: тест
                        
            Проверить что в поле код ИНЗ указано 231231231
            Проверить что в поле Дата рождения указано 11.12.2000
            Проверить что в поле Фамилия указано тест
            """)
    public void testFillTheFields() {
        HelperWeb.openUrl("https://lk3.invitro.ru/no-registration-results");

        String titlePage = "Введите индивидуальный номер заказа, чтобы посмотреть результаты анализов";
        String errorEmptyFields = "Поля Код ИНЗ Дата рождения Фамилия обязательны для заполнения";
        String codeINZ = "231231231";
        String birthday = "11.12.2000";
        String lastName = "тест";

        getResultsPage.clickGetResults()
                .assertTitlePage(titlePage)
                .assertErrorEmptyFields(errorEmptyFields)
                .inputCodeInzAndCheck(codeINZ)
                .inputBirthdayAndCheck(birthday)
                .inputLastNameAndCheck(lastName);
    }
}
