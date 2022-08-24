package cucumber.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

class Example {

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));

    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    static void setUp() {
        System.out.println("Hooks start");
        WebDriverManager.chromedriver().setup();
    }

    static void loginTest() throws InterruptedException {

        String url_link = "http://test-app.d6.dev.devcaz.com/admin/login";
        driver.get(url_link);

        try {
            driver.findElement(By.id("captcha1"));
            System.out.println("You must solve captcha");
            Thread.sleep(10000);

        } catch (NoSuchElementException e) {
            System.out.println("No captcha");
        }

        driver.findElement(By.id("UserLogin_username")).sendKeys("admin1");
        driver.findElement(By.id("UserLogin_password")).sendKeys("[9k<k8^z!+$$GkuP");
        driver.findElement(By.cssSelector(".btn")).click();

        assertThat(driver.findElement(By.id("nav")), notNullValue());

    }

    static void listPlayersTest() throws InterruptedException {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/li[8]/a/i/span")))
                .build()
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()=\"Players\"]")).click();
        assertThat(driver.findElement(By.cssSelector(".panel-heading")).getText(),
                containsString("PLAYER MANAGEMENT"));
        assertThat(driver.findElement(By.id("payment-system-transaction-grid_c1")).getText(),
                containsString("Username"));
    }


    static void sortColDateTest() throws InterruptedException, ParseException {

        long rows = driver.findElements(By.xpath(
                        "//*[@id=\"payment-system-transaction-grid\"]/table/tbody/tr"))
                .stream().count();

        driver.findElement(By.xpath("//a[text()=\"Registration date\"]")).click();

        Thread.sleep(1000);
        List<WebElement> cellTable = driver.findElements(By.xpath(
                "//*[@id=\"payment-system-transaction-grid\"]/table/tbody/tr/td[10]"));

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Thread.sleep(1000);

        String res = "Ascending";

        for (int i = 0; i < rows - 1; i++) {
            Date date1 = formatter.parse(cellTable.get(i).getText());
            Date date2 = formatter.parse(cellTable.get(i + 1).getText());

            if (date1.compareTo(date2) > 0) {
                res = "Descending";
                break;
            }
        }
        assertThat(res, containsString("Ascending"));
    }

    static void tearDown() {
        driver.quit();
    }

}