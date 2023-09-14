package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class day10_ActionTests3 extends TestBase {
    @Test
    public void test1() {
        go("https://jqueryui.com/droppable/");

        //Drag me to my target webelement'ini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = findElementByXpath("//*[@id='draggable']");
        WebElement drop = findElementByXpath("//*[@id='droppable']");

        actions.dragAndDrop(drag, drop).perform();


    }

    @Test
    public void test2() {
        go("https://jqueryui.com/droppable/");

        //Drag me to my target webelement'ini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = findElementByXpath("//*[@id='draggable']");
        WebElement drop = findElementByXpath("//*[@id='droppable']");


        // 2.yol

        actions.clickAndHold(drag).perform();
        wait(2);
                actions.moveToElement(drop).perform();
                wait(2);
                        actions.release().perform();
    }

    @Test
    public void test3() {
        go("https://jqueryui.com/droppable/");

        //Drag me to my target webelement'ini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement drag = findElementByXpath("//*[@id='draggable']");
        WebElement drop = findElementByXpath("//*[@id='droppable']");

        // Elementi belli bir coordinata taşıyop bırakalım

        actions.dragAndDropBy(drag,140,35).release().perform();

        Assert.assertTrue(findElementByXpath("//*[.='Dropped!']").isDisplayed());
    }
}
