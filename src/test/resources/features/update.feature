Feature: Update user with another name and new job
  Me as a user
  I want to manage the process of update a user
  to validate the successful query of the service

  @CreateUser
  Scenario Outline: Update user with another name and new job
    Given the user loads the url information
    When he sends another name <name> and new job <job> to endpoint <endpoint>
    Then he will be able to view the update response of the user <responseCode> with the new fields name, job
    Examples:
      | responseCode | name           | job       | endpoint    |
      | 200          | UpdateUserTest | Testing02 | api/users/8 |