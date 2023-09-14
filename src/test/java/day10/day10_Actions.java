package day10;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class day10_Actions extends TestBase {
    @Test
    public void test1() {
        go("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sağ tıklama yapalım
        Actions actions=new Actions(driver);
        actions.contextClick(findElementByID("hot-spot")).perform();
        wait(3);

        // Alertin contextini yazdır
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
    }
}
