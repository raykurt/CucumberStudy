package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {

    ExcelUtil excelUtil;
    List<Map<String, String>> testData;
    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
//        loginPage = new LoginPage();
//        commonPageElements = new CommonPageElements();
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);;
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
    }

    @Given("user login with excel as {string}")
    public void user_login_with_excel_as(String string) throws InterruptedException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = string +"_login_info";

        excelUtil=new ExcelUtil(path,sheetName);
        testData = excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String,String> eachData : testData){
            setUp();
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();

            ReusableMethods.waitFor(1);
            Assert.assertTrue(commonPageElements.myOperations.isDisplayed());
        }
    }
}

