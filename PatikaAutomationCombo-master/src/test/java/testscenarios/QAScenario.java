package testscenarios;


import Loggers.Log;
import Loggers.ScenarioLogger;
import framework.ConfigReader;
import framework.DriverSetup;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;

import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(ScenarioLogger.class)

public class QAScenario {

    @Rule
    public TestWatcher watchman= new TestWatcher(){
        Log log = new Log();
        @Override
        protected void succeeded(Description description) {
            log.info(description.getDisplayName()+" is SUCCEEDED");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            log.error(description.getDisplayName()+" is FAILED");
        }

        @Override
        protected void starting(Description description) {
            log.info(description.getDisplayName()+" is STARTİNG");
        }

        @Override
        protected void finished(Description description) {
            log.info(description.getDisplayName()+" is FINISHED");
        }
    };



    HomePage homePage = new HomePage(DriverSetup.getDriver());
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;

    static WebDriver driver;
    static Properties properties;
    static String productUrl;




    @BeforeClass
    public static void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
    }


    @Test
    public  void t1(){
        homePage.closeVotingScreen();
    }

    @Test
    public void t2(){

        homePage.searchBoxClick();
        homePage.searchBoxSendKey("kaşık maması");
        homePage.searchBoxSendEnterKey();
    }


    @Test
    public void t3() throws InterruptedException {

        this.searchPage = new SearchPage(DriverSetup.getDriver());
        this.searchPage.scrollUntilEndThePage();
    }



    @Test
    public void t4() throws InterruptedException {

        this.searchPage = new SearchPage(DriverSetup.getDriver());
        WebElement productItem = this.searchPage.clickLastElement();

        String productUrl= productItem.findElement(By.tagName("eb-generic-link")).findElement(By.tagName("a")).getAttribute("href");

        Thread.sleep(3000);
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(currenturl,productUrl);

    }





    @Test
    public void t5(){

        this.productPage = new ProductPage(DriverSetup.getDriver());

        productPage.addProductToCart();
        productPage.showCart();
    }



    @Test
    public void t6() throws InterruptedException {

        cartPage = new CartPage(DriverSetup.getDriver());
        cartPage.complateShopping();

    }


    @Test
    public void t7() throws InterruptedException {

        this.loginPage = new LoginPage(DriverSetup.getDriver());
        loginPage.waitUntilLoadPage();

        String expectedUrl = "https://www.e-bebek.com/login?forced=true";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl);

    }


}
