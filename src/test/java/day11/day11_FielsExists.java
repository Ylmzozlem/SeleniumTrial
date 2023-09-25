package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class day11_FielsExists  {
    @Test
    public void test1() throws IOException {
        // masaüstünde bir dosyanın varlığını test edelim. bunun için once dosyanın yolunu alalım

        String fieldPath="C:\\Users\\ylmzo\\OneDrive\\Masaüstü\\düğün";

        boolean isExsist=Files.exists(Paths.get(fieldPath));
        Assert.assertTrue(isExsist);

        System.out.println(Files.getFileStore(Path.of(fieldPath)));
    }

    @Test
    public void test2() {
        /*
        Ortak çalışmalarda bir server üzerinden bir dosya yolu almak istersek, her kullanııcının bilgisayarının ana yolu farklı olabilir ve serverdaki dosyann yolu ortaktır. Dolayısıyla System.getProperty(user.home) methodu ile ana yolu alarak serverdaki ortak yol ile bunu concat yapabiliriz. boylece dosya yolunu dinamik bir şekilde lmış oluruz
         */

        // Test1 deki gibi dosya yolunu doğrulayalım

        System.out.println(System.getProperty("user.home"));
        String myPath=System.getProperty("user.home"); // burada çıkan yol her bilgisayatda farklıdır
        String commonPath="\\OneDrive\\Masaüstü\\düğün"; // Serverdaki ortak yol

        String fieldPath=myPath+commonPath; // nihai yolu aldık


        System.out.println(Files.exists(Paths.get(fieldPath)));

        Assert.assertTrue(Files.exists(Paths.get(fieldPath)));




    }
}
