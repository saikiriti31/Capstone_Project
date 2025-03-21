//saikiriti24396
package StepDefinations;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.RegistrationPage;

public class UserRegistrationSteps {
    ChromeDriver driver;
    RegistrationPage registrationPage;
    
    @Given("I open Demowebshop")
    public void i_open_demowebshop() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com");
        registrationPage = new RegistrationPage(driver);
    }
    
    @When("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        registrationPage.clickRegisterLink();
    }
    
    @When("I register with {string} and {string} and unique email and {string} and {string} select male checkpoint in gender")
    public void i_register_with_unique_email(
        String firstName, String lastName, String password, String confirmPassword) {
        // Generate a unique email using timestamp
        String uniqueEmail = registrationPage.generateUniqueEmail("kiriti@gmail.com");
        System.out.println("Using unique email: " + uniqueEmail);
        
        registrationPage.fillRegistrationForm(firstName, lastName, uniqueEmail, password, confirmPassword, "male");
    }
    
    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(registrationPage.getRegistrationSuccessMessage(), expectedMessage, "Registration message mismatch!");
    }
    
    @Then("I click on continue")
    public void i_click_on_continue() {
        registrationPage.clickContinueButton();
    }
    
    @Then("I verify the text of email and confirm the user is logged in")
    public void i_verify_the_text_of_email_and_confirm_the_user_is_logged_in() {
        Assert.assertTrue(registrationPage.isUserLoggedIn(), "User is not logged in!");
        String loggedInEmail = registrationPage.getLoggedInEmail();
        Assert.assertEquals(loggedInEmail, registrationPage.getRegisteredEmail(), "Email mismatch!");
    }
    
    @Then("I click on logout button")
    public void i_click_on_logout_button() {
        registrationPage.clickLogoutButton();
    }
    
    @Then("I click on login button")
    public void i_click_on_login_button() {
        registrationPage.clickLoginLink();
    }
    
    @Then("I click on forget password")
    public void i_click_on_forget_password() {
        registrationPage.clickForgotPasswordLink();
    }
    
    @Then("I enter the registered email in the email box")
    public void i_enter_registered_email_in_the_email_box() {
        registrationPage.enterRecoveryEmail(registrationPage.getRegisteredEmail());
    }
    
    @Then("I enter email {string} in the email box")
    public void i_enter_email_in_the_email_box(String email) {
        registrationPage.enterRecoveryEmail(email);
    }
    
    @Then("I click on the recover button")
    public void i_click_on_the_recover_button() {
        registrationPage.clickRecoverButton();
    }
    
    @Then("receive this message {string}")
    public void receive_this_message(String expectedMessage) {
        Assert.assertEquals(registrationPage.getRecoveryMessage(), expectedMessage, "Recovery message mismatch!");
        driver.quit();
    }
}