package org.example.Test;

import org.example.Core.BaseTest;
import org.example.Page.CampoTreinamentoPage;
import org.example.Core.DSL;
import org.example.Core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {

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
        DriverFactory.getDriver().get("file:///C:/Users/luize/Downloads/campo_treinamento/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
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
