package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.cssSelector("div[class='sg-col-inner']"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);


        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("//h2//a")).click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> list = driver.findElements(By.xpath("//h1|//h2"));
        // '|' isareti ve anlamindadir, sadece burda kullanmak zorunda degiliz class vs lerdede kullanabiliriz(xpath icinde)
        list.stream().filter(t-> !t.getText().isBlank()).forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}
