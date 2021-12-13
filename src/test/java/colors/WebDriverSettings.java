package colors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class WebDriverSettings  {
    public ChromeDriver driver;
    public WebDriverWait wait;
    public Actions action;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);

        driver.get("https://www.xrite.com/hue-test/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)","");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ot-sdk-row']")));

    }

    @AfterTest
    public void close(){
        driver.quit();
    }

}
