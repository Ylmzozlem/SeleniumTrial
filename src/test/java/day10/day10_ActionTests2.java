package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class day10_ActionTests2 extends TestBase {
    @Test
    public void test1() {
        driver.get("https://techproeducation.com");

        // Sayfayı bir mikral scroll yapalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        wait(2);

        // Sayfayı bir miktar yukarı kaydıralım
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        wait(2);

        // Sayfanın en altına gelmek için
        actions.sendKeys(Keys.END).perform();
        wait(2);

        // Sayfanınn en başına gelelim
        actions.sendKeys(Keys.HOME).perform();
        wait(2);

        //Sayfayı belli bir element gorunur olana kadar scroll yapalım
        actions.scrollToElement(findElementByXpath("(//div[@class='container'])[19]")).perform();
        wait(2);

    }
}
