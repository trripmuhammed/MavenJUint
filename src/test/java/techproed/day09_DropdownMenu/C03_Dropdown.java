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

public class C03_Dropdown {


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
    public void test01() throws InterruptedException {
        //programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement languages = driver.findElement(By.xpath("(//select)[6]"));

        Select select = new Select(languages);

         select.selectByIndex(0);
         select.selectByIndex(2);
         select.selectByIndex(3);
         select.selectByIndex(4);

         //Eger sadece secili olan option'lari yani secenekleri yazdirmak istersek

        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));

        //4 tane sectigimizi dogruluyalim

        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        System.out.println("-------------------------------------------");
        //sectigimiz seceneklerden ilkini yazdilarim ve java oldugunu dogrulayalim
        System.out.println("secilen ilk secenek: " +select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        bekle(3);
        //sectigimiz seceneklerin hepsini kaldiralim
        select.deselectAll();
        bekle(3);

        //senKeys() methoduyla istedigimiz bir secenegi gonderelim
        languages.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectVisibleText(languages,"Java");

        //Index olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectIndex(languages,2);

        //value olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectValue(languages,"js");

    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }
    public void selectVisibleText(WebElement ddm,String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm,int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm,String value) {
        Select select = new Select(ddm);
        select.selectByVisibleText(value);
    }

    public void bekle(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
