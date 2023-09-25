package day11;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class day11_FileDownload extends TestBase {
    @Test
    public void name() {

        go("https://testcenter.techproeducation.com/index.php?page=file-download");

        findElementByXpath("(//a)[3]").click();
        wait(2);

        // Önce manuel olarak dosyanın yolunu alalım sonra da testimizi yazalım

        String userPath=System.getProperty("user.home");
        String filePath="\\Downloads\\b10 all test cases, code.docx";
        String path=userPath+filePath;

        Assert.assertTrue(Files.exists(Paths.get(path)));

        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            System.out.println("File cannot found !!");;
        }
    }
}
