package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {
    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }

   // @Test
//    public void TC_01_Register() {
//        //tuong tac len email address textbox
//
//        //<input class="email" autofocus="" type="email" data-val="true"
//        //data-val-regex="Wrong email"
//        //data-val-regex-pattern="^(([^<>()\[\]\\.,;:\s@&quot;]+(\.[^<>()\[\]\\.,;:\s@&quot;]+)*)|(&quot;.+&quot;))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
//        //data-val-required="Please enter your email" id="Email" name="Email">
//
//        //xpath: //tagname[@attribute='value']
//        //css:  tagname[attribute='value']
//
//        //tim 1 element
//        WebElement emailTextBox = driver.findElement(By.id(""));
//        emailTextBox.clear();
//        emailTextBox.sendKeys("");
//        emailTextBox.isDisplayed();
//
//        //tim nhieu element
//        driver.findElements(By.cssSelector(""));
//
//        driver.findElement(By.cssSelector("")).click();
//
//        driver.findElement(By.cssSelector("")).getText();
//
//        List<WebElement> list = driver.findElements(By.cssSelector(""));
//
//    }

    @Test
    public void TC_02_Login() {

    }

    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);

        driver.findElement(By.id("FirstName")).sendKeys("Automation");
        Thread.sleep(3000);
    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        //k lay het gia toan bo gia tri (neu co khoang trang)
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText() {
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
    }

    @Test
    public void TC_05_Partial_Link_Text() {
        driver.findElement(By.partialLinkText("Digital"));

        driver.findElement(By.partialLinkText("download"));
    }

    @Test
    public void TC_06_TagName() {
        //case tim tat ca cac element giong nhau
        driver.findElements(By.tagName("button"));

        driver.findElements(By.tagName("input"));

        driver.findElements(By.tagName("label"));
    }


    @Test
    public void TC_07_Css() {
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));
    }

    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class,'register-next-step-button'])"));

        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}