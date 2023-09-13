package day09;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class day09_Authentication extends TestBase {
    @Test
    public void test01() {
        go("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(findElementByXpath("//p").getText().contains("Congratulations"));

        findElementByXpath("(//a)[2]").click();
        swicthWindow(1);
    }
}
