Feature: Create user with name and job
  Me as a user
  I want to manage the process of creating a user
  to validate the successful query of the service

  @CreateUser
  Scenario Outline: Create user with name and job
    Given the user loads the url information
    When he send name <name> and job <job> to endpoint <endpoint>
    Then he will be able to visualize the user's creation response <responseCode> with the fields name, job
    Examples:
      | responseCode | name           | job       | endpoint  |
      | 201          | CreateUserTest | Testing01 | api/users |