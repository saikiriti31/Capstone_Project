//saikiriti24396
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    WebDriver driver;
    
    // Locators
    private By searchBar = By.id("small-searchterms"); // Locator for the search bar
    private By searchButton = By.cssSelector("input[type='submit']"); // Search button
    private By advancedSearchOption = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/form/div[1]/div[2]/label");
    private By categoryDropdown = By.id("Cid"); // Dropdown for catsegorie
    private By priceFromField = By.xpath("//*[@id=\"Pf\"]"); // Input field for "from" price
    private By priceToField = By.xpath("//*[@id=\"Pt\"]"); // Input field for "to" price
    private By searchButton2 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/form/div[3]/input"); // Search button
    private By filteredResults = By.cssSelector(".product-grid"); // Grid displaying results
    
    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Methods
    // Enter search keyword
    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchBar);
        searchInput.clear();
        searchInput.sendKeys(keyword);
    }
    
    // Click the search button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
    
    // Click on the advanced search option
    public void clickAdvancedSearch() {
        WebElement advancedSearch = driver.findElement(advancedSearchOption);
        if (!advancedSearch.isSelected()) { // Ensure it's selected
            advancedSearch.click();
        }
    }
    
    // Select a category from the dropdown
    public void filterByCategory(String category) {
        WebElement dropdownElement = driver.findElement(categoryDropdown);
        Select dropdown = new Select(dropdownElement); // Initialize Select for dropdown
        dropdown.selectByVisibleText(category); // Select by visible text
    }
    
    // Set the price range (from and to values)
    public void filterByPriceRange(String fromPrice, String toPrice) {
        WebElement fromInput = driver.findElement(priceFromField);
        fromInput.clear();
        fromInput.sendKeys(fromPrice);
        
        WebElement toInput = driver.findElement(priceToField);
        toInput.clear();
        toInput.sendKeys(toPrice);
    }
    
    // Click the second search button to apply filters
    public void clickSearchButton2() {
        driver.findElement(searchButton2).click();
    }
    
    // Verify if filtered results are displayed
    public boolean isFilteredResultsDisplayed() {
        return driver.findElements(filteredResults).size() > 0;
    }
}