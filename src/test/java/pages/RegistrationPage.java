//saikirit24396
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {
    ChromeDriver driver;
    private String registeredEmail; // Store the generated email
    
    // Locators
    By registerLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By genderMaleRadio = By.id("gender-male");
    By genderFemaleRadio = By.id("gender-female");
    By registerButton = By.id("register-button");
    By successMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]");
    By continueButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input");
    By accountEmailText = By.cssSelector(".account");
    By logoutButton = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By loginLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By forgotPasswordLink = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a");
    By recoveryEmailField = By.id("Email");
    By recoverButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/input");
    By recoveryMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div");
    
    // Constructor
    public RegistrationPage(ChromeDriver driver) {
        this.driver = driver;
    }
    
    // Methods
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }
    
    // Generate a unique email
    public String generateUniqueEmail(String baseEmail) {
        long timestamp = System.currentTimeMillis();
        String email = baseEmail.replace("@", timestamp + "@");
        this.registeredEmail = email; // Store the email for later use
        return email;
    }
    
    // Get the registered email
    public String getRegisteredEmail() {
        return this.registeredEmail;
    }
    
    public void fillRegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword, String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadio).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(genderFemaleRadio).click();
        }
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        driver.findElement(registerButton).click();
    }
    
    public String getRegistrationSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
    
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
    
    public boolean isUserLoggedIn() {
        return driver.findElement(accountEmailText).isDisplayed();
    }
    
    public String getLoggedInEmail() {
        return driver.findElement(accountEmailText).getText();
    }
    
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
    
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }
    
    public void enterRecoveryEmail(String email) {
        driver.findElement(recoveryEmailField).sendKeys(email);
    }
    
    public void clickRecoverButton() {
        driver.findElement(recoverButton).click();
    }
    
    public String getRecoveryMessage() {
        return driver.findElement(recoveryMessage).getText();
    }
}