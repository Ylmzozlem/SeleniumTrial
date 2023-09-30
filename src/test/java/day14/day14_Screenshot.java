package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class day14_Screenshot extends TestBase {
    @Test
    public void test1() throws IOException {
        go("https://amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();

        String date= new SimpleDateFormat("_hhmm_ss_ddMMyyyy").format(new Date());
        String savingPath= "src/test/java/utilities/ScreenShots/screenshot%S.png";
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(String.format(savingPath,date)));
    }

    @Test
    public void test2() throws IOException {
        go("https://youtube.com");
        wait(3);
        takeScreenshot();
    }
}
