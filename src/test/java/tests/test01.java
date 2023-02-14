package tests;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class test01 extends TestBase {
    @Test
    public void alertAccept(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
    }
}
