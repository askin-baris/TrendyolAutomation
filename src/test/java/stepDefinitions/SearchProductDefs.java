package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import utils.Driver;

import java.time.Duration;

public class SearchProductDefs {
    @And("User searches {string} on searchbox")
    public void userSearchesOnSearchbox(String productName) throws Exception {
        Thread.sleep(3000);
        CommonPage commonPage = new CommonPage();
        commonPage.searchProductonSearchbox(productName);

    }
}
