package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
    private WebDriver driver;
    private DSL dsl;
    public CampoTreinamentoPage page;
    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter(value = 1)
    public String sobrenome;
    @Parameterized.Parameter(value = 2)
    public Object sexo;
    @Parameterized.Parameter(value = 3)
    public List<String> comidas;
    @Parameterized.Parameter(value = 4)
    public String[] esportes;
    @Parameterized.Parameter(value = 5)
    public String msg;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "C://Users//luize//Documents//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 735));
        driver.get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @After
    public void finaliza(){
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
            {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
        });
    }

    public void deveValidarRegras(){
        page.setNome(nome);
        page.setSobrenome(sobrenome);

        if (sexo.equals("Masculino")){
            page.setSexoMasculino();
        } else {
            page.setSexoFeminino();
        }

        if (comidas.contains("Carne"))page.setComidaCarne();
        if (comidas.contains("Pizza"))page.setComidaPizza();
        if (comidas.contains("Vegetariano"))page.setComidaVegetariano();

        page.setEsporte(esportes);
        page.cadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
    }
}
