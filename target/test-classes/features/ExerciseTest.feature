Feature: As a logged in user,
  I want to be able to amend the first screen
  So that I see on login to the "Learn" page

  @test
  Scenario: Change to Learn
    Given Logged in user with valid credentials
    When user navigate to USER1Test tab
    And user choose Learn option from Firs Screen dropdown
    And user activate Submit
    And log out
    Then logged in user see Learn page
