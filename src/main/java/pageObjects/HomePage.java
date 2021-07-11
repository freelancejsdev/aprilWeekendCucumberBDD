package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
WebDriver driver;
WebDriverWait wait;
//locators
    @FindBy(id="small-searchterms") public WebElement searchTextBox;
    @FindBy(className="search-box-button") public WebElement searchButton;

    @FindBy(linkText = "Log in") public WebElement loginlink;

    @FindBy(linkText="Register") public WebElement Registerlink;

    @FindBy(className = "ico-logout") public WebElement logoutLink;

    //constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

/*public void enterSearchText()
{
    searchTextbox.sendKeys("laptop");
}*/
//action
public void enterSearchText(String item)
{
    searchTextBox.sendKeys(item);
}
public void clickSearchButton()
{
    searchButton.click();
}

public void clickloginlink()
{
    wait=new WebDriverWait(driver,40);
    wait.until(ExpectedConditions.elementToBeClickable(loginlink));
    loginlink.click();
}

public void clickRegisterlink()
{
    Registerlink.click();
}


public void navigateToUrl(String url)
{
    driver.navigate().to(url);
}


public String getPageTitle()
{
  return  driver.getTitle();
}

public boolean verifyLogout()
{
    wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
   return logoutLink.isDisplayed();
}

}
