package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {


//   1- Setup: OS/ Browser/Web/ Page/Data
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.get("https://cms-superapp.savis.vn/login?otp-confirmation=true");
    }

    // 2- Action/Execute
    @Test
    public void TC_01(){
       // <input id="normal_login_email" aria-required="true" type="text" placeholder="Email" class="ant-input" value="" aria-describedby="normal_login_email_help" aria-invalid="true">
        driver.findElement(By.id("normal_login_email"));

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