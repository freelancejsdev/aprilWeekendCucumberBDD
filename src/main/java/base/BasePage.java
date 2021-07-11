package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class BasePage
{

    public static WebDriver driver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static RegisterPage registerPage;

     @Before
     public static void setUp()
     {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         homePage = new HomePage(driver);
         loginPage = new LoginPage(driver);
         registerPage = new RegisterPage(driver);


     }

     @After
     public static void tearDown(Scenario scenario)
     {
         if(scenario.isFailed())
         {
             final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshot,"image/png","screenshot");
         }
         driver.quit();
     }
}
