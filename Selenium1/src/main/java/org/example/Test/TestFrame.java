package org.example.Test;
import static org.example.Core.DriverFactory.getDriver;

import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class TestFrame {
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
    public void deveInteragirComFrames(){
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        dsl.sairFrame();
        dsl.escrever("elementosForm:nome", msg);
    }

    @Test
    public void deveInteragirComJanelas(){
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.trocarJanela("Popup");
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        getDriver().close();
        dsl.trocarJanela("");
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }

    @Test
    public void deveInteragirComFrameEscondido(){
        // WebElement frame = driver.findElement(By.id("frame2"));
        dsl.entrarFrame("Frame2");
        // dsl.executarJS("window.scrollBy(0, arguments[0]", frame.getLocation().y);
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }
    @Test
    public void deveInteragirComJanelasSemTitulo(){
        dsl.clicarBotao("buttonPopUpHard");
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
        dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }


}