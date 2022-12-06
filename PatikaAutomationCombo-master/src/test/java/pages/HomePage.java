package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;


    By searchBox= By.id("txtSearchBox");
    By votingScreenCloseBtn = By.xpath("/html/body/div[2]/div/div[1]");


    //HomePage page constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }


    //HomePage page functions

    public void searchBoxClick(){
        elementHelper.clickForWebElementWithWait(elementHelper.findElement(searchBox),2);
    }

    public void searchBoxSendKey(String str){
        elementHelper.sendKey(searchBox,str);
    }

    public void searchBoxSendEnterKey(){
      elementHelper.sendKey(searchBox,Keys.ENTER);
    }

    public void closeVotingScreen(){
        try{
            elementHelper.checkElementVisible(votingScreenCloseBtn);
            elementHelper.click(votingScreenCloseBtn);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
