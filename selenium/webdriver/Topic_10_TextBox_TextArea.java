package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_TextBox_TextArea {
    WebDriver driver;

    String educationText = "Auto\nwith\nselenium";

    String firstName, lastName, email, password, fullName, emID, userName;

    Integer number;

    Random rand;

    By submitButton = By.xpath("//button[@type='submit']");



    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        rand = new Random();

        firstName = "abc";
        lastName = "def";
        fullName = firstName + " " + lastName;
        email = "abc"+rand.nextInt(99999)+"@gmail.com";
        password = "abc123";
        userName = "abc"+rand.nextInt(99999);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        number = rand.nextInt(99999);

    }

    public void sendKeysElement(By by, String value) {
        WebElement element = driver.findElement(by);
        element.sendKeys(value);
    }

    public void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public char getAttribute(By by) {
        WebElement element = driver.findElement(by);
        element.getAttribute("value");
        return 0;
    }

    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys(educationText);
    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        //truy cập màn hình đăng nhập
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        //truy cập màn hình dang ky
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        //nhap thong tin dang ky va dang kys
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        Thread.sleep(2000);

        //pass qua man chong chay auto
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();

        //check thong tin khi dang ky thanh cong
        Assert.assertEquals(driver.findElement(By.xpath("(//span[normalize-space()='Thank you for registering with Main Website Store.'])[1]")).getText(),
                "Thank you for registering with Main Website Store.");
        String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        System.out.println(contactInformationText);
        Thread.sleep(2000);
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(email));
        //den màn hinh danh sách mobile
        driver.findElement(By.xpath("(//a[normalize-space()='Mobile'])[1]")).click();

        //chọn sản phẩm
        driver.findElement(By.xpath("(//a[@title='Samsung Galaxy'][normalize-space()='Samsung Galaxy'])[1]")).click();

        //review
        driver.findElement(By.xpath("(//a[normalize-space()='Add Your Review'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='Quality 1_5'])[1]")).click();
        driver.findElement(By.xpath("(//textarea[@id='review_field'])[1]")).sendKeys("good app\n"+"easy use");
        driver.findElement(By.xpath("(//input[@id='summary_field'])[1]")).sendKeys("best phone");
        driver.findElement(By.xpath("(//input[@id='summary_field'])[1]")).sendKeys("auto");
        driver.findElement(By.xpath("(//button[@title='Submit Review'])[1]")).click();

        Thread.sleep(1000);
        //pass qua man chong chay auto
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();

        //check thông tin sau khi review
        Assert.assertEquals(driver.findElement(By.xpath("(//span[normalize-space()='Your review has been accepted for moderation.'])[1]")).getText()
                ,"Your review has been accepted for moderation.");
        //logout

    }

    @Test
    public void TC_03() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //dăng nhập
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        clickElement(submitButton);
        Thread.sleep(1000);
        //vao màn hình PIM
        driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[3]")).click();

        //vao màn hình thêm nhân viên
        driver.findElement(By.xpath("(//a[normalize-space()='Add Employee'])[1]")).click();

        //thêm nhân viên
        driver.findElement(By.xpath("(//input[@placeholder='First Name'])[1]")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@placeholder='Last Name'])[1]")).sendKeys(lastName);
        emID = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value");
        System.out.println(emID);


        driver.findElement(By.xpath("(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(userName);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Hung1234");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Hung1234");
        clickElement(submitButton);

        Thread.sleep(8000);
        //check thông tin cá nhân
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value"),emID);

        //thêm thông tin
        driver.findElement(By.xpath("(//a[@class='orangehrm-tabs-item'])[4]")).click();

        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(String.valueOf(number));
        System.out.println(number);
        //System.out.println(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value"));
        //String inputNumber = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value");
        //System.out.println(inputNumber);
        driver.findElement(By.xpath("(//textarea[@placeholder='Type Comments here'])[1]")).sendKeys("Auto\nwith\nselenium");
        String commentInput = driver.findElement(By.xpath("(//textarea[@placeholder='Type Comments here'])[1]")).getAttribute("value");
        System.out.println(commentInput);
        clickElement(submitButton);

        //vào màn hình edit
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();

        //check thông tin mới thêm
        Thread.sleep(3000);
        Assert.assertEquals(Integer.valueOf(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value")),number);
        Assert.assertEquals(driver.findElement(By.xpath("(//textarea[@placeholder='Type Comments here'])[1]")).getAttribute("value"),commentInput);

        //logout
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();

        //login tài khoản mowis thêm
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hung1234");
        clickElement(submitButton);

        //vao man info
        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[3]")).click();
        Thread.sleep(8000);
        //verify dữ liệu cá nhân
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value"),emID);


        driver.findElement(By.xpath("(//a[@class='orangehrm-tabs-item'])[4]")).click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();

        //check thông tin
        Thread.sleep(3000);
        // Assert.assertEquals(driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).getAttribute("value"),inputNumber);
        Assert.assertEquals(driver.findElement(By.xpath("(//textarea[@placeholder='Type Comments here'])[1]")).getAttribute("value"),commentInput);
    }

    @AfterClass
    public void afterClass() {

        //driver.quit();

    }

}