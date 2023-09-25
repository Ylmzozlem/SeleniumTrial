package day13;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class day13_Screenshot extends TestBase {

    @Test
    public void test1() throws IOException {
        /*
        Seleniumda tüm sayfanın resmini almak için:
                1- TakeScreenShot arayuzununden obje oluştup driver'a eşitleriz. bunlar farklı gruplar olduğu için casting işlemi yapılır
                2-FileUtils class'ından copyFile method'u içine parametreolarak oluştırduğumuz obje ile getScreenShotAs() metodu kullanılır. getScreenShot() metoduna parametre olarak OutputType.File ekleriz. Bunu yeni bir dosyaya kaydetmesi için new File() diyerek kaydederiz

         */

        go("https://amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("src/test/java/utilities/ScreenShots/screenShot1.png"));


    }

    @Test
    public void test2() throws IOException {
        go("https://techproeducation.com");

        String folderPath="src/test/java/utilities/ScreenShots";
        String newPNG="/screenShot2.png";

        TakesScreenshot ts= (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(folderPath+newPNG));



    }

    @Test
    public void test3() throws IOException {

        go("https://youtube.com");
        screenshot("youtebe.png");
    }
}
