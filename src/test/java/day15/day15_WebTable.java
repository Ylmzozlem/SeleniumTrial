package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class day15_WebTable extends TestBase {
    @Test
    public void test1() {
        createReportFile("webTable");
        report("Ozlem","Chrome","WebTable","Table Elements");

        createTest("WebTable Elements", "Testing table elements");
        go("https://the-internet.herokuapp.com/tables");
        extentTest.info("Heroku tables sayfasına git");

        WebElement table1=findElementByXpath("(//table)[1]");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 içindeki bilgiler print edildi");

        System.out.println("**************************");

        WebElement row1=findElementByXpath("(//table)[1]//tr[3]"); //  (//tbody)[1]//tr[3] şeklinde de yazabilirdik
        System.out.println(row1.getText());

        extentTest.info("Tablo1 içinde 3. satır bilgileri print edildi");

        WebElement lastRow=findElementByXpath("(//tbody)[1]//tr[last()]");
        System.out.println(lastRow.getText());
        extentTest.info("Tablo1 içinde son satır bilgileri print edildi");

        System.out.println("********************");

        WebElement fifthHead=findElementByXpath("(//table)[1]//thead//th[5]"); // (//table)[1]//th[5] de yazabilirdik (//thead)[1]//th[5] de yaabilirdik
        System.out.println(fifthHead.getText());

        extentTest.info("1. tablonun 5. sütununun başlığı alındı");

        System.out.println("???????????????????????????");

        List<WebElement> fifthRowTexts=driver.findElements(By.xpath("(//table)[1]//td[5]"));
        fifthRowTexts.forEach(t-> System.out.println(t.getText()));

        extentTest.info("Tablo 1'in 5. sütunundaki bütün bilgiler alınır");

        System.out.println("////////////////////////////////////////////////");
        printData(1,2,3);
        extentTest.info("Tablo 1'in 2.satır 3. sütun bilgiler alınır");




    }


}
