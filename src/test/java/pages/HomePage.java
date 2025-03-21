//saikiriti24396
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Locator for the search bar
    By searchBar = By.id("small-searchterms");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to check if the search bar is visible
    public boolean isSearchBarVisible() {
        return driver.findElement(searchBar).isDisplayed();
    }
}
