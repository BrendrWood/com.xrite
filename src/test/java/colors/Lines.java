package colors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Lines extends WebDriverSettings {

    @Test
    public void lines() {

        int a=38;
        for(int b=0;b<a;b++){
            action.moveToElement(driver.findElement(By.xpath(ArrayElementsXpath.first[b+1])))
   .clickAndHold().moveToElement(driver.findElement(By.xpath(ArrayElementsXpath.first[b])),42,0).release().perform();
        }

        driver.findElement(By.id("calculate")).click();

        driver.findElement(By.xpath("//span[@class='psuedo-input']")).click();
        driver.findElement(By.id("AgeRange")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='5']")));
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.id("compare")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='hue-score']")));
        String expectedScore = "0";
        WebElement score = driver.findElement(By.xpath("//span[@class='hue-score']"));
        String  actualScore = score.getText();
        Assert.assertEquals(actualScore, expectedScore);
    }

}
