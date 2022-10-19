package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.TrendyolHomePage;
import utils.Driver;
import utils.WebUtils;

import java.time.Duration;

public class LoginDefs {
    TrendyolHomePage trendyolHomePage = new TrendyolHomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User on the Trendyol page")
    public void user_on_the_trendyol_page() {
        Driver.getDriver().get("https://www.trendyol.com/");
        trendyolHomePage.closeHomePagePopup();
    }

    @When("User navigates the login page")
    public void user_navigates_the_login_page() throws InterruptedException {


        trendyolHomePage.navigateLoginPage();

    }

    @When("User types username and password on Login page")
    public void user_types_username_and_password_on_login_page() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @Then("Verify that successful login")
    public void verify_that_successful_login() throws Exception {
        Thread.sleep(2000);

        Assertions.assertTrue(trendyolHomePage.checkSuccessfulLogin());
    }

    @And("User types invalid username and valid password on Login page")
    public void userTypesInvalidUsernameAndValidPasswordOnLoginPage() {

        loginPage.invalidLogin();
    }

    @Then("Verify that unsuccessful login")
    public void verifyThatUnsuccessfulLogin() {
        Assertions.assertTrue(loginPage.checkLoginErrorMessage());
/*        //WebElement methodunu Login Page'den çağırabiliriz.
        Assertions.assertTrue(loginPage.checkErrorMessage().isDisplayed());*/
    }
}

