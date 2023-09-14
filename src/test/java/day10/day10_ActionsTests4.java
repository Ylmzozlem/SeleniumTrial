package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class day10_ActionsTests4 extends TestBase {
    @Test
    public void test1() {
        go("https://google.com");


        Actions actions=new Actions(driver);

        WebElement searchBox=findElementByXpath("//*[@class='gLFyf']");
        actions.keyDown(searchBox,Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys("-java",Keys.ENTER).perform();
    }

    @Test
    public void test2() {
        go("https://google.com");

        WebElement searchBox=findElementByXpath("//*[@class='gLFyf']");

        // 2.Yol
        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);

    }
}
