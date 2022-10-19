package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.TrendyolHomePage;
import utils.Driver;
import utils.WebUtils;

public class NavigateMainProductDefs {

        @When("User navigates {string}")
        public void user_navigates(String catagoryName) throws InterruptedException {
                TrendyolHomePage trendyolHomePage =new TrendyolHomePage();
                CommonPage commonPage = new CommonPage();
                commonPage.navigateCatagory(catagoryName);
                Thread.sleep(3000);
                System.out.println(Driver.getDriver().getCurrentUrl());

        }
}
