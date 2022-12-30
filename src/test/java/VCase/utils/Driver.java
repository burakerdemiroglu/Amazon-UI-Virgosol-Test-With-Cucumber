package VCase.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver() {

    }
    private static WebDriver driver;
    public static WebDriver get() {

        if (driver == null) {

            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();  // Tarayıcı tam ekran modu
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Driver elementlere erişim için 30 sn bekleme süresi tanınır
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); //Sayfaların timeouta düşme süresi tanınır

        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}