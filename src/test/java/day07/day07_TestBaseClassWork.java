package day07;

import org.junit.Test;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class day07_TestBaseClassWork extends TestBase {
    @Test
    public void test01() {
        go("https://techproeducation.com");
        wait(3);

        findElementByID("searchHeaderInput").sendKeys("Data");
        wait(3);


    }

}
