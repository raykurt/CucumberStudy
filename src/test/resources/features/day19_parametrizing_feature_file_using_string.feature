@parameter_search
Feature: Search_Functionality
  Background: user_is_on_the_page
    Given user is on the google page

  @i_search
  Scenario: TC01_iPhone_search
    When user search for "iPhone"
    Then verify the result has "iPhone"
    Then close the application

  Scenario: TC02_teapot_search
    When user search for "tea pot"
    Then verify the result has "tea pot"
    Then close the application

  Scenario: TC03_bmw_search
    When user search for "bmw"
    Then verify the result has "bmw"
    Then close the application

  Scenario: TC04_tesla_search
    When user search for "tesla"
    Then verify the result has "tesla"
    Then close the application