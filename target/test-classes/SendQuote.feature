@selenium
Feature: Send Quote

  Scenario: Fill vehicle information and Send Quote
    Given I'm in the Vehicle Data page
    And I have the following customer information
      | firstName   | lastName    | dateOfBirth | address              | country       | zipCode | city       | occupation |
      | John        | Connor      | 10/10/1975  | 19828 valerio street | United States | 91306   | Los Angeles| Unemployed |
    Then I fill all the vehicle required fields
    And Move to Insurant Data page
    Then I fill all the insurant required fields
    And Move to Product Data page
    Then I fill all the product required fields
    And Move to Price page
    Then I select a price option
    And Move to Send Quote page
    Then I fill all the quote required fields
    And I send the quote request
    Then I receive a success message
