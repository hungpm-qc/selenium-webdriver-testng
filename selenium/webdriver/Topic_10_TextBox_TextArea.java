package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_TextBox_TextArea {
    WebDriver driver;

    String educationText = "Auto\nwith\nselenium";

    String firstName, lastName, email, password, fullName;

    Random rand;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        rand = new Random();

        firstName = "abc";
        lastName = "def";
        fullName = firstName + " " + lastName;
        email = "abc"+rand.nextInt(99999)+"@gmail.com";
        password = "abc123";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys(educationText);
    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//span[normalize-space()='Thank you for registering with Main Website Store.'])[1]")).getText(),
                "Thank you for registering with Main Website Store.");
        String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        System.out.println(contactInformationText);
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(email));
        driver.findElement(By.xpath("(//a[normalize-space()='Mobile'])[1]")).click();
        driver.findElement(By.xpath("(//a[@title='Samsung Galaxy'][normalize-space()='Samsung Galaxy'])[1]")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Add Your Review'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='Quality 1_5'])[1]")).click();
        driver.findElement(By.xpath("(//textarea[@id='review_field'])[1]")).sendKeys("good app\n"+"easy use");
        driver.findElement(By.xpath("(//input[@id='summary_field'])[1]")).sendKeys("best phone");
        driver.findElement(By.xpath("(//input[@id='summary_field'])[1]")).sendKeys("auto");
        driver.findElement(By.xpath("(//button[@title='Submit Review'])[1]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//span[normalize-space()='Your review has been accepted for moderation.'])[1]")).getText()
                ,"Your review has been accepted for moderation.");
        //logout

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();

    }

}