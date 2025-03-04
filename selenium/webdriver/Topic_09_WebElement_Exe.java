package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_WebElement_Exe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
        if (emailTextbox.isDisplayed()) {
            System.out.println("Email text box is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email text box is not displayed");
        }

        WebElement ageUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (ageUnder18.isDisplayed()) {
            System.out.println("Age under 18 radio button is displayed");
            ageUnder18.click();
        } else {
            System.out.println("Age under 18 radio button is not displayed");
        }

        WebElement eduTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
        if (eduTextArea.isDisplayed()) {
            System.out.println("Edu text area is displayed");
            eduTextArea.sendKeys("Automation Testing");
        } else {
            System.out.println("Edu text area is not displayed");
        }

        WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if (user5Text.isDisplayed()) {
            System.out.println("User 5 text is displayed");

        } else {
            System.out.println("User 5 text is not displayed");
        }
    }

    @Test
    public void TC_02_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));

        if (emailTextbox.isEnabled()) {
            System.out.println("Email text box is enabled");
        } else {
            System.out.println("Email text box is not enabled");
        }

        WebElement ageUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (ageUnder18.isEnabled()) {
            System.out.println("Age under 18 radio button is enabled");
            ageUnder18.click();
        } else {
            System.out.println("Age under 18 radio button is not enabled");
        }

        WebElement eduTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
        if (eduTextArea.isEnabled()) {
            System.out.println("Edu text area is enabled");
            eduTextArea.sendKeys("Automation Testing");
        } else {
            System.out.println("Edu text area is not enabled");
        }

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='disable_password']"));
        if (passwordTextBox.isEnabled()) {
            System.out.println("Edu text area is enabled");
        } else {
            System.out.println("Edu text area is not enabled");
        }

        WebElement bioTextArea = driver.findElement(By.xpath("//textarea[@id='bio']"));
        if (bioTextArea.isEnabled()) {
            System.out.println("Biography is enabled");
        } else {
            System.out.println("Biography is not enabled");
        }

        WebElement ageDisable = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
        if (ageDisable.isEnabled()) {
            System.out.println("Age under 18 radio button is enabled");
            ageUnder18.click();
        } else {
            System.out.println("Age under 18 radio button is not enabled");
            ageUnder18.click();
        }

        WebElement jobRole1 = driver.findElement(By.xpath("//select[@id='job1']"));
        if (jobRole1.isEnabled()) {
            System.out.println("jobRole1 is enabled");
        } else {
            System.out.println("jobRole1 is not enabled");
        }

        WebElement jobRole2 = driver.findElement(By.xpath("//select[@id='job2']"));
        if (jobRole2.isEnabled()) {
            System.out.println("jobRole2 is enabled");
        } else {
            System.out.println("jobRole2 is not enabled");
        }

        WebElement jobRole3 = driver.findElement(By.xpath("//select[@id='job3']"));
        if (jobRole2.isEnabled()) {
            System.out.println("jobRole3 is enabled");
        } else {
            System.out.println("jobRole3 is not enabled");
        }

        WebElement interestDevelopment = driver.findElement(By.xpath("//input[@id='development']"));
        if (interestDevelopment.isEnabled()) {
            System.out.println("interest Development checkbox is enabled");
        } else {
            System.out.println("interest Development checkbox is not enabled");
        }

        WebElement interestDisable = driver.findElement(By.xpath("//input[@id='check-disbaled']"));
        if (interestDisable.isEnabled()) {
            System.out.println("Interest(Checkbox is disabled) is enabled");
        } else {
            System.out.println("Interest(Checkbox is disabled) is not enabled");
        }

        WebElement slide1 = driver.findElement(By.xpath("//input[@id='slider-1']"));
        if (slide1.isEnabled()) {
            System.out.println("slide1 is enabled");
        } else {
            System.out.println("slide1 is not enabled");
        }

        WebElement slide2 = driver.findElement(By.xpath("//input[@id='slider-2']"));
        if (slide2.isEnabled()) {
            System.out.println("slide2 is enabled");
        } else {
            System.out.println("slide2 is not enabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        ageUnder18.click();
        if (ageUnder18.isSelected()) {
            System.out.println("Age under 18 radio button is selected");
            ageUnder18.click();
        } else {
            System.out.println("Age under 18 radio button is not selected");
        }

        WebElement languaguesJava = driver.findElement(By.xpath("//input[@id='java']"));
        languaguesJava.click();
        if (languaguesJava.isSelected()) {
            System.out.println("languagues Java is selected");

        } else {
            System.out.println("languagues Java is not selected");
        }
    }

    @Test
    public void TC_04_Register() {
        driver.get("https://login.mailchimp.com/signup/");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        //WebElement userName = driver.findElement(By.xpath("//input[@id='new_username']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@id='new_password']"));
        //WebElement phone = driver.findElement(By.xpath("//input[@id='inputField']"));
        //WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

        email.sendKeys("abc@gmail.com");
        email.sendKeys(Keys.TAB);

        //only number
        passWord.sendKeys("12345");
        passWord.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//li[@class='plus-50 error completed']")).isDisplayed());

        //only lower text
        passWord.clear();
        passWord.sendKeys("bmg");
        passWord.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//li[@class='plus-50 error completed']")).isDisplayed());

        //pass hợp lệ
        passWord.clear();
        passWord.sendKeys("123456aA@");
        passWord.sendKeys(Keys.TAB);

        WebElement passHint = driver.findElement(By.xpath("//div[@id='passwordHint']//ul[@aria-label='Password helper text']"));
        if (passHint.isDisplayed()) {
            System.out.println("Pass hint is Displayed");
        } else {
            System.out.println("Pass hint is not Displayed");
        }

    }

    @Test
    public void TC_05_Login_Empty() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("(//a[@title='My Account'][normalize-space()='My Account'])[2]")).click();
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='advice-required-entry-email'])[1]")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='advice-required-entry-pass'])[1]")).getText(),"This is a required field.");
    }

    @Test
    public void TC_06_Login_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("(//a[@title='My Account'][normalize-space()='My Account'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='advice-validate-email-email'])[1]")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_07_Pass_less() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("(//a[@title='My Account'][normalize-space()='My Account'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("auto@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='advice-validate-password-pass'])[1]")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_08_Incorrect_Account() throws InterruptedException{
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("(//a[@title='My Account'][normalize-space()='My Account'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        System.out.println("timeout");
//        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("(//span[normalize-space()='Invalid login or password.'])[1]")).getText(),"Invalid login or password.");
    }

}



