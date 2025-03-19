Feature: Automated Testing of JPetStore Website

Scenario: User Registration and Login
    Given I navigate to the registration page
    When I enter the following user details and submit the form:
    Then I should be registered successfully
    When I log in with the valid credentials  
    Then I should be successfully logged in
    