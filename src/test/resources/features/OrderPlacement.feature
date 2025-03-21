Feature: Order Placement
  Test the entire flow from adding items to the cart to completing a purchase.

  Scenario: Place an order
    Given I open the Demowebshop homepage
    And I click on the item "14.1-inch Laptop"
    When I add the item to the cart
    And I click on the cart
    And I select "I agree" checkbox
    And I click on the checkout button
    And I click on checkout as guest button
    And I enter billing details:
      | Field          | Value              |
      | First name     | sai                |
      | Last name      | kiriti             |
      | Email          | saikiriti@test.com |
      | Country        | United States      |
      | City           | New York           |
      | Address 1      | 123 Main St        |
      | Zip / postal code | 10001            |
      | Phone number   | 1234567890         |
    And I click on continue buttons for Shipping, Payment, and Confirmation
    And I click on the confirm order button
    Then I should see the order confirmation message "Your order has been successfully processed!"
    And I click on "Click here for order details." button to view all details
    