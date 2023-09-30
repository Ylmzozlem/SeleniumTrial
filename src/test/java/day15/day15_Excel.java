package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;


public class day15_Excel {
    @Test
    public void test1() throws Exception {
// Excel dosyamızın yolunu aldık
        String filePath="src/test/java/resource/Capitals.xlsx";

// Dosyayı okuyabilmesi için javada akışa soktuk
        FileInputStream fis=new FileInputStream(filePath);

// Javanın anlayabileceği excel ortamını akıştaki dosya ile kurduk
        Workbook wb= WorkbookFactory.create(fis);

// Kurduğumuz yeni dosyanın sayfa bilgisini çektik
        Sheet sheet=wb.getSheet("Sheet1");

//Sayfa bilgisinden satır bilgisine gittik
        Row row=sheet.getRow(1); // index sıfırdan başlar

//Satır bilgisinden hücre bilgisine girdik
        Cell cell=row.getCell(0);

        System.out.println(cell);




    }
}
