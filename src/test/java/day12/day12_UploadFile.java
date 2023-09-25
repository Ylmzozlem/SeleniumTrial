package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class day12_UploadFile extends TestBase {
    @Test
    public void test01() {
        go("https://the-internet.herokuapp.com/upload");

        // Yüklemek istediğim dosyanın yolu "C:\Users\ylmzo\Downloads\Task 15"
        String fieldPath="C:\\Users\\ylmzo\\Downloads\\Task 15\\twitter.jpg";

        findElementByXpath("//*[@id='file-upload']").sendKeys(fieldPath);
        wait(2);

        findElementByID("file-submit").click();

        String text=findElementByXpath("//h3").getText();
        Assert.assertEquals("File Uploaded!",text);
    }
}
