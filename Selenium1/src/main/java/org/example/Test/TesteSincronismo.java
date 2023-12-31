package org.example.Test;
import static org.example.Core.DriverFactory.getDriver;

import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TesteSincronismo {

    private DSL dsl;

    @Before
    public void inicializa(){
        getDriver().get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException{
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escrever("novoCampo", "Deu certo ?");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException{
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dsl.clicarBotao("buttonDelay");
        dsl.escrever("novoCampo", "Deu certo ?");
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void deveUtilizarEsperaExplicita() throws InterruptedException{
        dsl.clicarBotao("buttonDelay");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu certo ?");
    }
}
