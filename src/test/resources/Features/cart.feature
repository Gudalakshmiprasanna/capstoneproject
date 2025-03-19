 Feature: Automated Testing of JPetStore Website
 
 Scenario: Shopping Cart Functionality
    Given I have to login
    When I add a product
    Then navigate to cart page
    When I update the quantity of a product
    Then the updated quantity should be reflected in the cart
    When I proceed to checkout
    Then I should be able to complete the purchase process