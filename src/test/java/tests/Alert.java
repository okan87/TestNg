package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Alert extends TestBase {
    @Test
    public void alertAccept() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton = Driver.getDriver().findElement(By.cssSelector("button[onclick='jsAlert()']"));
        alertButton.click();
        String expectedTextOfAlert = "I am a JS Alert";
        String actualTextOfAlert = Driver.getDriver().switchTo().alert().getText();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        Assert.assertEquals(expectedTextOfAlert, actualTextOfAlert);
    }
    @Test
    public void alertAcceptAndDismiss() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton1 = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton1.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        alertButton1.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().dismiss();
        Driver.wait(2);
    }
    @Test
    public void sendMessageToAlert() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);
        WebElement alertButton1 = Driver.getDriver().findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        alertButton1.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().sendKeys("Merhaba Alert");
        Driver.getDriver().switchTo().alert().accept();
        WebElement message = Driver.getDriver().findElement(By.id("result"));
        String expectedMessage = "Merhaba Alert";
        Assert.assertTrue(message.getText().contains(expectedMessage));

    }
}
