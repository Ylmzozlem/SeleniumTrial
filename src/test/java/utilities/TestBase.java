package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class TestBase {
    public WebDriver driver;
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

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

        extentReports.flush();
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

    // ScreenShot
    public void screenshot(String fileName) throws IOException {
        String folderPath="src/test/java/utilities/ScreenShots/";


        TakesScreenshot ts= (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(folderPath+fileName));
    }

    public void takeScreenshot()  {
        String date= new SimpleDateFormat("_hhmm_ss_ddMMyyyy").format(new Date());
        String savingPath= "src/test/java/utilities/ScreenShots/screenshot%S.png";
        TakesScreenshot ts=(TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(String.format(savingPath,date)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeElementShot(WebElement element){
        String date= new SimpleDateFormat("_hhmm_ss_ddMMyyyy").format(new Date());
        String savingPath= "src/test/java/utilities/ScreenShots/screenshot%S.png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(String.format(savingPath,date)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createReportFile(String fileName){
        extentReports=new ExtentReports();

        String ddt= LocalDateTime.now().format(DateTimeFormatter.ofPattern("_dd-MM-yyyy_hh-mm-ss")).toString();
        String filePath=String.format("src/test/java/utilities/ExtentReport/%s_%s.html",ddt,fileName);
        extentHtmlReporter=new ExtentHtmlReporter(filePath);

        extentReports.attachReporter(extentHtmlReporter);
    }

    public void report(String testerName, String browser, String docTitle,String reportName){
        extentReports.setSystemInfo("Tester", testerName);
        extentReports.setSystemInfo("Browser", browser);
        extentHtmlReporter.config().setDocumentTitle(docTitle);
        extentHtmlReporter.config().setReportName(reportName);
    }

    public void createTest(String testName, String description){
        extentTest=extentReports.createTest(testName,description);
    }

    public void printData(int tableOrder ,int row, int column) {
        WebElement element=findElementByXpath(String.format("(//table)[%s]//tr[%s]//td[%s]",tableOrder,row,column));
        System.out.println(element.getText());
    }



}
