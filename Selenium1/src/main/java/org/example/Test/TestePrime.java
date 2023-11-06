package org.example.Test;

import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {
    private DSL dsl;

    @Before
    public void inicializa(){
        DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=2629f");
        dsl = new DSL();

    }

    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    @Ignore
    public void deveInteragirComRadioPrime(){
        dsl.clicarRadio(By.xpath("//input[@id='j_idt287:line:0']/../..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt287:line:0"));
        dsl.clicarRadio(By.xpath("//label[.='Option3']/..//span"));
        Assert.assertTrue(dsl.isRadioMarcado("j_idt287:line:2"));
    }

    @Test
    public void deveInteragirComComboPrime(){
        // dsl.selecionarComboPrime();
        dsl.clicarRadio(By.xpath("//*[@id='j_idt286:option_input']/../..//span"));
        dsl.clicarRadio(By.xpath("//*[@id='j_idt286:option_items']//li[.='Option2']"));
        Assert.assertEquals("Option2", dsl.obterTexto("j_idt286:option_label"));
    }
}
