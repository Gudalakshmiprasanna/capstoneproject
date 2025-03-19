Feature: Automated Testing of JPetStore Website

Scenario: Search Functionality
    Given I am on the JPetStore home page
    When I search for "fish" in the search bar
    Then I should see search results related to "fish"
    And I should be able to select a product from search results
    And I should be able to verify product details like name, price, and availability