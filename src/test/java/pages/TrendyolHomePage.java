package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.WebUtils;

import java.time.Duration;

public class TrendyolHomePage {

    public TrendyolHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public void closeCookiesAndPopup(){
        closeHomePagePopup();
        closeCookiesContainer();

    }


//    static {
//        static code block, her contructordan önce çalışır ve static 1 defa çalışır.
//    }
    /*  {
        code block, her constructordan önce çalışır
    }*/
    /**Trendyol anasayfasına gittiğimizde açılan ilk pop-up için locator.
     * Bu locator kullanılarak açılan pop-up'ı otomatik olarak kapatmaya çalışacağız.
     */
    @FindBy(className = "homepage-popup")
    public WebElement homePagePopup;

    @FindBy(className = "ot-sdk-container")
    public WebElement cookiesContainer;

    @FindBy(xpath = "//p[contains(text(),'Hesabım')]")
    public WebElement Hesabım;

    @FindBy(xpath = "(//p[@class='link-text'])[1]")
    public WebElement girisYap;

    public void closeHomePagePopup() {
        if (homePagePopup.isDisplayed()) {
            Driver.getDriver().findElement(By.className("modal-close")).click();

        }
    }
    public void closeCookiesContainer() {
            if (cookiesContainer.isDisplayed()) {
                Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
            }
        }
/*        try {cookiesContainer.isDisplayed();

            Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }*/

    public void navigateLoginPage(){
        WebElement linkAccountUser = Driver.getDriver().findElement(By.xpath("//div[@class='link account-user']"));

        WebUtils.waitFor();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(linkAccountUser).perform();

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Giriş Yap')]"));
        loginButton.click();
    }



    public boolean checkSuccessfulLogin(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Hesabım));
        return Hesabım.isDisplayed();
    }

    public void girisYap(){
        WebUtils.moveToElement(girisYap);
        Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Giriş Yap')]")).click();
        //Driver.getDriver().findElement(By.className("login-container")).click();
    }

    public void searchBox(){
        WebElement search= Driver.getDriver().findElement(By.xpath("//input[@data-testid='suggestion']"));
        search.click();
        search.sendKeys("ayakkabı");
        search.sendKeys(Keys.ENTER);

    }

    }
