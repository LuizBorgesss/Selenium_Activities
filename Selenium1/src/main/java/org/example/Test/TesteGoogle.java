package org.example.Test;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
@Test
    public void teste() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}