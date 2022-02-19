package steps;

import Pages.AnalysisPage;
import Pages.CartPage;
import Pages.MainPage;
import Pages.ResultPage;
import com.beust.ah.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ComparePriceDef {

    private WebDriver driver;
    AnalysisPage analysisPage;
    CartPage cartPage;
    String price;

    @Given("Open  analysis page")
    public void openAnalysisPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.invitro.ru/analizes/for-doctors/");
        analysisPage = new AnalysisPage(driver);
    }


    @Then("Save price product{string}")
    public void savePriceProduct(String productName) {
        price = analysisPage.getAnalysPrice(productName);
    }

    @When("Buy product{string} and open cart")
    public void buyProductAndOpenCart(String productName) {
        analysisPage.buyAnalysys(productName);
        cartPage = new CartPage(driver);
    }

    @Then("Compare prices")
    public void comparePrices() {

        Assert.assertEquals(price, cartPage.getCartPrice());

    }
}
