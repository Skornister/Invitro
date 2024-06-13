package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.HelperWeb;
import io.qameta.allure.Description;
import tests.TestBase;

public class CartPageTests extends TestBase {

    @Test
    @DisplayName("Assert sum product in cart")
    @Description("""
            создать шаг на запоминание суммы продукта на странице анализы https://www.invitro.ru/analizes/for-doctors/,
            добавить продукт в корзину со страницы анализы https://www.invitro.ru/analizes/for-doctors/,
            создать шаг сравнивающий сумму в корзине с запомненной суммой.
            Исходя из условий больше/меньше/равно 10000р вывести сообщение в консоль (больше или меньше) или вызвать ошибку, если равно.
            Реализовать передачу запомненной суммы между шагами

            если при добавлении продукта в корзине отобразилось два продукта, то это верно. добавляется взятие. 
            сравнивать с ценной именно у добавляемого продукта, а не у услуги взятия или их суммы.
            """)
    public void testAddProductToCart() {
        HelperWeb.openUrl("https://www.invitro.ru/analizes/for-doctors/");

        int sumInShop = shopListPage.getSumProduct();
        shopListPage.addProductToCart()
                .openPageCart();
        int sumInCart = cartPage.getSumProductInCart();
        cartPage.assertSumProductInCart(sumInShop, sumInCart);
    }

    @Test
    @DisplayName("Clear cart")
    @Description("""
            Добавить продукт в корзину
            Перейти в корзину
            Проверка: В корзине присутствует продукт
            Очистить корзину
            Проверка: В корзине нет продуктов и отображается сообщение "Ваша корзина пуста""")
    public void testClearCart() {
        HelperWeb.openUrl("https://www.invitro.ru/analizes/for-doctors/");
        shopListPage.addProductToCart()
                .openPageCart()
                .assertProductInCart()
                .clearCart()
                .assertCartEmpty();
    }
}
