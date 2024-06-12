package core;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

public class BaseMethods {

    /**
     * Возвращает SelenideElement в зависимости от переданного локатора с типом.
     *
     * @param locator локатор.
     * @return SelenideElement, соответствующий локатору.
     * @throws IllegalArgumentException если локатор имеет неподдерживаемый тип или не удается получить локатор.
     */
    public static SelenideElement s$(String locator) {
        try {
            return isXPath(locator) ? $x(locator) : $(By.cssSelector(locator));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Не удается получить locator: " + isXPath(locator));
        }
    }

    /**
     * Возвращает ElementsCollection в зависимости от переданного локатора.
     */
    public static ElementsCollection s$$(String locator) {
        if (isXPath(locator)) {
            return $$x(locator);
        } else {
            return $$(locator);
        }
    }

    /**
     * Определяет, является ли переданный локатор XPath.
     *
     * @param locator строка локатора.
     * @return true, если локатор является XPath, в противном случае - false.
     */
    private static boolean isXPath(String locator) {
        return locator.contains("//") || locator.contains("hierarchy") || locator.contains("{") || locator.contains("@resource-id");
    }
}