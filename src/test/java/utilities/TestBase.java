package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;

public abstract class TestBase {
    public WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co= new ChromeOptions();
        co.setBinary("C:\\Users\\ylmzo\\IdeaProjects\\Dokunulmaz dosyalar\\chrome-win64\\chrome.exe");

        driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    // HARD WAIT
    public void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectIndex(WebElement ddm, int idx){
        Select select=new Select(ddm);
        select.selectByIndex(idx);
    }

    public void go(String webSite){
        driver.get(webSite);
    }



    public WebElement findElementByID(String id){
        WebElement element= driver.findElement(By.id(id));
    return element;
    }

    public WebElement findElementByXpath(String id){
        WebElement element= driver.findElement(By.xpath(id));
        return element;
    }

    public WebElement findElementByCss(String id){
        WebElement element= driver.findElement(By.cssSelector(id));
        return element;
    }

    public String selectWindow(int index){
        String window=driver.getWindowHandles().toArray()[index].toString();
        return window;
    }

    public void swicthWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //UploadFile Robot class

    public void uploadFilePats(String fielPath){

        try {
            wait(3);
            StringSelection stringSelection=new StringSelection(fielPath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            wait(3);
            robot.keyPress(KeyEvent.VK_V);
            wait(3);
            robot.keyPress(KeyEvent.VK_CONTROL);
            wait(3);
            robot.keyPress(KeyEvent.VK_V);
            wait(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            wait(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            wait(3);
        }catch (AWTException e){
            throw new RuntimeException(e);
        }
    }



}
