package com.mycompany.test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DzoneTestCase {
    public String baseUrl = "http://dzone.com/";
    public WebDriver driver;
    
    public DzoneTestCase() {
    }


    //@BeforeTest
    public void setBaseURL() throws Exception {
        
        System.setProperty("webdriver.chrome.driver","/Users/gustavo/Downloads/chromedriver");
        driver = new ChromeDriver();
        
        driver.get(baseUrl);
    }
    
    //@Test
    public void verifyJoin(){
        
        WebElement joinLInk = driver.findElement(By.xpath("//div/a[@ng-click=\"signIn()\"]"));
        
        System.out.println("joinLInk::: "+joinLInk);
        joinLInk.click();
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WebElement title = driver.findElement(By.xpath("//div/h1"));
        
        
        System.out.println("value:: "+title.getText());
        
        Assert.assertEquals(title.getText(), "JOIN NOW");
    }


    //@AfterTest
    public void endSession() throws Exception {
        driver.quit();
    }
}
