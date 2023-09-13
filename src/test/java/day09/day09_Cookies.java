package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class day09_Cookies extends TestBase {
    @Test
    public void test01() {
        go("https://www.amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        Set<Cookie> cookies; // listemizde ekleme silme yapacağımız için her defasında tekrar tekrar oluşturmak yerine atamaları daha sonra yapabiliriz

        cookies=driver.manage().getCookies();
       int i=1;
       /*  for (Cookie co:cookies) {
            System.out.println( "Cookie "+i+"= "+co);
            i++;
        }
      */
        for (Cookie co:cookies) {
            System.out.println( "Cookie "+i+"= "+co.getName());
            i++;
        }

        //Cookies sayısının 5 teh buyuk olduğunu görelim
        Assert.assertTrue(cookies.size()>5 );

        // i18-prefs isimli cookiesin değerinin USD olduğunu doğrulayalım
        // 1. yol
        for (Cookie co:cookies) {
            if(co.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",co.getValue());
            }
        }
        //2.Yol
        Assert.assertEquals("USD",driver.manage().getCookieNamed("i18n-prefs").getValue());

        // yeni bir cookie oluştur
        Cookie newCookie=new Cookie("&& en sevdigim cookie","çikolatalı");
        driver.manage().addCookie(newCookie);

        // ismi skin olan cookieyi silelim

        driver.manage().deleteCookieNamed("skin");

        System.out.println("____________After adding new cookie_____________________");

        cookies=driver.manage().getCookies();

        int j=1;
        for (Cookie co:cookies) {
            System.out.println( "Cookie "+j+"= "+co.getName());
            j++;
        }

        // yaptıımız testte yeni cookienin eklendiğini goruyoruz. bu yeni eklenti sadece biz calıştırdığımızda anlık olarak ekleniyor kalıcı eklenemiyor

        Assert.assertTrue(driver.manage().getCookies().contains(newCookie));


        // ismi skin olan cookieyi silelim

        driver.manage().deleteCookieNamed("skin");

        Assert.assertFalse(cookies.contains(driver.manage().getCookieNamed("skin")));

        // tüm cookieleri silelim ve silindiğinden emin olalım
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty());



    }
}
