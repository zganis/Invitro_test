Feature: Смена города

  Scenario:Смена города и проверка смены города
    Given Browser is open "https://www.invitro.ru/radiology"
    When Open change city input
    And Input city"Омск"
    And Choice city
    Then Assert current city and "Омск"
