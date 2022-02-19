package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    WebDriver driver;

    //Страница корзины
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /*
        Цена корзины
     */
    By cartPrice = By.xpath("//div[@class = 'SummaryBlock_cartCosts__2wku_']//span");

    public String getCartPrice() {
        return driver.findElement(cartPrice).getText().replaceAll("[^\\d]", "");
    }

}
