package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class MainPage {
    WebDriver driver;

    /*
        Базовая страница
     */
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    /*
        Блок бокового меню
    */
    private By menuItems = By.xpath("//div[@class='side-bar-second']/descendant::a");

    /*
        Лейбл текущего города
    */
    private By сityLabel = By.cssSelector(".city__label");

    /*
        Кнопка смены города
     */
    private By choiceCityBtn = By.cssSelector("span.city__name:nth-child(1)");

    /*
        Поле ввода города
    */
    private By inputCity = By.xpath("//input[@class = 'change-city-search-input']");

    /*
        Первый город в поиске
    */
    private By firstCity = By.xpath("//div[@class='eac-item']/b");

    /*
        Ссылка на страницу результатов
     */
    private By resultPage = By.xpath("//a[@class='invitro_header-get_result']");

    /*
        Ссылка на страницу анализов
     */
    private By analysisPage = By.xpath("//div[@class='invitro_footer-btn_part1']/a[@href = '/analizes/for-doctors/']");

    /*
        поле поиска
     */
    private By searchInput = By.xpath("//input[@class = 'search__input form-header-search_input']");


    /*
        Открыть страницу результатов
     */
    public void openResultPage() {
        driver.findElement(resultPage).click();
    }

    /*
        Открыть страницу анализов
     */
    public void openAnalysysPage() {
        driver.findElement(analysisPage).click();
    }

    /*
      Прокликивание бокового меню со всеми вложениями
    */
    public void clickSideMenu() {
        List<WebElement> elementList = driver.findElements(menuItems);
        int numberOfListElements = elementList.size();
        for (int i = 0; i < numberOfListElements; i++) {
            driver.findElements(menuItems).get(i).click();
        }
    }

    /*
        Нажать на кнопку смены города
    */
    public void openChangeCityInput() {
        driver.findElement(By.cssSelector("a.city__change-btn")).click();
    }

    /*
        Ввести город в поле
    */
    public void inputCity(String city) {
        Actions builder = new Actions(driver);
        Action keyPressed = builder.sendKeys(city).build();
        driver.findElement(inputCity).click();
        keyPressed.perform();
    }

    /*
        Выбрать город
    */
    public void choiceCity() {
        driver.findElement(firstCity).click();
    }

    /*
        Текуший город
    */
    public String getCurrentCity() {
        return driver.findElement(сityLabel).getText();
    }

    /*
        Ввод текста в поиск
     */
    public void inputAnalyseCodeInSearch(String code) {
        driver.findElement(searchInput).sendKeys(code);
    }

    public void clickMenuItems(MenuItems menuItems) {

        switch (menuItems) {
            case WRITE_TO_DOCTOR:
                System.out.print("Выбрана запись к доктору");
                break;
            case ADDRESS:
                System.out.print("Выбран адрес");
                break;
            case ANALYSIS:
                System.out.print("Выбраны анализы");
                break;
            case PROMOTION:
                System.out.print("Выбраны акции");
                break;
        }
    }
}

