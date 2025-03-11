package webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");
    }

    @Test
    public void TC_01() {
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