package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SetUp {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().get("URL");

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void closeBroser() {
        driver.get().close();
    }

    @BeforeSuite
    public void setUp_beforeSuite() {
        setDriver();
    }

    @AfterSuite
    public void tearDown() {
        getDriver().quit();
    }

}
