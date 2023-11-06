package org.example.Test;
import static org.example.Core.DriverFactory.getDriver;

import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteAjax {

    private DSL dsl;

    @Before
    public void inicializa(){

        getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=bd1f7");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void testeAjax(){
        dsl.escrever("j_idt286:name", "Teste");
        dsl.clicarBotao("j_idt286:j_idt290");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.id("j_idt286:display"),"Teste"));
        Assert.assertEquals("Teste", dsl.obterTexto("j_idt286:display"));
    }

}
