package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    static void setUp() {
        System.out.println("Hooks start");
        WebDriverManager.chromedriver().setup();
    }

    @After
    static void tearDown(WebDriver driver) {
        driver.quit();
    }
}
