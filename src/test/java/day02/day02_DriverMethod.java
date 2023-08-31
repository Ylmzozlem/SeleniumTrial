package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class day02_DriverMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");


        WebDriver driver=new ChromeDriver(co);

        driver.get("https://techproeducation.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://amazon.com");



    }
}
