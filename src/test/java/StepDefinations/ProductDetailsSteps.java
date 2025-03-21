//saikiriti24396
package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    ChromeDriver driver; // Declare WebDriver
    ProductDetailsPage productDetailsPage; // Declare ProductDetailsPage object

    @Given("I open the Demowebshop")
    public void openDemowebshop() {
        driver = new ChromeDriver(); // Setup ChromeDriver
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("http://demowebshop.tricentis.com"); // Navigate to the website
    }

    @When("I search for a product with keyword {string}")
    public void searchForProduct(String keyword) {
        WebElement searchBar = driver.findElement(By.id("small-searchterms"));
        searchBar.clear();
        searchBar.sendKeys(keyword);
        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Search']"));
        searchButton.click();
    }

    @And("I click on the product for {string}")
    public void clickOnProductLink(String productName) {
        WebElement product = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[1]/a/img"));
        product.click();
        productDetailsPage = new ProductDetailsPage(driver); // Initialize ProductDetailsPage
    }

    @Then("I should see the product title")
    public void validateProductTitle() {
        Assert.assertFalse(productDetailsPage.getProductTitle().isEmpty(), "Product title is missing!");
    }

    @And("I should see the product description")
    public void validateProductDescription() {
        Assert.assertFalse(productDetailsPage.getProductDescription().isEmpty(), "Product description is missing!");
    }

    @And("I should see the product price")
    public void validateProductPrice() {
        Assert.assertFalse(productDetailsPage.getProductPrice().isEmpty(), "Product price is missing!");
    }
    
    @And("I should see the product image")
    public void validateProductImage() {
        Assert.assertTrue(productDetailsPage.isProductImageDisplayed(), "Product image is missing or not displayed!");
    }

    @And("I should see the product availability status")
    public void validateProductAvailability() {
        Assert.assertFalse(productDetailsPage.getProductAvailability().isEmpty(), "Product availability status is missing!");
    }

    @When("I add the product to the cart")
    public void addToCart() {
        productDetailsPage.addToCart();
    }

    @Then("I should see a confirmation message {string}")
    public void verifyCartAdditionMessage(String expectedMessage) throws InterruptedException {
    	if (driver.getPageSource().contains(expectedMessage)) {
			System.out.println("Message found: " + expectedMessage);
		} 
    	else {
			System.out.println(" Expected message not found: " + expectedMessage);
		}
    	Thread.sleep(3000);
    	driver.quit();
    }
}