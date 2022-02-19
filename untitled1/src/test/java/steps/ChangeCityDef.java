package steps;

import Pages.MainPage;
import Pages.ResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChangeCityDef {
    private WebDriver driver;
    MainPage mainPage;


    @Given("Browser is open {string}")
    public void browserIsOpen(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        mainPage = new MainPage(driver);
    }

    @When("Open change city input")
    public void openChangeCityInput() {
        mainPage.openChangeCityInput();
    }

    @And("Input city{string}")
    public void inputCity(String city) {
        mainPage.inputCity(city);
    }

    @And("Choice city")
    public void choiceCity() {
        mainPage.choiceCity();
    }

    @Then("Assert current city and {string}")
    public void assertCurrentCityAnd(String city) {
        Assert.assertEquals(mainPage.getCurrentCity(), city);
    }


}
