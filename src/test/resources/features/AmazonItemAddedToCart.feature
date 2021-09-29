@ui
Feature: Make a search in amazon
  Scenario: Validating item is added to the cart
    Given   user navigates to amazon application
    When    user searches for "Java 12 Programming"
    And     user selects the first item in the list and adds it to the cart
    Then    user validates that item is added to the cart

