package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.bouncycastle.crypto.DerivationFunction;
import utils.Driver;

public class Hooks {

    @Before
    public void setup(){
        Driver.initDriver();

    }
    
    @After
    public void tearDown()
    {
       // Driver.getDriver().quit();
    }
}
