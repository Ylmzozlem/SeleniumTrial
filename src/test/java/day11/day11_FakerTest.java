package day11;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class day11_FakerTest extends TestBase {
    @Test
    public void test1() {
        go("https://facebook.com");

        // cretae new account butonuna basalım
        findElementByXpath("(//*[@role='button'])[2]").click();
        wait(2);

        // first name kısmına bir isim yazalım
        WebElement firstName = findElementByXpath("(//input[@type='text'])[2]");

        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, fakeMail);
        wait(1);
        firstName.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, fakeMail, Keys.TAB, faker.internet().password(), Keys.TAB, Keys.TAB,"21", Keys.TAB, "May" ,Keys.TAB, "1991" ,Keys.TAB,Keys.TAB,Keys.ARROW_RIGHT,Keys.ENTER);

        Assert.assertFalse(findElementByXpath("//input[@value='1']").isSelected());


    }
}
