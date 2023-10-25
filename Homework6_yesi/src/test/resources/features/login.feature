Feature: Log in to the application

  @OnlyOneTime
  Scenario: Login to application as valid user
    Given User is on orange hrm homepage
    When User input <username> as username
    And user input <password> as password
    And user click enter
    Then user verify <status> login result

  Scenario: Login to application as Invalid user
    When User enter the invalid credentials
    And Click on Login
    Then Error Message Should be displayed

    Examples:
      | username      | password     | status  |
      | Standard_user | secret_sauce | success |
      | Standard_user | secret       | failed  |
