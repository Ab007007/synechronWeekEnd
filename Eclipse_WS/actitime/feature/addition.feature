@add
Feature: Addition

  Scenario: Addition
    Given user has 2 numbers 5 and 6
    When user perform addition
    Then he get 11

  Scenario: Substraction
    Given user has 2 numbers 5 and 6
    When user perform substration
    Then he get -1

  Scenario: Multiplication
    Given user has 2 numbers 5 and 6
    When user perform multiplication
    Then he get 30

  Scenario: Division
    Given user has 2 numbers 5 and 6
    When user perform division
    Then he get 1.2
