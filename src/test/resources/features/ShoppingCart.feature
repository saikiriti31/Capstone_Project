Feature: Shopping Cart Functionality

  Scenario: Manage items in the shopping cart with multiple products
    Given I open the Demowebshop the website
    When I search for a First product with keyword "Laptop"
    And I click on the first product for "Laptop"
    And I add the first product to the cart
    When I search for another product with keyword "Phone"
    And I click on the second product for "Phone"
    And I add the second product to the cart
    Then I click on the shopping cart
    And I select the checkbox for the first product
    And I click on update shopping cart
    And I click on quantity and change it to "6"
    Then I click on update shopping cart again
    And I select the "I agree" checkbox
    Then I click on checkout
