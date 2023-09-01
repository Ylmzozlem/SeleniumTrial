package day06;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day06_Assertion {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }

    // Sayfa başlığının YouTube olduğunu test edelim
    //Youtube resminin görüntülendiğini test edin (isDisplay())
    @Test
    public void test1() {
        String title=driver.getTitle();
        Assert.assertEquals("YouTube", title);

        WebElement logo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }


    // SearcBox'ın erişilebilir olduğunu test edelim
    @Test
    public void test2() {
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBox.isEnabled());
    }

    // WrongTitleTest => sayfa başlığının "youtube" olmadığını test edelim
    @Test
    public void test3() {
        String title=driver.getTitle();
        Assert.assertNotEquals("youtube", title);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
