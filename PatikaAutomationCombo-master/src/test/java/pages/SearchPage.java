package pages;

import framework.Helper;
import org.openqa.selenium.*;

import java.util.List;

public class SearchPage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;
    JavascriptExecutor js;

    int productIncreasingNum=12;

    By productNumberParagraph = By.xpath("//div/p/span");
    By availableProductButton = By.xpath("//eb-product-list-item/div");
    List<WebElement> products;



    //SearchPage page constructor
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
        this.js = ((JavascriptExecutor) driver);
    }



    //SearchPage page methods
    public void scrollUntilEndThePage() throws InterruptedException {
        elementHelper.checkElementVisible(availableProductButton);

        int productNumber=0;
        try {
            productNumber = Integer.valueOf(driver.findElement(productNumberParagraph).getText());
            productNumber = productNumber-12;
            System.out.println("---"+productNumber);
            int pages = (int)productNumber/productIncreasingNum;
            System.out.println("---"+pages);
            int x =0;
            for (int i=0; i<=pages; i++){
                x+=1800;
                js.executeScript("scroll(0, "+x+")");
                Thread.sleep(2000);
            }



        }catch (Exception e){

        }
    }



    private void storeAvailableProducts(){
        this.products = elementHelper.findElements(availableProductButton);
    }

    private WebElement findLastAvailableProduct(){

        this.storeAvailableProducts();
        int size = this.products.size();

        WebElement element=null;
        String buttonText;

        for(int i =size-1; i>=0; i--){
            element= this.products.get(i);
            buttonText = element.findElement(By.tagName("button")).getText();

            if(buttonText.equals("Sepete Ekle"))
                break;
        }

        return element;

    }



    public WebElement clickLastElement(){

        WebElement element = this.findLastAvailableProduct();
        elementHelper.clickForWebElementWithWait(element,2);
        return element;

    }







}
