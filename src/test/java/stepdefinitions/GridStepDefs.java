package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefs {

    WebDriver driver;

    @Given("user is on the application_url with chrome")
    public void user_is_on_the_application_url_with_chrome() throws MalformedURLException {
//        Creating a driver object by using RemoteWebDriver
//        URL is coming from terminal
//        newChromeOptions() method is used for running chromedriver
//        WebDriverManager.chromedriver.setup();

        driver = new RemoteWebDriver(new URL("http://192.168.0.16:4444"),new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
    }

    @Then("verify the title of the page is GMIBANK")
    public void verify_the_title_of_the_page_is_gmibank() {
        String title= "GMIBANK";
        Assert.assertTrue(driver.getTitle().equals(title));
    }

    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }

    @Given("user is on the application_url with firefox")
    public void user_is_on_the_application_url_with_firefox() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.16:4444"),new FirefoxOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
    }

}
