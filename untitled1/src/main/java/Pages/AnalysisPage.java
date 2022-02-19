package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class AnalysisPage {
    WebDriver driver;

    /*
        Страница анализов
     */
    public AnalysisPage(WebDriver driver) {
        this.driver = driver;
    }


    /*
       Цена анализа
    */
    private String analysPrice = ("//*[contains(text(),'%s')]/../../following-sibling::div/span");

    /*
       Кнопка покупки анализа
     */
    private String buyBtn = "//*[contains(text(),'%s')]/../../following-sibling::div/div";


    /*
        Кнопка корзины
     */
    private By cartBtn = By.xpath("//div[@class = 'invitro-header-cart__icon']/a");

    /*
         Получить цену анализа по его цене
     */
    public String getAnalysPrice(String nameAnalys) {
        String price;
        price = driver.findElement(By.xpath(String.format(analysPrice, nameAnalys))).getText();
        return price.replaceAll("[^\\d]", "");
    }

    /*
        Добавить в корзину анализ
     */
    public void buyAnalysys(String nameAnalys) {
        driver.findElement(By.xpath(String.format(buyBtn, nameAnalys))).click();
        driver.findElement(By.xpath(String.format(buyBtn, nameAnalys))).click();
    }


}
