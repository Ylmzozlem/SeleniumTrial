package day08;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class day08_Iframe2 extends TestBase {
    @Test
    public void test1() {

        go("https://the-internet.herokuapp.com/iframe");

        String editorText=findElementByXpath("//h3").getText();
        Assert.assertTrue(editorText.contains("Editor"));

        driver.switchTo().frame(0);
        findElementByXpath("//p").clear();
        findElementByXpath("//p").sendKeys("Bu textbox iFrame içinde yer almaktadır");




    }
}
