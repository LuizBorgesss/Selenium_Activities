package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCadastro {

    @Test
    public void testeCadastro(){
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//      driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");

        // Teste elemento Nome
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Luiz Eduardo");
        Assert.assertEquals("Luiz Eduardo", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

        // Teste elemento sobrenome
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Borges");
        Assert.assertEquals("Borges", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));

        // Teste radio button
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

        // Teste checkbox
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        // Teste Select
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);

        combo.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

        // Teste combo
        WebElement element1 = driver.findElement(By.id("elementosForm:esportes"));
        Select combo1 = new Select(element1);
        combo1.selectByVisibleText("Futebol");
        combo1.selectByVisibleText("Natacao");
        List<WebElement> allSelectedOptions = combo1.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        // Clicar botão
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descnome")).getText().endsWith("Luiz Eduardo"));
        Assert.assertEquals("Sobrenome: Borges", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes:", driver.findElement(By.id("descSugestoes")).getText());

        driver.quit();
    }
}
