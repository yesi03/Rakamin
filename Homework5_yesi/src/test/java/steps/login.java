package steps;

import java.util.concurrent.TimeUnit;
import org.selenium.WebDriver;

public class login {

    WebDriver driver;

    String baseUrl ="https://www.saucedemo.com/";

    @Given("user is on saucedemo login page")
    public void user_is_on_sauce_demo_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(time: 60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input (.*) as email$")
    public void user_input_ttd_selenium_gmail.com_as_email(String email)
        driver.findElement(By.id("email")).sendKeys(email);

}
