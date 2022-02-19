package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPage {
    public static final String ERR_MSG_EMPTY_DATA = "Поля Код ИНЗДата рожденияФамилия обязательны для заполнения";
    WebDriver driver;


    /*
        Страница результатов анализов
     */
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }


    /*
        Сообщение ошибки при пустом вводе результатов
     */
    By errorEmptyDataLabel = By.xpath("//div[@class = 'UnauthResultsPage_error__2lFdl']");

    /*
        Поля с ошибками
    */
    private By errorInput = By.xpath("//*[@class='Input_input__2ajRx Input_error__3qf4g'] ");

    /*
        Кнопка результатов
    */
    private By resultBtn = By.xpath("//div[@class='searchResultsBlock']/button");

    /*
        Поле ввода ИНЗ
     */
    private By inputINZ = By.xpath("//input[@name='orderNumber']");

    /*
        Поле ввода даты рождения
     */
    private By inputBirthday = By.xpath("//input[@name='birthday']");

    /*
        Поле ввода фамилии
     */
    private By inputLastName = By.xpath("//input[@name='lastName']");

    /*
        Кнопка галочки каптчи
     */
    private By captchaCheck = By.xpath("//*[@title='reCAPTCHA']");

    /*
        Сообщение ошибки результата
     */
    private By errorAlert = By.xpath("//div[@class = AlertWarning_error__1Gdlm]//div");

    /*
        Заполнение информации о заказе
     */
    public ResultPage fillOrderInformation(String inz, String dateBirthday, String lastName) {
        driver.findElement(inputINZ).sendKeys(inz);
        driver.findElement(inputBirthday).click();
        driver.findElement(inputBirthday).sendKeys(dateBirthday);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    /*
        Нажать кнопку результата
     */
    public ResultPage clickResultBtn() {
        driver.findElement(resultBtn).click();
        return this;
    }

    /*
        Лейбл ошибки пустого ввода
     */
    public String getErrorEmptyDataLabel() {
        return driver.findElement(errorEmptyDataLabel).getText();
    }

    /*
        Список полей ошибок
     */
    public List<WebElement> getListErrorInput() {
        return driver.findElements(errorInput);
    }

    /*
    Нажать кнопку каптчи
     */
    public void clickCaptchaButton() {
        driver.findElement(captchaCheck).click();
    }

    /*
        Получить текст сообщения об ошибке
     */
    public String getErrorAlert() {
        return driver.findElement(errorAlert).getText();
    }
}
