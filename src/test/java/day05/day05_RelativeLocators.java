package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class day05_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidelim
        driver.get("http://www.diemol.com/selenium-4-demo/relative-locators-demo.html ");

        // Berlini 3 farklı relative ile test edelim

        WebElement nyc=driver.findElement(By.xpath("//*[@id='pid3_thumb']"));
        nyc.click();
        Thread.sleep(1000);
        WebElement byArea=driver.findElement(By.xpath("//*[@id='pid8_thumb']"));
        byArea.click();
        Thread.sleep(1000);


        WebElement berlin=driver.findElement(with(By.tagName("img")).below(nyc).toLeftOf(byArea));
        berlin.click();

        // Bulunan değerin istenen değer olup olmadığını test edelim

        System.out.println(berlin.getAttribute("id").equals("pid7_thumb")? "Test PASSED" : "Test FAILED");

        driver.close();



    }
}
