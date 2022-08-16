package stepdefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.io.IOException;

public class ReusableStepDefs {

    @Then("capture the screenshot")
    public void capture_the_screenshot() {
        try {
            ReusableMethods.getScreenshot("Capturing_Screenshot");
        } catch (IOException e) {}
    }
}
