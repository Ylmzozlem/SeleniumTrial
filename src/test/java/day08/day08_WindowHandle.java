package day08;

import org.bouncycastle.LICENSE;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class day08_WindowHandle extends TestBase {
    @Test
    public void test01() {
        go("https://techproeducation.com");

        String tecProWindow=driver.getWindowHandle();
        Assert.assertEquals("TechPro Education",driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        String youtubeHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://linkedin.com");
        String linedinHandle=driver.getWindowHandle(); // biz testbasede close() kullandığımız için driver en son hangi penceree ise onu kapatır. Ama biz quit() kullanırsak bütün pencereleri kapatacak

        driver.switchTo().window(tecProWindow);

        driver.switchTo().window(youtubeHandle);




    }

    @Test
    public void test02() {
        go("https://techproeducation.com");


        Assert.assertEquals("TechPro Education",driver.getTitle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://linkedin.com");

        List<String> windowHandles=new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowHandles.get(0));
        wait(2);
        driver.switchTo().window(windowHandles.get(1));
        wait(2);
        driver.switchTo().window(windowHandles.get(2));
        wait(2);






    }
}
