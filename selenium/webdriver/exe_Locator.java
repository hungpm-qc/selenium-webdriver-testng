package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class exe_Locator {
    WebDriver driver;
    By firstName = By.xpath("//input[@id='txtFirstname']");
    By submit = By.xpath("//button[@class='btn_pink_sm fs16']");
    By email = By.xpath("//input[@id='txtEmail']");
    By emailCF = By.xpath("//input[@id='txtCEmail']");
    By password = By.xpath("//input[@id='txtPassword']");
    By passwordConfirm = By.xpath("//input[@id='txtCPassword']");
    By phone    = By.xpath("//input[@id='txtPhone']");

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //firstName = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
    }

    public void sendKeysElement(By by, String value) {
        WebElement element = driver.findElement(by);
        element.sendKeys(value);
    }

    public void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    @Test
    public void TC_01() throws InterruptedException {

        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập họ tên')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập mật khẩu')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại mật khẩu')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập số điện thoại.')]")).isDisplayed();
    }

    @Test
    public void TC_02() throws InterruptedException {
        Thread.sleep(3000);

        firstName.sendKeysElement("abc");
        email.sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email hợp lệ')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Email nhập lại không đúng')]")).isDisplayed();
        }

    @Test
    public void TC_03() throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc1234@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");

        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        //driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email hợp lệ')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Email nhập lại không đúng')]")).isDisplayed();
    }

    @Test
    public void TC_04() throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc12");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc12");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu phải có ít nhất 6 ký tự') and contains(@id,'txtPassword-error')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu phải có ít nhất 6 ký tự') and contains(@id,'txtCPassword-error')]")).isDisplayed();

//        WebElement cemailErrotLabel = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
//        Assert.assertTrue(cemailErrotLabel.isDisplayed());
//        System.out.println(cemailErrotLabel.getText());
    }


    @Test
    public void TC_05() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc124");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        //driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email hợp lệ')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu bạn nhập không khớp')and contains(@id,'txtCPassword-error')]")).isDisplayed();
    }

    @Test
    public void TC_06() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc124");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();

        //driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email hợp lệ')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Mật khẩu bạn nhập không khớp')and contains(@id,'txtCPassword-error')]")).isDisplayed();
    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }

}