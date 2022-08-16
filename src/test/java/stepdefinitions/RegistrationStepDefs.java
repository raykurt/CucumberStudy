package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPageElements;
import pages.MoneyTransferPage;
import utilities.Driver;


public class RegistrationStepDefs {
    CommonPageElements commonPageElements = new CommonPageElements();
    MoneyTransferPage moneyTransferPage = new MoneyTransferPage();

    @Given("user clicks on my operations")
    public void user_clicks_on_my_operations() {
        commonPageElements.myOperations.click();

    }
    @Given("user clicks on transfer money")
    public void user_clicks_on_transfer_money() {
        commonPageElements.moneyTransferOption.click();

    }
    @When("user select the current account to transfer money from")
    public void user_select_the_current_account_to_transfer_money_from() {
        Driver.selectByValue(moneyTransferPage.transferFrom,"91303");
    }
    @When("user select the other account to transfer money to")
    public void user_select_the_other_account_to_transfer_money_to() {
        Driver.selectByValue(moneyTransferPage.transferTo,"91304");
    }
    @When("user provides the balance {string}")
    public void user_provides_the_balance(String string) {
        Driver.waitAndSendText(moneyTransferPage.balance,"3",1);
    }
    @When("user types the description")
    public void user_types_the_description() {
        Driver.waitAndSendText(moneyTransferPage.description,"Send",1);
    }
    @Then("user makes the money transfer and verify success message")
    public void user_makes_the_money_transfer_and_verify_success_message() {
        Driver.waitAndClickElement(moneyTransferPage.makeTransferButton,1);
        Driver.wait(1);
        Assert.assertTrue(moneyTransferPage.successMessageToastContainer.isDisplayed());
        System.out.println(moneyTransferPage.successMessageToastContainer.getText());
    }
}