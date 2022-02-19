package steps;

import Pages.MainPage;
import Pages.ResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPageDef {
    private WebDriver driver;
    MainPage mainPage;
    ResultPage resultPage;


    @Given("Open browser {string}")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        mainPage = new MainPage(driver);
    }

    @When("Open resulPage")
    public void openResulPage() {
        mainPage = new MainPage(driver);
        mainPage.openResultPage();
    }

    @And("Click result button")
    public void clickResultButton() {
        resultPage = new ResultPage(driver);
        resultPage.clickResultBtn();
    }

    @And("Check Empty data alert and {string} alert")
    public void checkEmptyDataAlertAndAlert(String color) {
        Assert.assertEquals(resultPage.getErrorEmptyDataLabel(), resultPage.ERR_MSG_EMPTY_DATA);
        List<WebElement> elementList = resultPage.getListErrorInput();
        for (int i = 0; i < elementList.size(); i++) {
            System.out.print(elementList.get(i).getCssValue("background-color"));
            Assert.assertEquals(elementList.get(i).getCssValue("background-color"), color);
        }
    }

    @When("Input test data\\({string},{string},{string})")
    public void inputTestData(String inz, String birthday, String lastName) {
        resultPage.fillOrderInformation(inz,birthday,lastName);

    }

    @And("Click captcha button")
    public void clickCaptchaButton() {
        resultPage.clickCaptchaButton();
    }

    @Then("Check incorect alert and{string}")
    public void checkIncorectAlertAnd(String err) {
        Assert.assertEquals( resultPage.getErrorAlert(),err);
    }
}
