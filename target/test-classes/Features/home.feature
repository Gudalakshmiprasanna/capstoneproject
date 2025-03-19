Feature: Automated Testing of JPetStore Website

  Scenario: Verify Home Page
    Given I open the JPetStore home page
    Then I should see the page title as "JPetStore Demo"
    And all important links should be visible
    