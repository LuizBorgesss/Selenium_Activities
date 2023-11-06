package org.example.Suites;

import org.example.Test.TestAlert;
import org.example.Test.TesteCadastro;
import org.example.Test.TesteCampoTreinamento;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastro.class,
        TesteCampoTreinamento.class,
        TestAlert.class
})
public class SuiteTeste {

}
