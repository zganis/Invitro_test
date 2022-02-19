Feature:Сравнить цены

  Scenario:Сравнение значения цены в разделе анализы и цену внутри корзины
    Given Open  analysis page
    Then Save price product"Выдача бланка результатов исследования на английском языке"
    When Buy product"Выдача бланка результатов исследования на английском языке" and open cart
    Then Compare prices