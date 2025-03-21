//saikiriti24396
package StepDefinations;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {

    ChromeDriver driver;
    HomePage homePage;

    @Given("I open the Demowebshop website")
    public void openWebsite() {
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com");
        homePage = new HomePage(driver);
    }

    @Then("I verify the search bar is displayed")
    public void verifySearchBarDisplayed() throws InterruptedException {
        Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not displayed");
        Thread.sleep(2000);
        driver.quit(); // Close the browser after verification
    }
}