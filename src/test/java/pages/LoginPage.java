package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AccontInformation;
import utils.Driver;

import java.time.Duration;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    public void login(){
        WebElement email = Driver.getDriver().findElement(By.id("login-email"));
        WebElement password = Driver.getDriver().findElement(By.id("login-password-input"));
        email.sendKeys(AccontInformation.ValidEmail);
        password.sendKeys(AccontInformation.ValidPassword);
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.submit();
    }
    public void invalidLogin(){
        WebElement email = Driver.getDriver().findElement(By.id("login-email"));
        WebElement password = Driver.getDriver().findElement(By.id("login-password-input"));
        email.sendKeys(AccontInformation.InvalidEmail);
        password.sendKeys(AccontInformation.ValidPassword);
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.submit();
    }

    @FindBy(xpath = "//span[contains(text(),'E-posta adresiniz ve/veya şifreniz hatalı.')]")
    public WebElement LoginErrorMessage;




        public boolean checkLoginErrorMessage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(LoginErrorMessage));
        return LoginErrorMessage.isDisplayed();
    }

/*    // WebElement methoduyla'da check, verify işlemleri yapılabilir.
        public WebElement checkErrorMessage(){
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(LoginErrorMessage));
        } */
}
