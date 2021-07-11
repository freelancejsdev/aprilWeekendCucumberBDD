package pageObjects;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage
{
WebDriver driver;
WebDriverWait wait;
//locators
   @FindBy(xpath = "//h2[text()='Register']") public WebElement Heading;
   @FindBy(id="gender-female") public WebElement femaleRadiobutton;
   @FindBy(id="gender-male") public WebElement maleRadioBtn;
   @FindBy(id="FirstName") public WebElement FirstnameTextbox;
   @FindBy(id="LastName") public WebElement LastnameTextbox;

    @FindBy(id="Email") public WebElement EmailTextBox;
    @FindBy(id="Company") public WebElement CompanynameTextBox;
    @FindBy(id="Password") public WebElement PasswordTextBox;
    @FindBy(id="ConfirmPassword") public WebElement ConfirmPasswordTextBox;
    @FindBy(id="register-button") public WebElement RegisterButton;
    @FindBy(css = "div.result") public WebElement confirmationMsg;

    @FindBy(name = "DateOfBirthDay") public WebElement dayDropdown;

    @FindBy(id="FirstName-error") public WebElement firstNameErrorMsg;


//constructors
public RegisterPage(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
}

//actions
public void clickFemaleRadiobutton()
{
    femaleRadiobutton.click();
}

public void clickMaleRadioButton()
{
    maleRadioBtn.click();
}
public void enterFirstName(String fm)
{
    FirstnameTextbox.sendKeys(fm);
}
public void enterLastName(String lm)
{
    LastnameTextbox.sendKeys(lm);
}

public void enterEmail(String ee)
{
    EmailTextBox.sendKeys(ee);
}
public void enterCompanyname(String ec)
{
    CompanynameTextBox.sendKeys(ec);
}
public void enterPassword(String ep)
{
    PasswordTextBox.sendKeys(ep);
}
public void enterConfirmPassword(String cp)
{
    ConfirmPasswordTextBox.sendKeys(cp);
}
public void clickRegisterbutton()
{
    RegisterButton.click();
}

public String verifyConfMsg()
{
    wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOf(confirmationMsg));
    return confirmationMsg.getText();
}

public void selectDay(String d)
{
    Select day = new Select(dayDropdown);
    day.selectByVisibleText(d);
}

public String getFirstNameErrorMsg()
{
    return firstNameErrorMsg.getText();
}
}
