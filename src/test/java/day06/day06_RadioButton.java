package day06;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day06_RadioButton {
    WebDriver driver;

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
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void radioButton() throws InterruptedException {

        driver.get("https://facebook.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(3000);

        WebElement blanks=driver.findElement(By.cssSelector("input[name=\"firstname\"]"));
        Thread.sleep(2000);
        blanks.sendKeys("Özlem" + Keys.TAB+"Okur" + Keys.TAB+"05529878900" +
                Keys.TAB+"Oldu mu?" + Keys.TAB+Keys.TAB+"3",Keys.TAB+"Ağu",Keys.TAB+"1991",Keys.TAB);


        // radi buttons elementlerini locate ediyoruz

        WebElement kadın= driver.findElement(By.xpath("//input[@value=\"1\"]"));
        WebElement erkek= driver.findElement(By.xpath("//input[@value=\"2\"]"));
        WebElement özel= driver.findElement(By.xpath("//input[@value=\"-1\"]"));

        if(!kadın.isSelected()){
            kadın.click();
        }









    }
}
