package framework;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;


//Element helpers for whole project
public class Helper {

    WebDriver driver;
    WebDriverWait wait;

    public Helper(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By elementName)
    {

        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        return driver.findElement(elementName);
    }

    public List<WebElement> findElements(By elementName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElements(elementName);
    }

    public void click(By elementName)
    {

        findElement(elementName).click();
    }

    public void sendKey(By elementName, String text) {
        findElement(elementName).sendKeys(text);
    }
    public void sendKey(By elementName, Keys key) {
        findElement(elementName).sendKeys(key);
    }

    public void checkElementVisible(By elementName) {
        wait.until(ExpectedConditions.visibilityOf(findElement(elementName)));
    }

    public String getText(By elementName) {
        return findElement(elementName).getText();
    }

    public WebElement presenceElement(By key) {
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(key)));
    }

    public void isAssertTrue(By actualValue, String exceptedValue)
    {
        String actualText= findElement(actualValue).getText();
        assertEquals(actualText,exceptedValue);

    }

    public void typeForInput(String kw, WebElement element){
        assertEquals(element.getTagName(),"input");
        element.sendKeys(kw);
    }

    public void clickForWebElement(WebElement element){
        element.click();
    }

    public void clickForWebElementWithWait(WebElement element, int timeout){
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        element.click();
    }

}