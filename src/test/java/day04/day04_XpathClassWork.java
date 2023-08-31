package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day04_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // heroku sitesinde ilgili yere git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);

        // Add element butonuna click yapalım
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(3000);

        //Delete butonunun görünür olduğunu test et

        WebElement deleteButton=driver.findElement(By.xpath("//*[.='Delete']"));

        System.out.println(deleteButton.isEnabled() ? "Test passed" : "Test Fail");

        deleteButton.click();

        // Add Remove Elements yazısının görünür olduğunu test et
        System.out.println(driver.findElement(By.xpath("//h3")).isDisplayed()?"Test Passed " : "Test Faild" );

    }
}
