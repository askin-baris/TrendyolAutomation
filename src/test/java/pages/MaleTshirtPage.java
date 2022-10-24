package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.WebUtils;

import java.util.Set;

public class MaleTshirtPage {

    public MaleTshirtPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void closePopupGeneric(){
        closePopup();

    }
    //@FindBy(xpath = "//div[@class='prdct-cntnr-wrppr']/div[2]")
    @FindBy(xpath = "//div[@class='prdct-cntnr-wrppr']/div[contains(@class,'campaign')]")
    public WebElement FirstMaleTshirt;

    @FindBy(className = "popup")
    public WebElement popup;

    public void closePopup() {
        if (popup.isDisplayed()) {
            WebUtils.waitFor();
            Driver.getDriver().findElement(By.cssSelector(".overlay")).click();
        }
    }


    public String previousWindow = Driver.getDriver().getWindowHandle();

    public void deneme(){
       for (String windowHandle:Driver.getDriver().getWindowHandles()){ //
        if(!windowHandle.equals(previousWindow))
        {
            Driver.getDriver().switchTo().window(windowHandle);
            break;
        }
    }
    }



}
