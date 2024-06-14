Feature: Cart

  Background: Предварительные настройки
    Given Open url "https://www.invitro.ru/analizes/for-doctors/"

  Scenario: Добавить продукт в корзину и очистить корзину
    When Добавить продукт в корзину
    And Открыть страницу корзины
    And Проверка: Продукт в корзине
    Then Нажать кнопку Очистить корзину
    And Проверка: Корзина пуста