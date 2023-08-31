package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class day01_Driver {
    public static void main(String[] args) {

        /*
        WebDriverManager.chromedriver().setup();

        Google'a gelen guncellemeden dolayı bu gurumu desteklemediği için aşağıdaki  işlemi yopıyoruz.
         */

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");


        WebDriver driver=new ChromeDriver(co);

       driver.get("https://techproeducation.com");
    }
}
