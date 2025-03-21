//saikiriti24396
package StepDefinations;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {

    ChromeDriver driver;
    ShoppingCartPage shoppingCartPage;

    @Given("I open the Demowebshop the website")
    public void iOpenTheDemowebshopWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com");
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @When("I search for a First product with keyword {string}")
    public void iSearchForAFirstProductWithKeyword(String keyword) {
        shoppingCartPage.searchProduct(keyword);
    }

    @And("I click on the first product for {string}")
    public void iClickOnTheFirstProductFor(String product) {
        shoppingCartPage.clickOnFirstProduct(product);
    }

    @And("I add the first product to the cart")
    public void iAddTheFirstProductToTheCart() {
        shoppingCartPage.addToCart();
    }

    @When("I search for another product with keyword {string}")
    public void iSearchForAnotherProductWithKeyword(String keyword) {
        shoppingCartPage.searchProduct(keyword);
    }

    @And("I click on the second product for {string}")
    public void iClickOnTheSecondProductFor(String product) {
        shoppingCartPage.clickOnSecondProduct(product);
    }

    @And("I add the second product to the cart")
    public void iAddTheSecondProductToTheCart() {
        shoppingCartPage.addToCart2();
    }

    @Then("I click on the shopping cart")
    public void iClickOnTheShoppingCart() {
        shoppingCartPage.openShoppingCart();
    }

    @And("I select the checkbox for the first product")
    public void iSelectTheCheckboxForTheFirstProduct() {
        shoppingCartPage.selectFirstProductCheckbox();
    }

    @And("I click on update shopping cart")
    public void iClickOnUpdateShoppingCart() {
        shoppingCartPage.updateShoppingCart();
    }

    @And("I click on quantity and change it to {string}")
    public void iClickOnQuantityAndChangeItTo(String quantity) {
        shoppingCartPage.changeQuantity(quantity);
    }

    @And("I click on update shopping cart again")
    public void iClickOnUpdateShoppingCartAgain() {
        shoppingCartPage.updateShoppingCart();
    }

    @And("I select the {string} checkbox")
    public void iSelectTheCheckbox(String checkbox) {
        shoppingCartPage.selectAgreeCheckbox();
    }

    @Then("I click on checkout")
    public void iClickOnCheckout() throws InterruptedException {
        shoppingCartPage.clickCheckout();
        Thread.sleep(2000);
        driver.quit(); // Close the browser after the test
    }
}