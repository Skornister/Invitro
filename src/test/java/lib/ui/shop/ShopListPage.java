package lib.ui.shop;

import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class ShopListPage {

    @Step("Get sum product")
    public static int getSumProduct() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get sum product");
        return Integer.parseInt(ss("shop.product.price")
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText()
                .replaceAll("[^0-9]", ""));
    }

    @Step("Add product to cart")
    @Given("Добавить продукт в корзину")
    public ShopListPage addProductToCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Add product to cart");
        ss("shop.product.addToCard").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @Step("Open Cart page")
    @Given("Открыть страницу корзины")
    public CartPage openPageCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open Cart page");
        ss("header.cart").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return new CartPage();
    }
}
