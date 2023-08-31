package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day04_getTagName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        WebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // techproeducation sayfasına git
        driver.get("https://techproeducation.com");

        //Arama kutusunu locate edelim
        WebElement searcBox=driver.findElement(By.id("searchHeaderInput"));

        // arama kutusunun tag name'inin input olduğunu test edelim
        System.out.println(searcBox.getTagName().equals("input")  ? "Test passed" : "Test Failed");


        // arama kutusunun class attributesin 'from-input' olduğunu test edelim
        System.out.println(searcBox.getAttribute("class").equals("form-input")  ? "Test passed" : "Test Failed");
    }
}
