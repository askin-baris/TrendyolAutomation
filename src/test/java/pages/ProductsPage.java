package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='image-overlay-body']")
    public List<WebElement> productList;


    public void navigateProductList(String productName) {
        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase(productName)) {
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(product).perform();
                try {
                    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
                } catch (Exception e) {

                }
            break;
            }

        }
    }
}
