package lib.ui;

import static core.PropertyReader.ss;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;

public class ChangeCityUnit {

    @Step("Open unit city_label in header")
    public ChangeCityUnit openUnitCity() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Open unit city_label in header");
        ss("header.unit.city_label").should(Condition.visible)
                .click();
        ss("header.unit.city_label.change").should(Condition.visible);
        return this;
    }

    @Step("Click Choose another city")
    public ChangeCityUnit clickChooseAnotherCity() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click Choose another city");
        ss("header.unit.city_label.change.button").should(Condition.visible)
                .click();
        ss("search_city").should(Condition.visible)
                .highlight();
        return this;
    }

    @Step("Input text '{city}' in search city field")
    public ChangeCityUnit inputSearchCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Input text '" + city + "' in search city field");
        ss("search_city.input").should(Condition.visible)
                .setValue(city);
        ss("search_city.result").should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }

    @Step("Click result city '{city}'")
    public ChangeCityUnit clickResultCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Click result city '" + city + "'");
        ss("search_city.result").should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .click();
        return this;
    }

    @Step("Assert selected city '{city}'")
    public ChangeCityUnit assertSelectedCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Assert selected city '" + city + "'");
        ss("header.unit.city_label").should(Condition.visible, Condition.exactText(city))
                .scrollIntoView("{behavior: 'instant', block: 'center', inline: 'center'}")
                .highlight();
        return this;
    }
}
