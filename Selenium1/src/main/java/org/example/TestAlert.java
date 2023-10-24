package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
    @Test
    public void DeveInteragirComAlertSimples() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();
    }

    @Test
    public void DeveInteragirComAlertConfirm() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        driver.quit();
    }

    @Test
    public void DeveInteragirComAlertDismiss() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        driver.quit();
    }

    @Test
    public void DeveInteragirComAlertPrompt() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("2");
        alerta.accept();
        Assert.assertEquals("Era 2?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();

        driver.quit();
    }
}
