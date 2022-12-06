package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;

    By buttonAddCart = By.id("addToCartBtn");
    By buttonShowCart=By.id("btnShowCart");

    //ProductPage page constructor
    public ProductPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }


    //ProductPage page functions
    public void addProductToCart(){
        elementHelper.checkElementVisible(buttonAddCart);
        this.elementHelper.click(buttonAddCart);
    }

    public void showCart(){
        elementHelper.checkElementVisible(buttonShowCart);
        this.elementHelper.click(buttonShowCart);
    }

    public void waitUntilLoadPage(){
        elementHelper.checkElementVisible(buttonAddCart);
    }



}
