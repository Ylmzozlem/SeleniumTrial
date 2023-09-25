package day12;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class day12_UploadFileRobotClass extends TestBase {
    @Test
    public void test01() {
        go("https://the-internet.herokuapp.com/upload");

        // Yüklemek istediğim dosyanın yolu "C:\Users\ylmzo\Downloads\Task 15"
        String fieldPath="C:\\Users\\ylmzo\\Downloads\\Task 15\\twitter.jpg";

        uploadFilePats(fieldPath);

        findElementByID("file-submit").click();

        String text=findElementByXpath("//h3").getText();
        Assert.assertEquals("File Uploaded!",text);
    }
}
