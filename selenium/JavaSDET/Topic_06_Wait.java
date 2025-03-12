package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_06_Wait {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        //explicitWait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //ImplicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //FluentWait
        fluentWait = new FluentWait<>(driver);

    }

    @Test
    public void TC_01() throws InterruptedException {
        //ImplicitWait dung cho find element

        //ExplicitWait cho element vs 1 dk ro rang -> hien thi hay k

        //FluentWait co the chinh polling tuy y








    }

    @Test
    public void TC_02_Login() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}