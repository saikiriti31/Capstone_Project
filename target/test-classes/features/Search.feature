Feature: Automate search functionality on the Demowebshop website

  Scenario: Search for a product and filter by category and price range
    Given open the Demowebshop
    When I search for a product with the keyword from Excel sheet
    And I click on the advanced search option
    Then I filter the results by category " Computers >> Desktops"
    And I filter the results by price range from "1000" to "2000"
    And I click on the search button to apply filters
    And I verify the filtered results are displayed correctly