package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MaleTshirtPage;
import pages.TrendyolHomePage;
import utils.Driver;
import utils.WebUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

//    private static WebDriver driver;       // test adımlarımızı tarayıcımız üzerinden çalıştırmamızı yardımcı olur.
    TrendyolHomePage trendyolHomePage = new TrendyolHomePage();
    @Given("trendyol yüklenir")
    public void trendyol_homepage()
    {
/*        WebDriverManager.chromedriver().setup();              //sistem özelliğinin adı ve değeri tanımlanır.
        driver=new ChromeDriver();                                                     //google chrome'un açılmasını sağlıyoruz
        driver.manage().window().maximize();                                           //WebDriver tarayıcı penceresinin büyütülmesini destekler
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);           //sayfanın yüklenmesi için 60 saniye bekler.
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);           //sayfadaki öğeleri bulmaya çalışırken belirli bir süre beklemesini ifade eder.

        driver.get("https://www.trendyol.com/");*/
        Driver.getDriver().get("https://www.trendyol.com/");
        //Driver.getDriver().findElement(By.className("fancybox-close")).click();
        trendyolHomePage.closeHomePagePopup();
    }

    @When("giriş yap ikonuna tıklanır")
    public void click_login_icon()
    {
        trendyolHomePage.girisYap();
    }

    @Then("eposta adresi girilir")
    public void fill_email()
    {
        /*WebElement email=Driver.getDriver().findElement(By.name("email"));
        email.sendKeys("example@gmail.com"); //bulunan alana veri gönderilmesini sağlar.*/
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

   /* @And("şifre girilir")
    public void fill_password()
    {
        WebElement password=Driver.getDriver().findElement(By.name("password"));
        password.sendKeys("sifre1234");
    }*/

/*    @And("giriş yap butonuna tıklanır")
    public void click_sign() throws InterruptedException {
        WebElement login=Driver.getDriver().findElement(By.id("loginSubmit"));
        login.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }*/

    @And("ürün araması yapılır")
    public void search_product() throws Exception
    {
        Thread.sleep(2000);
        WebElement search=Driver.getDriver().findElement(By.xpath("//input[@data-testid='suggestion']"));
        search.click();
        search.sendKeys("ayakkabı");
        search.sendKeys(Keys.ENTER);
    }

    @And("ürüne tıklanır")
    public void Click_product()
    {

        // Assume driver is a valid WebDriver instance that
        // has been properly instantiated elsewhere.


        /*List<WebElement> products= Driver.getDriver().findElements(By.className("p-card-wrppr"));
        //Driver.getDriver().findElement(By.xpath("//div[@class='p-card-wrppr with-campaign-view'][1]")).click();
        System.out.println(products.size());
        int counter=1;
        for (WebElement product:products) {
            System.out.println(product.getText());
            if (product.getText().contains("SlipcatUnisex Içi Yünlü Ev Pandufu Ev Botu Ev Ayakkabısı")){
                //product.click();
                JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
                executor.executeScript("arguments[0].click();", product);
                break;
            }
            counter++;
        }*/
        MaleTshirtPage maleTshirtPage = new MaleTshirtPage();
        maleTshirtPage.closePopupGeneric();
        WebUtils.waitFor();
        Driver.getDriver().findElement(By.xpath("//div[@class='p-card-wrppr with-campaign-view'][2]//a")).click();

        //products.get(2).click();
    }

    @And("ürün numarası seçilir")
    public void AddToBasket()
    {
        String number ="40";
        Driver.getDriver().findElement(By.className("pr-in-sz-pk")).click();
        List<WebElement> number1= Driver.getDriver().findElements(By.tagName("li"));
        for (WebElement option : number1)
        {
            if (option.getText().equals(number))
            {
                option.click();
                break;
            }
        }
    }


    @And("ürün listeleme ekranına geri dönülür")
    public void BackProduct()
    {

        Driver.getDriver().findElement(By.linkText("Spor Ayakkabı")).click();
    }

    @And("ürün numarası seçilir {string}")
    public void ürünNumarasıSeçilir(String number) {

        Driver.getDriver().findElement(By.className("pr-in-sz-pk")).click();
        List<WebElement> number1= Driver.getDriver().findElements(By.tagName("li"));
        for (WebElement option : number1)
        {
            if (option.getText().equals(number))
            {
                option.click();
                break;
            }
        }
    }
}