package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegisterPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegisterStepDefs {
    RegisterPage registerPage = new RegisterPage();
    @Given("User is on register page")
    public void user_is_on_register_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmiBank_registration_url"));
    }
    @When("user sends ssn {string}")
    public void user_sends_ssn(String ssn) {
        registerPage.ssnBox.sendKeys(ssn);
    }
    @When("user sends firstname as {string} and lastname as {string}")
    public void user_sends_firstname_as_and_lastname_as(String firstName, String lastName) {
        registerPage.firstName.sendKeys(firstName);
        registerPage.lastName.sendKeys(lastName);
    }
    @When("user sends phone number as {string}")
    public void user_sends_phone_number_as(String phoneNumber) {
        registerPage.phone.sendKeys(phoneNumber);
    }
    @When("user clicks register button")
    public void user_clicks_register_button() {
        registerPage.registerButton.click();
    }
    @Then("user see pop up {string}")
    public void user_see_pop_up(String successMessage) throws InterruptedException {
        Thread.sleep(2500);
        Assert.assertTrue(registerPage.successMessage.isDisplayed());
    }
    @And("user sends address as {string}")
    public void userSendsAddressAs(String address) {
        registerPage.address.sendKeys(address);
    }
    @And("user sends username as {string}")
    public void userSendsUsernameAs(String username) {
        registerPage.username.sendKeys(username);
    }
    @When("user sends email as {string}")
    public void user_sends_email_as(String email) {
        registerPage.email.sendKeys(email);
    }
    @When("user sends second password as {string}")
    public void user_sends_second_password_as(String firstPassword) {
        registerPage.firstPassword.sendKeys(firstPassword);
    }
    @And("user sends new password as {string}")
    public void userSendsNewPasswordAs(String newPassword) {
        registerPage.passwordConfirmation.sendKeys(newPassword);
    }
    @Then("user close application")
    public void user_close_application() {
        Driver.closeDriver();
    }
}