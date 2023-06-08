package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
    DROPDOWN --> Alt basliklarin oldugu acilir menu listesidir.
    Dropdown'U handle(automate) etmek icin
        1-Dropdown menuyu ilk olarak locate ederiz
        2-Select objesi olustururuz
        3-Select objesinin ddm webelementinin icerigine ve seceneklerine erisim saglamasi icin
        SELECT sinifina arguman olarak locate ettigimiz webelementi koyariz.
        SYNTAX:
            Select option = new Select(ddm webelementi);
        4-Select class'i sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir.
        5-Select objesi ddm'yu handle edebilmek icin 3 method kullanir.
            -selectByVisibleText() --> Ddm deki elemente gorunur metin ile ulasmak icin kullanilir.
            -selectByIndex() --> Index ile ulasmak icin kullanilir(Index 0'dan baslar).
            -selectByValue() --> Element'in degeri ile ulasmak icin kullanilir(option tag'larindaki deger ile).
        6-getOptions() --> Locate ettigimiz ddm'deki tum secenekleri bize verir.(List'e atip loop ile yazdirabiliriz)
        7-getFirstSelectedOption() --> Ddm'deki en secili kalan secenegi bize verir.Birden fazla secenek secildiyse.
        Bu secilenlerin ilkini verir.
        8-Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.
     */



    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        WebElement year = driver.findElement(By.xpath("(//select)[2]"));
        year.sendKeys("2021");
        WebElement month = driver.findElement(By.xpath("(//select)[3]"));
        WebElement day = driver.findElement(By.xpath("(//select)[4]"));

        Select select = new Select(year);
        select.selectByIndex(5);

        Select select1 = new Select(month);
        select1.selectByValue("6");

        Select select2 = new Select(day);
        select2.selectByVisibleText("15");
    }

    @Test
    public void test02() {
        WebElement states = driver.findElement(By.xpath("(//select)[5]"));

        Select select = new Select(states);

        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //2.yol
        System.out.println("***********************************");
        List<WebElement> statess = driver.findElements(By.xpath("(//select)[5]"));

        statess.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        WebElement states = driver.findElement(By.xpath("(//select)[5]"));

        Select select = new Select(states);

        String actualOption = select.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        Assert.assertEquals("Select a State", actualOption);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
