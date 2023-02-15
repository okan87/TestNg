package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void testWindowHandle() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.heroku.app.com/windows");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://google.com', '_black');");
        Driver.wait(2);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://amazon.com', '_black');");
        Driver.wait(2);
        Set<String> handles = Driver.getDriver().getWindowHandles();
        Driver.getDriver().switchTo().window(handles.toArray()[2].toString());

        for (int i=0; i<handles.size(); i++) {
            Driver.getDriver().switchTo().window(handles.toArray()[i].toString());
            System.out.println(i + " .window ==>" + Driver.getDriver().getTitle());
            Driver.wait(1);
        }
    }

}
