Feature: User Table Page action test

  Scenario: User Table Page test
    Given I am on Index Page
    And I login as user Roman Iovlev with username: 'Roman' and pass: 'Jdi1234' on Index Page
    When I click on Service button in Header
    And I click on User Table button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
