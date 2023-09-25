package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class day12_ExplictlyWait extends TestBase {
    @Test
    public void test1() {
        go("https://the-internet.herokuapp.com/dynamic_loading/1");

        findElementByXpath("//*[text()='Start']").click();

        // Hangi elementin gorununr olmasını beklemek istiyorum
        WebElement helloElement=findElementByXpath("(//h4)[2]");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(helloElement));

        Assert.assertTrue(helloElement.isDisplayed());


    }

    @Test
    public void test2() {
        go("https://the-internet.herokuapp.com/dynamic_loading/1");

        findElementByXpath("//*[text()='Start']").click();

        WebElement helloWorld= new WebDriverWait(driver,Duration.ofSeconds(15)).
                                                                                                                            until(ExpectedConditions.
                                                                                                                                    visibilityOfElementLocated(
                                                                                                                                            By.xpath("(//h4)[2]")
                                                                                                                                    ));

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }

    /*
    Aynı siteye git, loading çubuğu kaybolana kadar bekle ve Hello World yazısının görünür olduğunu test et
     */

    @Test
    public void test3() {

        go("https://the-internet.herokuapp.com/dynamic_loading/1");

        findElementByXpath("//*[text()='Start']").click();

        WebElement helloWorld=findElementByXpath("(//h4)[2]");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));


        Assert.assertEquals("Hello World!", helloWorld.getText());

    }
}
