package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class exe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01() throws InterruptedException{
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Thread.sleep(3000);

        //contains(text() để check text trên giao diện
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập họ tên')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập mật khẩu')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại mật khẩu')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập số điện thoại.')]")).isDisplayed();
        //driver.findElement(By.className("field-validation-error")).isDisplayed();
        Thread.sleep(3000);

    }

    @Test
    public void TC_02 () throws InterruptedException{
        //driver.findElement(By.xpath("//button[@href='']"))
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0123456789");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email')]")).isDisplayed();
        driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")).isDisplayed();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}