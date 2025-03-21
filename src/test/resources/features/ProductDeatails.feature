Feature: Product Details Functionality

  Scenario: Validate product details after searching
    Given I open the Demowebshop
    When I search for a product with keyword "Laptop"
    And I click on the product for "Laptop"
    Then I should see the product title
    And I should see the product description
    And I should see the product price
    And I should see the product image
    And I should see the product availability status
    And I add the product to the cart
    Then I should see a confirmation message "The product has been added to your"
