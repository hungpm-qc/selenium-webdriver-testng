package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    }



    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys(educationText);
    }

    @Test
    public void TC_02() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("(//li.success-msg//span)")).getText(),
                "Thank you for registering with Main Website Store");

        String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        System.out.println(contactInformationText);

        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(email));

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();

    }

}