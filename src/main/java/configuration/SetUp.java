package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SetUp {
    public static Properties properties;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Maximizing Browser Window");
        getDriver().manage().window().maximize();
        String application_url = properties.getProperty("URL");
        getDriver().get(application_url);
        System.out.println("Navigated to URL "+application_url);

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void closeBrowser() {
        driver.get().close();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp_beforeSuite() {
        try {
            properties = PropertiesFileLoad.LoadPropertiesFile("src/test/java/resources/properties/Env.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }

}
