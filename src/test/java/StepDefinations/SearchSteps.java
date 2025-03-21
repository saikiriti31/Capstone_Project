//saikiriti24396
package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchSteps {
    WebDriver driver; // Declare WebDriver
    SearchPage searchPage; // Declare SearchPage object
    String searchKeyword;
    
    @Given("open the Demowebshop")
    public void openWebsite() {
        // Setup ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("http://demowebshop.tricentis.com"); // Navigate to the Demowebshop website
        searchPage = new SearchPage(driver); // Initialize the SearchPage object
    }
    
    @When("I search for a product with the keyword from Excel sheet")
    public void searchForProductFromExcel() {
        try {
            // Read the search keyword from Excel sheet
            FileInputStream fis = new FileInputStream("src/test/resources/ExcelSheet/Capstone.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1); // Assuming data is in the second row (index 1)
            Cell cell = row.getCell(0); // Assuming keyword is in the first column (index 0)
            searchKeyword = cell.getStringCellValue();
            workbook.close();
            fis.close();
            
            // Use the keyword to search
            searchPage.enterSearchKeyword(searchKeyword);
            searchPage.clickSearchButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @And("I click on the advanced search option")
    public void clickAdvancedSearch() {
        searchPage.clickAdvancedSearch(); // Click on the advanced search option
    }
    
    @Then("I filter the results by category {string}")
    public void filterByCategory(String category) {
        searchPage.filterByCategory(category); // Select the category from the dropdown
    }
    
    @Then("I filter the results by price range from {string} to {string}")
    public void filterByPriceRange(String fromPrice, String toPrice) {
        searchPage.filterByPriceRange(fromPrice, toPrice); // Set the price range (from and to)
    }
    
    @And("I click on the search button to apply filters")
    public void clickSearchButtonToApplyFilters() {
        searchPage.clickSearchButton2(); // Click the search button to apply the filters
    }
    
    @Then("I verify the filtered results are displayed correctly")
    public void verifyFilteredResults() {
        // Verify that the filtered results are displayed correctly
        Assert.assertTrue(searchPage.isFilteredResultsDisplayed(), "Filtered results are not displayed correctly!");
        driver.quit(); // Close the browser after verification
    }
}