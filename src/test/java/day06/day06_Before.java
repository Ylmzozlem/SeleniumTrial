package day06;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day06_Before {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass çalışıyor");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass çalışıyor");

    }



    @Test
    public void test1() {
        System.out.println("Test1 çalışıyor");

    }

    @Test
    public void test2() {
        System.out.println("Test2 çalışıyor");
    }

    @Test
    public void test3() {
        System.out.println("Test3 çalışıyor");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("Before çalışıyor");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After çalışıyor");

    }
    @After
    public void tearDown2() throws Exception {
        System.out.println("After2 çalışıyor");

    }

}
