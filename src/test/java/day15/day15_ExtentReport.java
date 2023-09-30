package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class day15_ExtentReport extends TestBase {
    @Test
    public void test1() {


        // Raporda gözükmesini istediğimiz bilgiler
        report("Ozlem","Chrome","ExtentReport","Smoke Report");

       createTest("Amazon Testi","Verilen komutlarda test sonuçları");

        // Amazon sayfasına gidelim ve arama kutusunda İphone yazıp aratalım

        go("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        extentTest.info("Kullanıcı Amazon sayfasına gider");


        findElementByXpath("//*[@id='twotabsearchtextbox']").sendKeys("Iphone", Keys.ENTER);
        extentTest.info("Kullanıcı Amazaon sayfasının arama kutusuna Iphone aratır");

        //Ekran resmini alalım

        takeScreenshot();
        extentTest.info("Ekran görüntüsü alınır");

        //sonuç yazısının ekran resmini alalım

        WebElement result=findElementByXpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]");
        takeElementShot(result);
        extentTest.info("Kullanıcı İphone aratma sonucunda elde ettiği sonuç yazısının resmini alır");
        extentTest.pass("Kullanıcı sonuç çıktısını alır");








    }
}
