package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button#signin_button")).click();

        //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
        //5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username",Keys.TAB,"password",Keys.ENTER);

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        driver.findElement(By.cssSelector("span#pay_bills_link")).click();

        // //*[text()=.] sayfadaki tum yazilari verir.Bu sekilte text ile aldigimiz bir xpath'de text degisse bile
        //biz o webelementi handle edebiliriz.

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina "2020-09-10" yazdirin
        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        if(driver.findElement(By.cssSelector("(//span)[1]")).getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.close();
    }
}
