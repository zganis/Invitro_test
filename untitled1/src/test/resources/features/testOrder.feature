Feature: Проверка заказа

  Scenario:Проверка заказа с пустыми значениями и тестовыми данными
    Given Open browser "https://www.invitro.ru/radiology"
    When Open resulPage
    Then Click result button
    And Check Empty data alert and "rgba(255, 255, 255, 1)" alert
    When Input test data("231231231","11122000","тест")
    And Click captcha button
    And Click result button
    Then Check incorect alert and "Пожалуйста, уточните параметры поиска"




