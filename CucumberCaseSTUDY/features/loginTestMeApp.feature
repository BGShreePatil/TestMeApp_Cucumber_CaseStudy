Feature: TestMeApp Automation Functional Testing

  @Login
  Scenario Outline: Successful Login of registered User
    Given User is on home page of TestMeApp application
    When User clicks on Signin Link
    And User enters "<Username>" and "<Password>"
    And User clicks on Login button
    Then User is on Home page with successful Login

    Examples: 
      | Username | Password  |
      | BgsHREE  | bgs123456 |

  