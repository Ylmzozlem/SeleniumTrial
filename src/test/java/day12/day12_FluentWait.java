package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class day12_FluentWait extends TestBase {
    @Test
    public void test() {
        go("https://the-internet.herokuapp.com/dynamic_loading/1");

        findElementByXpath("//*[text()='Start']").click();

        WebElement helloWorld=findElementByXpath("(//h4)[2]");

        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(200));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }

    @Test
    public void test2() {

        go("https://the-internet.herokuapp.com/dynamic_loading/1");

        findElementByXpath("//*[text()='Start']").click();

        WebElement helloWorld=findElementByXpath("(//h4)[2]");

        // teferruatların silinmiş hali :)
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(200)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));

        Assert.assertEquals("Hello World!", helloWorld.getText());

    }
}
