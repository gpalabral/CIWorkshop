package com.mycompany.test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestNGTest {
    
    
    public String baseUrl = "http://www.google.com";
    public WebDriver driver;
    
    public SeleniumTestNGTest() {
    }


    //@BeforeTest
    public void setBaseURL() throws Exception {
        
        System.setProperty("webdriver.chrome.driver","/Users/gustavo/Downloads/chromedriver");
        driver = new ChromeDriver();
        
        driver.get(baseUrl);
    }
    
    //@Test
    public void verifyHomePage(){
        String pageTitle = driver.getTitle();
        System.out.println("Page Title:: "+pageTitle);
        Assert.assertEquals(pageTitle, "Google");
    }
    
    //@Test
    public void verifySearch(){
        
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium");
        
        WebElement searchButton = driver.findElement(By.name("btnK"));
        
        searchButton.submit();
        
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        searchInput = driver.findElement(By.name("q"));
        
        String value = searchInput.getAttribute("value");
        System.out.println("value:: "+value);
        
        Assert.assertEquals(value, "Selenium");
    }


    //@AfterTest
    public void endSession() throws Exception {
        driver.quit();
    }
}
