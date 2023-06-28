package testSuit;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl ="https://www.saucedemo.com/";
    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public  void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        String expected ="Products";
        String actual = driver.findElement(By.xpath("//span[@class='title']")).getText();

        Assert.assertEquals("Actual and expected are equal",expected,actual);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        List<WebElement> productNo = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("Product Number is :"+productNo.size());
    }



    @After
    public void Teardown(){
        closeBrowser();
    }
}
