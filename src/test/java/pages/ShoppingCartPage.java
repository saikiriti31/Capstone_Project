//saikiriti24396
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartPage {

    ChromeDriver driver;

    // Locators
     By searchBox = By.id("small-searchterms");
     By searchButton = By.xpath("//input[@type='submit' and @value='Search']");
     By firstProduct = By.xpath("(//h2[@class='product-title']/a)[1]");
     By addToCartButton = By.xpath("//*[@id=\"add-to-cart-button-31\"]");
     By secondProduct = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[3]/div/div[1]/a/img");
     By addToCartButton2 = By.xpath("//*[@id=\"add-to-cart-button-43\"]");
     By shoppingCartLink = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
     By firstProductCheckbox = By.name("removefromcart");
     By updateCartButton = By.name("updatecart");
     By quantityField = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input");
     By agreeCheckbox = By.xpath("//*[@id=\"termsofservice\"]");
     By checkoutButton = By.id("checkout");

    // Constructor
    public ShoppingCartPage(ChromeDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchProduct(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public void clickOnFirstProduct(String product) {
        driver.findElement(firstProduct).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
    
    public void clickOnSecondProduct(String product) {
        driver.findElement(secondProduct).click();
    }
    
    public void addToCart2() {
        driver.findElement(addToCartButton2).click();
    }

    public void openShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public void selectFirstProductCheckbox() {
        driver.findElement(firstProductCheckbox).click();
    }

    public void updateShoppingCart() {
        driver.findElement(updateCartButton).click();
    }

    public void changeQuantity(String quantity) {
        WebElement quantityInput = driver.findElement(quantityField);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void selectAgreeCheckbox() {
        driver.findElement(agreeCheckbox).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
