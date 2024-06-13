package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;

public class CartPageTests {

    @Test
    @DisplayName("")
    @Description("""
            создать шаг на запоминание суммы продукта на странице анализы https://www.invitro.ru/analizes/for-doctors/,
            добавить продукт в корзину со страницы анализы https://www.invitro.ru/analizes/for-doctors/,
            создать шаг сравнивающий сумму в корзине с запомненной суммой. Исходя из условий больше\\меньше\\равно 10000р вывести сообщение в консоль (больше или меньше) или вызвать ошибку, если равно. Реализовать передачу запомненной суммы между шагами
                        
            если при добавлении продукта в корзине отобразилось два продукта, то это верно. добавляется взятие. сравнивать с ценной именно у добавляемого продукта, а не у услуги взятия или их суммы.\s
            """)
    public void testAddProductToCart() {
        HelperWeb.openUrl("https://www.invitro.ru/analizes/for-doctors/");

        String sum = CartPage.getSumProduct();
        CartPage.addProductToCart();
        String newSum = CartPage.getSumProduct();
        CartPage.compareSum(newSum, sum);
    }
}
