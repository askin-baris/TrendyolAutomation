package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.WebUtils;

import java.time.Duration;
import java.util.List;

public class CommonPage {
    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='main-nav']//li[@class='tab-link']/a")
    public List<WebElement> catagories;
    @FindBy(xpath = "//input[@data-testid='suggestion']")
    public WebElement productSearchBox;

    public void navigateCatagory(String catagoryName) {
        for (WebElement catagory : catagories) {
            if (catagory.getText().equalsIgnoreCase(catagoryName)) {
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(catagory).perform();
                try {
                    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(catagory)).click();
                } catch (Exception e) {

                }

            }

        }
    }

    public void searchProductonSearchbox(String productName){
        WebUtils.waitForClick(productSearchBox);
        productSearchBox.click();
        productSearchBox.sendKeys(productName);
        productSearchBox.sendKeys(Keys.ENTER);

    }
}
