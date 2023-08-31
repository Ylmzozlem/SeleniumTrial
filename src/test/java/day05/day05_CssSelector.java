package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.time.Duration;

public class day05_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasına git
        driver.get("http://zero.webappsecurity.com");

        // signin butonuna tıklayın
        driver.findElement(By.cssSelector("button[type='button']")).click(); // bu locate'i xpath ile //button şeklinde de alabiliriz

        // login alanına username yazdırın password kısmına da 'password' yazdırın

        WebElement login=driver.findElement(By.cssSelector("input[type='text']"));

        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

        // Online Banking altındaki  Pay Bills sayfasına gidelim
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span)[4]")).click();
        Thread.sleep(2000);

        //amount kısmına yatırmak istediğimiz miktarı yazıyoruz

        // driver.findElement(By.cssSelector("input[class='span1']")).sendKeys("500", Keys.TAB,"2020-09-10", Keys.TAB, Keys.TAB,Keys.ENTER); // burada işlemleri cok hızlı yapacağı için bir thread.sleep yapmak isteyebilirsin. O zaman locate alman gerekecek
        /*
        Araya thread girmek istersen şöyle de yapabilirsin.
        */
        WebElement amount=driver.findElement(By.cssSelector("input[class='span1']"));

        amount.sendKeys("500", Keys.TAB,"2020-09-10");
        Thread.sleep(2000);
        amount.sendKeys(Keys.TAB);
         Thread.sleep(2000);
        amount.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        amount.sendKeys(Keys.ENTER);


        // The payment was successfully submitted. mesajının cıktığını test edelim
        String message= driver.findElement(By.xpath("(//span)[1]")).getText();


        System.out.println(message.equals("The payment was successfully submitted.")?"Test PASSED" : "Test  FAILED");

        driver.close();




    }
}
