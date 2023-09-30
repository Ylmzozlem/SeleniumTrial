package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class day14_ScreenShotWithElement extends TestBase {
    @Test
    public void test() throws IOException {
        go("https://amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();

        findElementByID("twotabsearchtextbox").sendKeys("iphone", Keys.ENTER);
        wait(2);
        takeScreenshot();

        //Sonuç yazısının resmini alacağız
        String date= new SimpleDateFormat("_hhmm_ss_ddMMyyyy").format(new Date());
        String savingPath= "src/test/java/utilities/ScreenShots/screenshot%S.png";

        WebElement result=findElementByXpath("(//*[@class='sg-col-inner'])[1]");
        FileUtils.copyFile(result.getScreenshotAs(OutputType.FILE),new File(String.format(savingPath,date)));

    }

    @Test
    public void test2() {
        go("https://techproeducation.com");

        WebElement serach=findElementByXpath("//*[@class='search-form']");
        takeElementShot(serach);

    }
}
