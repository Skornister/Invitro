package steps.ui;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.ui.core.Strings;

import static steps.ui.core.BaseMethods.s$;
import static steps.ui.core.BaseMethods.s$$;

public class CartPage {

    static int rememberedPrice;
    static int productPriceInCart;

    @When("Добавить продукт в корзину")
    public static void addProductToCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Добавить продукт в корзину");
        s$(Strings.shop_product_addToCard).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
    }

    @And("Получить сумму продукта в списке анализов")
    public static void getSumProduct() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Получить сумму продукта в списке анализов");
        rememberedPrice = Integer.parseInt(s$(Strings.shop_product_price)
                .should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText()
                .replaceAll("[^0-9]", ""));
    }

    @And("Открыть страницу корзины")
    public static void openPageCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Открыть страницу корзины");
        s$(Strings.header_cart).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
    }

    @And("Получить сумму продуктов в корзине")
    public static void getSumProductInCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Получить сумму продуктов в корзине");
        productPriceInCart = Integer.parseInt(s$$(Strings.cart_label).find(Condition.text("Продукты"))
                .should(Condition.visible)
                .parent()
                .find(Strings.cart_sum)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .getText()
                .replaceAll("[^0-9]", ""));
    }

    @Then("Проверка: Сумма продуктов в корзине равна с запомненной ценой")
    public static void assertSumProductInCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: Сумма продуктов в корзине равна с запомненной ценой");
        Assert.assertEquals("> ERROR: Сумма в корзине " + rememberedPrice + " не равна " + productPriceInCart, rememberedPrice, productPriceInCart);
    }

    @And("Сравнить сумму продуктов с {int}")
    public static void assertSumProductInCartWithInt(int sum) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Сравнить сумму продуктов с " + sum);

        //больше или меньше - вывести в консоль соответствующее сообщение
        if (productPriceInCart > sum) {
            System.out.println("Сумма в корзине больше " + sum);
        } else if (productPriceInCart < sum) {
            System.out.println("Сумма в корзине меньше " + sum);
        } else {
            //если равно - вызвать ошибку с произвольным сообщением об ошибке
            throw new AssertionError("> Сумма в корзине равна 10000");
        }
    }

    @Given("Проверка: Продукт в корзине")
    public static void assertProductInCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка: Продукт в корзине");
        s$(Strings.cart_product).should(Condition.visible)
                .highlight();
    }

    @Given("Нажать кнопку Очистить корзину")
    public static void clearCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Нажать кнопку Очистить корзину");
        s$(Strings.cart_clear).should(Condition.visible)
                .scrollIntoView("{behavior: 'instant', block: 'center'}")
                .highlight()
                .click();
    }

    @Given("Проверка: Корзина пуста")
    public static void assertCartEmpty() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert: Cart is empty");
        s$(Strings.cart_product).shouldNot(Condition.visible);
        s$(Strings.cart_empty_text).should(Condition.text("Ваша корзина пуста"))
                .highlight();
    }
}
