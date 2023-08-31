package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day03_Locators_Id {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);

        driver.get("https://amazon.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Taking locate
        WebElement searchbox=driver.findElement(By.name("field-keywords"));
        searchbox.sendKeys("iphone");

        Thread.sleep(3000);

        WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(2000);

        driver.quit();


    }
}
