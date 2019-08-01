Feature: Proceed to Payment with zero item in a cart

  @tag1
  Scenario Outline: User makes payment for checking out the product
    Given User has Successfully Added Product in to cart
    And User is on checkout page
    When User Proceed to Pay
    And User enters bank credentials "<bank_name>" "<bank_username>" "<bank_Password>" "<trans_password>"
    Then Order placed successfully

    Examples: 
      | bank_name   | bank_username | bank_Password | trans_password |
      | Andhra Bank |        123456 | Pass@456      | Trans@456      |
