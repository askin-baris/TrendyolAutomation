package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class NavigateSubCatagoryPage {
    public NavigateSubCatagoryPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//ul[@class='main-nav']//li[@class='tab-link']/a")
    public List<WebElement> catagories;

  public void navigateCatagory(String catagoryName,String subCatagoryName) {
      for (WebElement catagory : catagories) {
          if (catagory.getText().equalsIgnoreCase(catagoryName)) {
              Actions actions = new Actions(Driver.getDriver());
              actions.moveToElement(catagory).perform();
                  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='"+ catagoryName +"']/..//a[.='"+ subCatagoryName +"']"))).click();
                  break;
          }

          }

      }
  }
