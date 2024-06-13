package lib.ui;

import io.qameta.allure.Step;

public class CartPage {

    @Step
    public static void openPageCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open page cart");
        ss("header.cart").click();
    }

    @Step
    public static String getSumProduct() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get sum product");
        return ss("sum_product").getText();
    }

    @Step
    public static void addProductToCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Add product to cart");
        ss("add_product_to_cart").click();
    }

    @Step
    public static void compareSum(String newSum, String sum) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Compare sum");
        Assertions.assertEquals(newSum, sum);
    }

    @Step
    public static void clearCart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Clear cart");
        ss("clear_cart").click();
    }
}
