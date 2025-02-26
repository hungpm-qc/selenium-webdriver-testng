package PMNB_TNMT;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class archive_HS {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://10.0.20.7:31501/authenticate");
        driver.manage().window().maximize();

        //đăng nhập
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("administrator");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Savis@A123");
        driver.findElement(By.xpath("//button[@class='btn btn-login']")).click();
        Thread.sleep(3000);
        //đổi ngôn ngữ
        driver.findElement(By.xpath("(//button[@class='py-0 nav-link btn'])[1]")).click();
        driver.findElement(By.xpath("(//a[@class='dropdown-item'])[1]")).click();
    }

//    private void sendKeysElements(By by, String value) {
//        WebElement element = driver.findElement(by);
//        element.sendKeys(value);
//    }
//
//    private void clickElements(By by) {
//        WebElement element = driver.findElement(by);
//        element.click();
//    }

    @Test
    public void TC_01_Access() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("http://10.0.20.7:31501/transfer");
        driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
        driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
        driver.getCurrentUrl().equals("http://10.0.20.7:31501/transfer");
    }

    @Test
    public void TC_02_Create() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("http://10.0.20.7:31501/transfer");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Bộ Tài nguyên môi trường1')])[1]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='ng-option-label'][contains(text(),'Cục địa chất23')])[1]")).click();

        //Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).click();
        driver.findElement(By.xpath("(//span[@class='ng-option-label'][normalize-space()='hstessttt9999_hstessttt9999'])[1]")).click();

        //Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='FormatName'])[1]")).sendKeys("test00123");
        driver.findElement(By.xpath("(//button[@class='flex-grow-1 btn btn-outline-info'])[1]")).click();
        //driver.findElement(By.xpath("(//p[contains(text(),'Duyệt yêu cầu thành công')]")).isDisplayed();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space()='1_001_C24TRB_887_63177 (2).pdf'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-secondary mar-right-5'])[1]")).click();

        driver.findElement(By.xpath("(//span[@class='del-item'])[1]")).isDisplayed();
        driver.findElement(By.xpath("(//button[@class='btn btn-info white flex-grow-1'])[1]")).click();

        //driver.findElement(By.xpath("(//p[contains(text(),'Thêm mới định dạng thành công!')]")).isDisplayed();
        //driver.findElement(By.xpath("//a[@class='custom-border nav-link active' and (//a[contains(text(),'Đang chờ')])[1]]")).isDisplayed();
        driver.findElement(By.xpath("//p[contains(text(), 'test00123')]")).isDisplayed();

    }

    @Test
    public void TC_03_Process() throws InterruptedException {
        //truy cập page
        driver.get("http://10.0.20.7:31501/transfer");
        Thread.sleep(3000);
        //scoll
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Cuộn đến phần tử cụ thể
        WebElement element = driver.findElement(By.xpath("(//button[@type='button'][contains(text(),'Chọn')])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(3000);

        //thao tác
        driver.findElement(By.xpath("(//button[@type='button'][contains(text(),'Chọn')])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(text(),'Bắt đầu định dạng')])[1]")).isDisplayed();
        //driver.findElement(By.xpath("(//button[@class='dropdown-item'][contains(text(),'Bắt đầu định dạng')])[1]")).click();

    }

}

