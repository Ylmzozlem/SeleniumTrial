package day08;

import jdk.dynalink.linker.LinkerServices;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class day08_WindowHandles extends TestBase {

    // Windows handles da farklı sayfalar arasında geçiş yapmanın  farklı yolunu yazyoruz , seçim senin olacak
    @Test
    public void test01() {
        go("https://the-internet.herokuapp.com/windows");
        String firsPageHandle = driver.getWindowHandle();
        Assert.assertEquals("Opening a new window", findElementByXpath("//h3").getText());
        Assert.assertEquals("The Internet", driver.getTitle());

        findElementByXpath("(//a)[2]").click();
        Set<String> windows = driver.getWindowHandles();

        for (String w : windows) {
            System.out.println(w);
            if (!w.equals(firsPageHandle)) {

                driver.switchTo().window(w);
            }
        }

        Assert.assertEquals("New Window", driver.getTitle());
        String secondPageHandle = driver.getWindowHandle();
        wait(2);

        driver.switchTo().window(firsPageHandle);
        wait(2);

        driver.switchTo().window(secondPageHandle);
        wait(2);

        driver.switchTo().window(firsPageHandle);


    }

    @Test
    public void test02() {
        go("https://the-internet.herokuapp.com/windows");
        String firsPageHandle = driver.getWindowHandle();
        Assert.assertEquals("Opening a new window", findElementByXpath("//h3").getText());
        Assert.assertEquals("The Internet", driver.getTitle());

        findElementByXpath("(//a)[2]").click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));


        Assert.assertEquals("New Window", driver.getTitle());
        wait(2);

        driver.switchTo().window(firsPageHandle);
        wait(2);

        driver.switchTo().window(windows.get(1));
        wait(2);

        driver.switchTo().window(firsPageHandle);

    }

    @Test
    public void test03() {
        go("https://the-internet.herokuapp.com/windows");

        Assert.assertEquals("Opening a new window", findElementByXpath("//h3").getText());
        Assert.assertEquals("The Internet", driver.getTitle());

        findElementByXpath("(//a)[2]").click();


        driver.switchTo().window(selectWindow(1));
        Assert.assertEquals("New Window", driver.getTitle());
        wait(2);

        driver.switchTo().window(selectWindow(0));
        wait(2);

        driver.switchTo().window(selectWindow(1));
        wait(2);

        driver.switchTo().window(selectWindow(0));
    }

    @Test
    public void test04() {
        go("https://the-internet.herokuapp.com/windows");

        Assert.assertEquals("Opening a new window", findElementByXpath("//h3").getText());
        Assert.assertEquals("The Internet", driver.getTitle());

        findElementByXpath("(//a)[2]").click();


        swicthWindow(1);
        Assert.assertEquals("New Window", driver.getTitle());
        wait(2);

        swicthWindow(0);
        wait(2);

        selectWindow(1);
        wait(2);

     selectWindow(0);
    }
}
