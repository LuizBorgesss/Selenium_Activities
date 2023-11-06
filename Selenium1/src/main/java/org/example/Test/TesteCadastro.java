package org.example.Test;
// import static

import org.example.Core.BaseTest;
import org.example.Page.CampoTreinamentoPage;
import org.example.Core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteCadastro extends BaseTest {

    private CampoTreinamentoPage page;

    @Before
    public void inicializa(){
        DriverFactory.getDriver().get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        page = new CampoTreinamentoPage();
    }

    @Test
    public void deveRealizarCadastroComSucesso(){
        page.setNome("Wagner");
        page.setSobrenome("Costa");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Superior");
        page.setEsporte("Futebol");
        page.cadastrar();

        Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
        Assert.assertEquals("Wagner", page.obterNomeCadastro());
        Assert.assertEquals("Sobrenome: Costa",page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastro());
    }
}