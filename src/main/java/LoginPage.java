import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

        String url_link = "http://test-app.d6.dev.devcaz.com/admin/login";
        driver.get(url_link);


        Cookie myCookie = new Cookie("PHPSESSID", "fkdi3aiicpterfg4e4efv2rbb0");
        driver.manage().addCookie(myCookie);
        driver.navigate().refresh();


        driver.findElement(By.id("UserLogin_username")).sendKeys("admin1");
        driver.findElement(By.id("UserLogin_password")).sendKeys("[9k<k8^z!+$$GkuP");

        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(6000);

        driver.close();

    }
}
