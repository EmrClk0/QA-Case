package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;

    By btnSubmitLogin = By.id("btnSubmitLogin");

    //LoginPage page constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }


    //LoginPage page functions
    public void waitUntilLoadPage(){
        elementHelper.checkElementVisible(btnSubmitLogin);
    }
}
