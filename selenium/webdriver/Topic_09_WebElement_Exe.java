package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_Exe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void TC_01_Displayed() {
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
            System.out.println("languaguesJava is not selected");
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}



