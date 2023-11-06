package org.example.Core;

import static org.example.Core.DriverFactory.killDriver;
import org.junit.After;

public class BaseTest {
    @After
    public void finaliza(){
        killDriver();
    }
}
