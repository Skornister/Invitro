package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import core.HelperWeb;
import io.qameta.allure.Description;
import tests.TestBase;

@DisplayName("Search page")
public class SearchPageTests extends TestBase {

    @ParameterizedTest
    @CsvSource({"1515", "1", "15"})
    @DisplayName("Search product by code")
    @Description("""
            Ввести в поисковую строку '{code}'
            Нажать кнопку Поиск
            Проверка: Отображается продукт с кодом '{code}'""")
    public void searchProductByCode(String code) {
        HelperWeb.openUrl("https://www.invitro.ru");
        searchPage.inputTextInSearchLine(code)
                .clickSearchButton()
                .assertExistSearchResult(code);
    }
}
