package steps;

import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClickAllSideMenuDef {
    private WebDriver driver;
    MainPage mainPage;


    @Given("Open {string}")
    public void open(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        mainPage = new MainPage(driver);
    }

    @Then("Click Side Menu items")
    public void clickSideMenuItems() {
        mainPage.clickSideMenu();
    }

    @And("Quit")
    public void quit() {
        driver.quit();
    }
}
