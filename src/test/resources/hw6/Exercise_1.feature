Feature: Different Element Page action test

  Scenario: Check elements on  Different Element Page
    Given I am on Index Page
    And I login as user Roman Iovlev with username: 'Roman' and pass: 'Jdi1234' on Index Page
    And I go through the header menu Service to Different Elements Page
    When I select checkboxes 'Water' and 'Wind' on Different Elements Page
    And I select 'Selen' radio on Different Elements Page
    And I select 'Yellow' dropdown on Different Elements Page
    Then for each 'Water' and 'Wind' checkboxes there is an individual log row and value is corresponded to the status of checkbox
    And for 'Selen' radio button there is a log row and value is corresponded to the status of radio button
    And for 'Yellow' dropdown there is a log row and value is corresponded to the selected value