package steps;

import Pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InputAnalysisCodeDef {
    private WebDriver driver;
    MainPage mainPage;

    @Given("Open main page")
    public void openMainPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.invitro.ru/radiology");
        mainPage = new MainPage(driver);
    }


    @When("Input analyse code\\({string}) in search")
    public void inputAnalyseCodeInSearch(String analysisCode) {
        mainPage.inputAnalyseCodeInSearch(analysisCode);
    }
}
