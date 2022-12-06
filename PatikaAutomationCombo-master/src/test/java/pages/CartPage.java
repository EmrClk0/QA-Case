package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;

    By buttonCompleteShopping = By.id("btnGoToShippingAddress");


    //CartPage page constructor
    public CartPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void complateShopping(){
        elementHelper.checkElementVisible(buttonCompleteShopping);
        elementHelper.click(buttonCompleteShopping);
    }


}
