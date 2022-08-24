Feature: Login

  @ValidCredentials
  Scenario: Task Testing
    Given Setup Driver
    When Registration with login and password
     And Get list of players
     And Check sorting table of players
    Then Close driver

