package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        //explicitWait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //ImplicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //FluentWait
        fluentWait = new FluentWait<>(driver);

    }

    @Test
    public void TC_01() throws InterruptedException {
        //ImplicitWait dung cho find element

        //ExplicitWait cho element vs 1 dk ro rang -> hien thi hay k

        //FluentWait co the chinh polling tuy y

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemCustomDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']//li//div","Slower");

        selectItemCustomDropdown("//span[@id='number-button']","//ul[@id='number-menu']//li//div","10");

        selectItemCustomDropdown("//span[@id='salutation-button']","//ul[@id='salutation-menu']//li//div","Mrs.");

    }

    //khai bao ham de tai su dung
    private void selectItemCustomDropdown(String parent, String chid, String textItem) throws InterruptedException{
        //cho cho dropdown clickable
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parent)));

        //click vao element
        driver.findElement(By.xpath(parent)).click();
        Thread.sleep(2000);

        //cho  cho tat ca cac item dc load ra
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(chid)));

        //tim item dung vs mong doi
        List<WebElement> allItems = driver.findElements(By.xpath(chid));

        for (WebElement item: allItems){
            System.out.println(item.getText());
            if(item.getText().equals(textItem)){
                //click item tim kiem
                item.click();
                break;
            }
        };
    }



    @Test
    public void TC_02_Login() {

    }

    @AfterClass
    public void afterClass() {

        //driver.quit();
    }

}