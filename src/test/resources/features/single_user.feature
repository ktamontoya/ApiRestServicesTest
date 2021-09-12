Feature: Single users who are registered
  Me as a user
  I want to manage the process of single user
  to validate the successful query of the service

  @ListUsersWhoAreRegistered
  Scenario: Single user who are registered
    Given the user loads the url information
    When he consults the information presented at endpoint api/users/9
    Then will compare the answer it shows with response Code 200, id 9, firstName Tobias y lastName Funke
