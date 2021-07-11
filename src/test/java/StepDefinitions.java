import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions
{
    String expectedHomePageTitle="nopCommerce demo store";
    String actualHomePageTitle;

    String expectedLoginPageTitle="nopCommerce demo store. Login";
    String actualLoginPageTitle;

    String expectedRegisterPageTitle="nopCommerce demo store. Register";
    String actualRegisterPageTitle;

    String expectedConfMsg="Your registration completed";
    String actualConfMsg;

    String expectedFirstNameErrMsg="First name is required.";
    String actualFirstNameErrMsg;





    @Given("i navigate to url {string}")
    public void i_navigate_to_url(String url)
    {
        BasePage.homePage.navigateToUrl(url);
    }

    @Then("i should be navigated to home page")
    public void i_should_be_navigated_to_home_page()
    {
        actualHomePageTitle = BasePage.homePage.getPageTitle();
        Assertions.assertEquals(expectedHomePageTitle,actualHomePageTitle);
    }
    @When("i click on login link from the navbar")
    public void i_click_on_login_link_from_the_navbar()
    {
         BasePage.homePage.clickloginlink();

    }
    @Then("i should be navigated to login page")
    public void i_should_be_navigated_to_login_page()
    {
       actualLoginPageTitle = BasePage.homePage.getPageTitle();
       Assertions.assertEquals(expectedLoginPageTitle,actualLoginPageTitle);
    }
    @When("i enter email as {string}")
    public void i_enter_email_as(String email)
    {
       BasePage.loginPage.enterEmail(email);
    }
    @When("i enter password {string}")
    public void i_enter_password(String password)
    {
       BasePage.loginPage.enterPassword(password);
    }
    @When("i click on login button")
    public void i_click_on_login_button()
    {
       BasePage.loginPage.clickloginbutton();
    }
    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully()
    {
       BasePage.homePage.verifyLogout();
    }

    @When("i click on register link from the navbar")
    public void i_click_on_register_link_from_the_navbar()
    {
       BasePage.homePage.clickRegisterlink();
    }

    @Then("i should be navigated to register page")
    public void i_should_be_navigated_to_register_page()
    {
        actualRegisterPageTitle = BasePage.homePage.getPageTitle();
        Assertions.assertEquals(expectedRegisterPageTitle,actualRegisterPageTitle);
    }

    @When("i select gender as male")
    public void i_select_gender_as_male()
    {
        BasePage.registerPage.clickMaleRadioButton();
    }

    @When("i enter firstName lastName email password ConfirmPassword")
    public void i_enter_first_name_last_name_email_password_confirm_password(io.cucumber.datatable.DataTable dataTable) {
         BasePage.registerPage.enterFirstName(dataTable.cell(1,0));
         BasePage.registerPage.enterLastName(dataTable.cell(1,1));
         BasePage.registerPage.enterEmail(dataTable.cell(1,2));
         BasePage.registerPage.enterPassword(dataTable.cell(1,3));
         BasePage.registerPage.enterConfirmPassword(dataTable.cell(1,4));

    }

    @When("i click on register button")
    public void i_click_on_register_button() {
         BasePage.registerPage.clickRegisterbutton();
    }

    @Then("registration should be successful")
    public void registration_should_be_successful()
    {

        actualConfMsg = BasePage.registerPage.verifyConfMsg();
        Assertions.assertEquals(expectedConfMsg,actualConfMsg);


    }


    @And("i select day as {string}")
    public void iSelectDayAs(String day)
    {
        BasePage.registerPage.selectDay(day);
    }

    @Then("i should see error messages for all the mandatory fields")
    public void iShouldSeeErrorMessagesForAllTheMandatoryFields()
    {
         actualFirstNameErrMsg = BasePage.registerPage.getFirstNameErrorMsg();
         Assertions.assertEquals(expectedFirstNameErrMsg,actualFirstNameErrMsg);
    }
}
