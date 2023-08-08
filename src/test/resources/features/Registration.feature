@All
  Feature: Registration

    @BDD @Positive @Registration
      Scenario: Registration
      Given User is on homepage
      When User click on register link
      And User fill their name and address info
      And User fill the username, password, and confirm password
      And User click register button
      Then User is on dashboard page

    @BDD @Negative @Registration
    Scenario: Registration
      Given User is on homepage
      When User click on register link
      And User fill their name and address info
      And User fill the wrong username, password, and confirm password
      And User click register button
      Then User got error message