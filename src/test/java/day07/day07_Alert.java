package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Scanner;

public class day07_Alert extends TestBase {

    @Test
    public void test01() {
        go("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        System.out.println(driver.switchTo().alert().getText());
        wait(2);
        driver.switchTo().alert().accept();
        wait(2);
        String message=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals("You successfully clicked an alert",message);

    }

    @Test
    public void test2() {
        go("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        findElementByXpath("(//button)[2]").click();
        wait(2);
        driver.switchTo().alert().dismiss();

        String message=findElementByXpath("//*[@id='result']").getText();
        Assert.assertFalse(message.contains("successfully"));

    }

    @Test
    public void test03() {
        go("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        findElementByXpath("(//button)[3]").click();

        String name="Ozlem";

        driver.switchTo().alert().sendKeys(name);
        wait(2);
        driver.switchTo().alert().accept();

        String message= findElementByCss("p#result").getText();

        Assert.assertTrue(message.contains(name));





    }
}
