package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Action extends TestBase {

    @Test
    public void rightClickTest() throws InterruptedException {
        Driver.getDriver().get("https://ebay.de/");
        WebElement element = Driver.getDriver().findElement(By.id("hot-spot"));
        Driver.wait(2);
        actions.contextClick(element).perform();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
    }
    @Test
    public void keyUpDown() throws InterruptedException {
        Driver.getDriver().get("https://ebay.de/");
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.keyDown(searchBox, Keys.SHIFT).sendKeys("iphone x").keyUp(searchBox, Keys.SHIFT).perform();
        Driver.wait(2);

    }
    @Test
    public void scrollDown() throws InterruptedException {
        Driver.getDriver().get("https://ebay.de/");
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.END).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.UP).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.END).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.HOME).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.DOWN).perform();
        Driver.wait(2);
    }
    @Test
    public void doubleClick() throws InterruptedException {
        Driver.getDriver().get("https://ebay.de/");
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("iphone");
        Driver.wait(2);
        actions.doubleClick(searchBox).perform();
        Driver.wait(2);
    }
    @Test
    public void hoverOver() throws InterruptedException {
        Driver.getDriver().get("https://amazon.com/");
        WebElement accountMenu = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(accountMenu).perform();
        Driver.wait(2);
        WebElement accountLink = Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Account')])[2]"));
        accountLink.click();
        Driver.wait(2);
    }
}
