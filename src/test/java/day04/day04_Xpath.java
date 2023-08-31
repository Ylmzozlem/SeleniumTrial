package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day04_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon sayfasına git
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();


        // city bike arat
        WebElement searchBox=driver.findElement(By.xpath("//*[@*='text']"));  //  //*[@type='text'] şeklinde de yazabiliriz
        searchBox.sendKeys("city bike" +Keys.ENTER); //  searchBox.sendKeys("city bike" ,Keys.ENTER);

        //toplam kac sonuç var yazdır
        WebElement searchResult=driver.findElement(By.xpath("//*[@class='sg-col-inner'][1]"));
        System.out.println(searchResult.getText());

        //sonuçlara tek tek tıkla
        
        for(int j=1; j<400; j++){
            WebElement firstResult = driver.findElement(By.xpath(String.format("(//*[@class='s-image'])[%s]", j)));
            firstResult.click();
            Thread.sleep(3000);
            driver.navigate().back();
        }

        driver.close();

    }
}
