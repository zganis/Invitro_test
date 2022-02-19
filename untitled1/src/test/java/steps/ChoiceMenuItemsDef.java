package steps;

import Pages.MainPage;
import Pages.MenuItems;
import com.google.common.base.Enums;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ChoiceMenuItemsDef {

    private WebDriver driver;
    MainPage mainPage;

    @Given("Browser   open {string}")
    public void browserOpen(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        mainPage = new MainPage(driver);
    }

    @When("i choise {string}")
    public void iChoise(String Items) {
mainPage.clickMenuItems(MenuItems.valueOf(MenuItems.class, Items));

    }
}
