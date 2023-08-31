package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day02_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);

        driver.get("https://amazon.com");
        Thread.sleep(3000);
        System.out.println("Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        driver.manage().window().minimize();
        Thread.sleep(3000);
        System.out.println("Minimize durumda Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Minimize durumda Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println("Maximize durumda Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Maximize durumda Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        System.out.println("Maximize durumda Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Maximize durumda Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        //Point point = new Point(80,10);
        //driver.manage().window().setPosition(point);
        driver.manage().window().setPosition(new Point(80,10));
        Thread.sleep(3000);
        System.out.println("Maximize durumda Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Maximize durumda Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        driver.manage().window().setSize(new Dimension(1200,700));
        Thread.sleep(3000);
        System.out.println("Maximize durumda Sayfanın konumu :  "+driver.manage().window().getPosition());
        System.out.println("Maximize durumda Sayfanın boyut ölçüleri :  "+ driver.manage().window().getSize());

        driver.quit();



    }
}
