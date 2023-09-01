package day06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day06_CheckBox {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(200);
    }

    @Test
    public void checkBox() throws InterruptedException {
        //CheckBox1 ve CheckBox2 elementlerini locate edelim

        WebElement checkbox1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        Thread.sleep(200);
        checkbox1.click();
        Thread.sleep(200);
        checkbox2.click();
        Thread.sleep(200);

        //CheckBox1 seçili değilse onay kutusunu tıkla
        if(!checkbox1.isSelected()){
            checkbox1.click();
            Thread.sleep(200);
        }

        //CheckBox1 seçili değilse onay kutusunu tıkla
        if(!checkbox2.isSelected()){
            checkbox2.click();
            Thread.sleep(200);
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
