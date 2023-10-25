package steps;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import objectRepository.loginPage;

import static config.env.driver;


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

    @When("user input (.*) as username$")
    public void user_input_username(String username) {
        WebElement field_userName = driver.findElement(elementLogin.getField_username());
        field_userName.isDisplayed();
        field_userName.sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_password(String password) {
        WebElement field_password = driver.findElement(elementLogin.getField_password());
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys(password);
    }
    @And("user click enter")
    public void user_click_enter() {
        WebElement field_password = driver.findElement(elementLogin.getField_password());
        field_password.sendKeys(Keys.ENTER);
    }
    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if (status.contains("success")){
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.className("oxd-userdropdown-name"))
            );
        } else {
            driver.findElement(By.className("error-button"));
        }
    }

}
