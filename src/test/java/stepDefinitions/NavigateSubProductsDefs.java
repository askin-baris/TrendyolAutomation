package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.MaleTshirtPage;
import pages.NavigateSubCatagoryPage;
import pages.ProductsPage;
import pages.TrendyolHomePage;
import utils.WebUtils;

public class NavigateSubProductsDefs {

    MaleTshirtPage maleTshirtPage = new MaleTshirtPage();

    @When("User navigates {string} from {string}")
    public void user_navigates_from(String subCatagoryName, String CatagoryName) {
        TrendyolHomePage homePage = new TrendyolHomePage();
        NavigateSubCatagoryPage navigateSubCatagoryPage = new NavigateSubCatagoryPage();
        navigateSubCatagoryPage.navigateCatagory(CatagoryName, subCatagoryName);

    }


    @And("User clicks first {string}")
    public void userClicksFirst(String productName) {
        ProductsPage productsPage = new ProductsPage();
        productsPage.navigateProductList(productName);
    }

    @And("User selects First Male Tshirt")
    public void userSelectsFirstMaleTshirt() throws Exception {
       MaleTshirtPage tshirtPage = new MaleTshirtPage();
       tshirtPage.closePopupGeneric();
       tshirtPage.FirstMaleTshirt.click();
       //Switch window
        WebUtils.switchWindow(tshirtPage.previousWindow);
    }
}

