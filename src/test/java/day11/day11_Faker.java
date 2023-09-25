package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class day11_Faker extends TestBase {
    @Test
    public void test01() {

        Faker faker= new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());

        System.out.println(faker.address().cityName());

        System.out.println(faker.number().digits(15));


    }
}
