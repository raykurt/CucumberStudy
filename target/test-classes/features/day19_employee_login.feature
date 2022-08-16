@employee_login_scenario_outline @smoke
Feature: employee_login

 Scenario Outline: login_with_employee_credentials
   Given user is on the login page
   And user clicks on login dropdown
   And user clicks on sign in button
   And user sends username "<username>"
   And user sends password "<password>"
   And user clicks on the login button
   Then close the application

   Examples: credentials
   |username        |password     |
   |gino.wintheiser |%B6B*q1!TH   |
   |dallas.batz     |dOWjuXz8*es6 |
   |leonel.skiles   |x3uvY0f8hw1T |



#  1. Create the feature file
#  2. Run runner and generate missing step definitions
#  3. Put the step definitions in the LoginStepDefs Class
#  4. Start writting Java code in the step definition
#  5. Create page object