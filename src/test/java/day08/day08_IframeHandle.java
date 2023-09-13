package day08;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class day08_IframeHandle extends TestBase {
    @Test
    public void test01() {
        go("https://testcenter.techproeducation.com/index.php?page=iframe");

        String text=findElementByXpath("//*[.='An iframe with a thin black border:']").getText(); // Buradaki .= , aslında text()= anlamına geliyor. text()=. da sayfadaki bütün textleri getirir. biz indeksleme ile ihtiyacımız olanı alırızd
        Assert.assertTrue(text.contains("black border"));

        driver.switchTo().frame(0);

        String webText=findElementByXpath("//h1").getText();

        Assert.assertEquals("Applications lists", webText);

        driver.switchTo().defaultContent();
       // driver.navigate().refresh(); de yapabiliriz. Ama bu komutu kullanırken çok dikkatli olmamız gerekir.Frame içinde bif form doldurduysak refresh() ile bınlar sıfırlanabilir.
       // driver.get(driver.getCurrentUrl());

        String powerText=findElementByXpath("(//p[text()='Povered By'])[1]").getText();
        Assert.assertTrue(powerText.contains("Povered By"));







    }
}
