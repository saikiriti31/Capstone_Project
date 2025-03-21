//saikiriti24396
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

    private WebDriver driver;

    // Constructor
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
     By productLink = By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[1]/a/img");
     By addToCartButton = By.xpath("//*[@id=\"add-to-cart-button-31\"]");
     By shoppingCartLink = By.linkText("Shopping cart");
     By agreeCheckbox = By.id("termsofservice");
     By checkoutButton = By.id("checkout");
     By checkoutAsGuestButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]");

     By firstNameField = By.id("BillingNewAddress_FirstName");
     By lastNameField = By.id("BillingNewAddress_LastName");
     By emailField = By.id("BillingNewAddress_Email");
     By countryDropdown = By.id("BillingNewAddress_CountryId");
     By cityField = By.id("BillingNewAddress_City");
     By address1Field = By.id("BillingNewAddress_Address1");
     By zipField = By.id("BillingNewAddress_ZipPostalCode");
     By phoneField = By.id("BillingNewAddress_PhoneNumber");
     By billingContinueButton = By.xpath("//*[@id=\"billing-buttons-container\"]/input");

     By shippingAddressContinueButton = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
     By shippingMethodContinueButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
     By paymentMethodContinueButton = By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
     By paymentInformationContinueButton = By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");
     By confirmOrderButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");

     By orderConfirmationMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong");
     By orderDetailsButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a");

    // Methods
    public void clickOnProduct() {
        driver.findElement(productLink).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void openShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public void agreeToTerms() {
        driver.findElement(agreeCheckbox).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void checkoutAsGuest() {
        driver.findElement(checkoutAsGuestButton).click();
    }

    public void enterBillingDetails(String firstName, String lastName, String email, String country, String city, String address, String zip, String phone) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(address1Field).sendKeys(address);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickBillingContinue() {
        driver.findElement(billingContinueButton).click();
    }

    public void clickShippingAddressContinue() {
        driver.findElement(shippingAddressContinueButton).click();
    }

    public void clickShippingMethodContinue() {
        driver.findElement(shippingMethodContinueButton).click();
    }

    public void clickPaymentMethodContinue() {
        driver.findElement(paymentMethodContinueButton).click();
    }

    public void clickPaymentInformationContinue() {
        driver.findElement(paymentInformationContinueButton).click();
    }
    
    public void clickConfirmOrder() {
        driver.findElement(confirmOrderButton).click();
    }

    public String getOrderConfirmationMessage() {
        return driver.findElement(orderConfirmationMessage).getText();
    }

    public void clickOrderDetails() {
        driver.findElement(orderDetailsButton).click();
    }
}
