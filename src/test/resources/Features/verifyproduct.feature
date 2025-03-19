Feature: Automated Testing of JPetStore Website

Scenario: Verify Product Details Page
    Given I navigate to a product details page
    Then I should see product title, description, price, and image
    And I should be able to add the product to cart