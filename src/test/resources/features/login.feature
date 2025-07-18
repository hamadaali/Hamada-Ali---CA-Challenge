Feature: Login functionality to PetFinder website

  @login
  Scenario Outline:: valid login test scenarios
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be logged in successfully
    Examples:
      | username                  | password   |
      | hmadaali099@gmail.com     | As@1234    |

  @login
  Scenario Outline:: invalid login test scenarios
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should get an error alert message "<message>"
    Examples:
      | username                 | password    |message                        |
      | wrong@user.com           | As@1234     |User does not exist.           |
      | hmadaali099@gmail.com    | wrongpass   |Incorrect username or password.|
