package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverFactory.getDriver().get("https://demowebshop.tricentis.com/");
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
