Feature: Register functionality to PetFinder website

  @register
  Scenario:: register test scenarios
    Given I am on the Registration page
    When I enter email "ahmed3@mail.com" and continue
    And I enter First name "mohamed" and last name "ibrahim" and zip code "55432"
    And I enter password "Test@123" and confirm password "Test@123" and click agree to terms
    Then I should be receive activation email


