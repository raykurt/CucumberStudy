@user_creation
Feature: user_creation_feature

  Scenario: login_with_admin_credentials
    Given user is on the login page
    When user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      | admin_id | admin_password |
      | CWoburn  | Cw192837?      |
    And user clicks on the login button
    Then verify succesfull login

  Scenario Outline: creating_new_user
    Given admin clicks administration
    And admin clicks user management
    And admin clicks the button to create a new user
    And admin enters "<login>" for login
    And admin enters "<firstname>" for firstname and "<lastname>" for lastname
    And admin enters "<email>" for email
    And admin select language
    And admin select profile role
    And admin clicks save button
    And verify creating user
    Then close the application
    Examples:
      | login     | firstname | lastname | email                 |
      | recep9811 | recep     | java     | receepjava@gmail.com |