package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
    }

    @Given("user clicks on login dropdown")
    public void user_clicks_on_login_dropdown() {
        loginPage.loginDropdown.click();
    }

    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Given("user sends username {string}")
    public void user_sends_username(String string) {
        loginPage.username.sendKeys(string);
    }

    @Given("user sends password {string}")
    public void user_sends_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Given("user has log in with {string} and {string}")
    public void user_has_log_in_with_and(String username, String password) {
        loginPage.loginApplication(username,password);
    }

    @When("user enters admin_id and admin_password")
    public void user_enters_admin_id_and_admin_password(DataTable credentials) {
//      username, password ----- first item
//      value1, value2 --------- second item

//      first way is to create a List<String>
//        List<String> adminCredentials = credentials.row(1);
//        System.out.println("adminCredentials = " + adminCredentials);
//        Driver.waitAndSendText(loginPage.username, adminCredentials.get(0));
//        Driver.waitAndSendText(loginPage.password, adminCredentials.get(1));

//      second way is creating a List of Map
//      2. List<Map<String,String>>
        List<Map<String,String>> adminCredentials = credentials.asMaps(String.class,String.class);
        for( Map<String,String> each : adminCredentials){
            System.out.println("each" + each);
            Driver.waitAndSendText(loginPage.username,each.get("admin_id"));
            Driver.waitAndSendText(loginPage.password,each.get("admin_password"));
        }
    }

    @Then("verify succesfull login")
    public void verify_succesfull_login() {
        Assert.assertTrue(commonPageElements.myOperations.isDisplayed());
    }
}
