package webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {


//   1- Setup: OS/ Browser/Web/ Page/Data
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nocommerce.com");
    }

    // 2- Action/Execute
    @Test
    public void TC_01(){

    }

    @Test
    public void TC_02(){

    }


    //3- Clean: delete data test/ account/ close browser

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}