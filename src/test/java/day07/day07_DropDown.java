package day07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class day07_DropDown {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        driver=new ChromeDriver(co);
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void findMenues() throws InterruptedException {
        WebElement year=driver.findElement(By.cssSelector("select[id=\"year\"]"));
        WebElement day=driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month=driver.findElement(By.cssSelector("select[id=\"month\"]"));



        Select opt=new Select(year);
        Select opt3=new Select(month);
        Select opt2=new Select(day);

        opt.selectByIndex(5);
        opt3.selectByVisibleText("July");
        opt2.selectByValue("21");
    }

    @Test
    public void findStates() {
        WebElement state=driver.findElement(By.cssSelector("select#state"));

        Select states=new Select(state);

        List<WebElement> listOfStates=states.getOptions();

        listOfStates.forEach(t -> System.out.println(t.getText())); // Burada t değeri bir WebElement dondürüyor. bizim bunların textlerine ihtiyacımız var. o yüzden getText( ) metodunu kullandık
    }

    @Test
    public void checking() {
        WebElement state=driver.findElement(By.cssSelector("select#state"));
        Select states=new Select(state);
        String firstText=states.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",firstText);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
