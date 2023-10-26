package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestRegrasNegocio {

    @Test
    public void deveValidarNomeObrigatorio(){
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiz Eduardo");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiz Eduardo");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Borges");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarComidaObrigatorio() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiz Eduardo");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Borges");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        driver.quit();
    }

    @Test
    public void deveValidarComboObrigatorio() {
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiz Eduardo");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Borges");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        WebElement element1 = driver.findElement(By.id("elementosForm:esportes"));
        Select combo1 = new Select(element1);
        combo1.selectByVisibleText("Futebol");
        combo1.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
        driver.quit();
    }



}
