package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();


        //Remote
        //Networking
        ChromeOptions chromeOptions = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

    }

    @Test
    public void TC_01_() {
        String homeUrl = "https://demo.nopcommerce.com/login";
        driver.get(homeUrl);

        String pageTitle = driver.getTitle();


        Assert.assertEquals(pageTitle, "nopCommerce demo store. Login");

        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");

        //lấy ID của màn tab/window đang active
        driver.getWindowHandle();

        //lấy ID của tất cả các tab/window đang có
        driver.getWindowHandles();



    }

    @Test
    public void TC_02_() { 

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}