package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ExerciseTestPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExerciseTestStepDefinitions {
    ExerciseTestPage exPage = new ExerciseTestPage();

    @Given("Logged in user with valid credentials")
    public void logged_in_user_with_valid_credentials() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        assertTrue(exPage.loginBox.isDisplayed());
        assertEquals("LOGIN",exPage.loginBox.getText());
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        exPage.login(username,password);
        assertEquals("RECENT ACTIVITY",exPage.recentActivities.getText());
    }

    @When("user navigate to USER1Test tab")
    public void user_navigate_to_tab() {
        exPage.user1Test.click();
    }

    @And("user choose Learn option from Firs Screen dropdown")
    public void user_choose_option_from_Firs_Screen_dropdown() {
        Select firstScreen = new Select(exPage.firstScreenDropDown);
        firstScreen.selectByValue("2");
    }

    @And("user activate Submit")
    public void user_activate_submit() {
        exPage.submit.click();
        Driver.get().switchTo().alert().accept();
    }

    @And("log out")
    public void log_out() {
        exPage.logout.click();
    }

    @Then("logged in user see Learn page")
    public void loggedInUserSeeLearnPage() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        exPage.login(username,password);
        String title = exPage.learLitle.getText();
        assertEquals("Learn",title);
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.titleIs("Learn: NetDimensions Talent Suite"));

    }
}