Feature: Search Product


@SearchProduct
  Scenario: User search for the product to buy
    Given User is on home page
    When User searched for the product
    And USer clicks on Find Details button
    Then User is succesfully redirect to product detail page of searched product
