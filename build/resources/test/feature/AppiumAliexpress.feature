Feature: Search product in AliExpress

  @SearchTest
  Scenario Outline:  I am in free market
    Given I am in the aliexpress application
    When I look for my product in the featured categories
    And I look for my product in the categories
    And I search for my product in the search window
    And I Clean My Shop Car
    Then  Valid that you have done everything correctly <Validation>

    Examples:
      | Validation |
      | Categorías |
