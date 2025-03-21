//saikiriti24396
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailsPage {

    ChromeDriver driver;

    // Locators
     By productTitleLocator = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1");
     By productDescriptionLocator = By.className("short-description");
     By productPriceLocator = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[5]/div/span");
     By productImageLocator = By.xpath("//*[@id=\"main-product-img-31\"]");
     By productAvailabilityLocator = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/span[2]");
     By addToCartButtonLocator = By.id("add-to-cart-button-31");
//     By cartConfirmationMessageLocator = By.xpath("//*[@id=\"bar-notification\"]/p");

    // Constructor
    public ProductDetailsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    // Methods to validate and interact with page elements
    public String getProductTitle() {
        return driver.findElement(productTitleLocator).getText();
    }

    public String getProductDescription() {
        return driver.findElement(productDescriptionLocator).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPriceLocator).getText();
    }
    
    public boolean isProductImageDisplayed() {
        return driver.findElement(productImageLocator).isDisplayed();
    }

    public String getProductAvailability() {
        return driver.findElement(productAvailabilityLocator).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButtonLocator).click();
    }

// // Get the cart confirmation message
//    public String getCartConfirmationMessage() {
//        return driver.findElement(cartConfirmationMessageLocator).getText();
//    }
}
