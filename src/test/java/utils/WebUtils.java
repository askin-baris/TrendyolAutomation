package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebUtils {

    public static void waitFor(){
      try {
          Thread.sleep(2000);
      }
      catch (InterruptedException e){
          throw new RuntimeException(e);
      }
    }
    public static void waitForClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void switchWindow(String previousWindow){

        for (String windowHandle:Driver.getDriver().getWindowHandles()){ //
            if(!windowHandle.equals(previousWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

    }

    public static void switchWindow(String pageTitle, int n){                //Trendyol
        for (String windowHandle:Driver.getDriver().getWindowHandles()) {   //00012435478Amazon
            Driver.getDriver().switchTo().window(windowHandle);
            if (Driver.getDriver().getTitle().equals(pageTitle)) { //Trenyol
                break;
            }//Amazon
        }

    }

    public static void switchWindow(String pageUrl, double n){                //cart
        for (String windowHandle:Driver.getDriver().getWindowHandles()) {   //00012435478Amazon
            Driver.getDriver().switchTo().window(windowHandle);
            if (Driver.getDriver().getCurrentUrl().contains(pageUrl)) { //amazon/cart
                break;
            }//Amazon
        }

    }

}
