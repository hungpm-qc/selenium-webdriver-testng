package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    Actions actions;
    WebDriverWait expliciWait;
    JavascriptExecutor js;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;

    }

    @Test
    public void TC_01_FB_Signup() {
        driver.get("https:/facebook.com/reg/");

        //tìm dropdowm
        select = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //chọn 1 item
        select.selectByVisibleText("25");

        //chọn xong verify đã chọn thành công chưa
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");

        //verify dropdown có phải là multi select k -> đúng trả về true
        Assert.assertFalse(select.isMultiple());
        Assert.assertEquals(select.getOptions().size(), 31);

        select = new Select(driver.findElement(By.xpath("//select[@id='month']")));

    }

    @Test
    public void TC_02_rode() {
        driver.get("https://www.rode.com/wheretobuy");
        select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        select.selectByVisibleText("Vietnam");

        driver.findElement(By.xpath("//input[@id='map_search_query']")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealer']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(), 16);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}