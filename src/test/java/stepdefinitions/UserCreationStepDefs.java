package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.UserManagementPage;
import utilities.Driver;

public class UserCreationStepDefs {
    CommonPageElements commonpage = new CommonPageElements();
    UserManagementPage userManagementPage = new UserManagementPage();


    @Given("admin clicks administration")
    public void admin_clicks_administration() {
        Driver.waitAndClick(commonpage.administrationDropdown);
    }

    @Given("admin clicks user management")
    public void admin_clicks_user_management() {
        Driver.waitAndClick(commonpage.userManagementButton);
    }

    @Given("admin clicks the button to create a new user")
    public void admin_clicks_the_button_to_create_a_new_user() {
        Driver.waitAndClick(userManagementPage.CreateUserButton);
    }

    @Given("admin enters {string} for login")
    public void admin_enters_for_login(String loginText) {
        Driver.waitAndSendText(userManagementPage.login,loginText);
    }

    @Given("admin enters {string} for firstname and {string} for lastname")
    public void admin_enters_for_firstname_and_for_lastname(String firstName, String lastName) {
        Driver.waitAndSendText(userManagementPage.firstName,firstName);
        Driver.waitAndSendText(userManagementPage.lastName,lastName);
    }

    @Given("admin enters {string} for email")
    public void admin_enters_for_email(String email) {
        Driver.waitAndSendText(userManagementPage.email,email);
    }

    @Given("admin select language")
    public void admin_select_language() {
        Driver.selectByVisibleText(userManagementPage.langKey,"Türkçe");
    }

    @Given("admin select profile role")
    public void admin_select_profile_role() {
        Driver.selectByVisibleText(userManagementPage.profiles,"ROLE_USER");
    }

    @Given("admin clicks save button")
    public void admin_clicks_save_button() {
        Driver.waitAndClick(userManagementPage.saveButton);
    }

    @Given("verify creating user")
    public void verify_creating_user() {
        Driver.wait(1);
        Assert.assertTrue(userManagementPage.createdSuccessText.isDisplayed());
    }
}