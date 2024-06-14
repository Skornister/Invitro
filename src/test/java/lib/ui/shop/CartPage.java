package lib.ui.shop;

import static core.BaseMethods.s$$;
import static core.PropertyReader.s;
import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class CartPage {

    @Step("Get sum product in cart")
    public static int getSumProductInCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get sum product in cart");
        return Integer.parseInt(s$$(s("cart.label")).find(Condition.text("Продукты"))
                .should(Condition.visible)
                .parent()
                .find(s("cart.sum"))
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText()
                .replaceAll("[^0-9]", ""));
    }

    @Step("Assert: Product in cart")
    @Given("Проверка: Продукт в корзине")
    public CartPage assertProductInCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: Product in cart");
        ss("cart.product").should(Condition.visible)
                .highlight();
        return this;
    }

    @Step("Clear cart")
    @Given("Нажать кнопку Очистить корзину")
    public CartPage clearCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Clear cart");
        ss("cart.clear").should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
        return this;
    }

    @Step("Assert: Cart is empty")
    @Given("Проверка: Корзина пуста")
    public CartPage assertCartEmpty() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: Cart is empty");
        ss("cart.product").shouldNot(Condition.visible);
        ss("cart.empty.text").should(Condition.text("Ваша корзина пуста"))
                .highlight();
        return this;
    }

    @Step("Assert sum product in cart")
    public CartPage assertSumProductInCart(int sumInShop, int sumInCart) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert sum product in cart");
        if (sumInShop == sumInCart) {
            throw new AssertionError("> ERROR: The sum in the cart is equal to the sum in the shop / Сумма в корзине равна сумме в магазине:\n" + sumInShop + " = " + sumInCart);
        } else {
            System.out.println("> The sum in the cart is not equal to the sum in the shop / Сумма в корзине не равна сумме в магазине:\n" + sumInShop + " != " + sumInCart);
        }
        return this;
    }
}
