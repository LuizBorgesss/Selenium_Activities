package org.example.Test;
import static org.example.Core.DriverFactory.getDriver;

import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestAlert {

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
    public void deveInteragirComAlertSimples(){
        dsl.clicarBotao("alert");
        String texto = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Alert Simples", texto);

        dsl.escrever("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
        Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
    }

    @Test
    public void deveInteragirComAlertPrompt(){
        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
    }
}
