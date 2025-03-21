//saikiriti24396
package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderPage;

import java.util.Map;

public class OrderSteps {

    private WebDriver driver;
    private OrderPage orderPage;

    public OrderSteps() {
        driver = new ChromeDriver();  // Initialize WebDriver directly
        driver.manage().window().maximize();
        orderPage = new OrderPage(driver);
    }

    @Given("I open the Demowebshop homepage")
    public void openHomepage() {
        driver.get("http://demowebshop.tricentis.com");
    }

    @Given("I click on the item {string}")
    public void clickOnItem(String itemName) throws InterruptedException {
        orderPage.clickOnProduct();
        Thread.sleep(2000);
    }

    @When("I add the item to the cart")
    public void addItemToCart() throws InterruptedException {
        orderPage.addToCart();
        Thread.sleep(2000);
    }

    @And("I click on the cart")
    public void clickOnShoppingCart() {
        orderPage.openShoppingCart();
    }

    @And("I select {string} checkbox")
    public void selectCheckbox(String checkboxName) {
        orderPage.agreeToTerms();
    }

    @And("I click on the checkout button")
    public void clickOnCheckout() {
        orderPage.clickCheckout();
    }

    @And("I click on checkout as guest button")
    public void clickCheckoutAsGuest() {
        orderPage.checkoutAsGuest();
    }

    @And("I enter billing details:")
    public void enterBillingDetails(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        orderPage.enterBillingDetails(
            data.get("First name"),
            data.get("Last name"),
            data.get("Email"),
            data.get("Country"),
            data.get("City"),
            data.get("Address 1"),
            data.get("Zip / postal code"),
            data.get("Phone number")
        );
        orderPage.clickBillingContinue();
    }

    @And("I click on continue buttons for Shipping, Payment, and Confirmation")
    public void clickContinueSteps() throws InterruptedException {
    	Thread.sleep(3000);
        orderPage.clickShippingAddressContinue();// Shipping Address
        Thread.sleep(3000);
        orderPage.clickShippingMethodContinue();   // Shipping Method
        Thread.sleep(3000);
        orderPage.clickPaymentMethodContinue();    // Payment Method
        Thread.sleep(3000);
        orderPage.clickPaymentInformationContinue(); // Payment Information
    }
    
    @And("I click on the confirm order button")
    public void clickConfirmOrder() throws InterruptedException {
    	Thread.sleep(3000);
        orderPage.clickConfirmOrder();  // Confirm the order
    }

    @Then("I should see the order confirmation message {string}")
    public void verifyOrderConfirmation(String expectedMessage) throws InterruptedException {
    	Thread.sleep(2000);
        Assert.assertEquals(orderPage.getOrderConfirmationMessage(), expectedMessage);
    }

    @And("I click on {string} button to view all details")
    public void clickOnOrderDetails(String buttonName) throws InterruptedException {
    	Thread.sleep(2000);
        orderPage.clickOrderDetails();
        driver.quit();
    }
}
