package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.getDriver();
    }

    @After
    public void teardown() {

        //DriverManager.quitDriver();
    }
}