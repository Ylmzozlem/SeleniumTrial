package day06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day06_Examples {
    WebDriver driver; // method içlerinde bunu kullanabilmek için ilk tanımlamayı class seviyede yapıyorum
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://techproeducation.com");
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://youtube.com");
        Thread.sleep(3000);
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
