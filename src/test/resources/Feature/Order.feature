Feature: Order

  Background: user access to website
    Given User opens the Website
      | url | https://2.stage.insomniacookies.com/ |

  Scenario: Verify User is able to place an Delivery order with Credit card
    Given user clicks on Order button
    When user enters the address
      | address | 140 16th St, phila pa |
    And user clicks on Delivery button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on a Six Pack
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters Valid Details under Delivery Info & your Info
      | recepient name   | Theresa Ainsworth |
      | recepient phone  |        2345678981 |
      | customer name    | Shaurya Nigam     |
      | customer phone   |        3457689024 |
      | customer emailID | snigam@judge.com  |
    And user enter delivery message
      | instructions | deliver fresh warm cookies |
    And user selects Payment Method as Credit Card
    And user enters credit card details
      | cc no     | 4111111111111111 |
      | cc expiry | 12 18            |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary


  Scenario: Verify User is able to place a Delivery order with Cash
    Given user clicks on Order button
    When user enters the address
      | address | 545 S Highland St |
    And user clicks on Delivery button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Insomniac
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters Valid Details under Delivery Info & your Info
      | recepient name   | Theresa Ainsworth |
      | recepient phone  |        2345678981 |
      | customer name    | Shaurya Nigam     |
      | customer phone   |        3457689024 |
      | customer emailID | snigam@judge.com  |
    And user enter delivery message
      | instructions | deliver fresh warm cookies |
    And user selects Payment Method as cash
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary

  Scenario: Verify User is able to place an Delivery order with School Cash
    Given user clicks on Order button
    When user enters the address
      | address | 421 E Beaver Ave, State College  pa |
    And user clicks on Delivery button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Insomniac
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters Valid Details under Delivery Info & your Info
      | recepient name   | Shaurya Nigam    |
      | recepient phone  |       2345678981 |
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user enter delivery message
      | instructions | deliver fresh warm cookies |
    And user selects Payment Method as School cash
    And user enters school cash number
      | School cash | 6020000000000000 |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary

  Scenario: Verify User is able to place an Delivery order with Gift Card
    Given user clicks on Order button
    When user enters the address
      | address | 4319 Main St Philadelphia, PA |
    And user clicks on Delivery button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Major Rager
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters Valid Details under Delivery Info & your Info
      | recepient name   | Shaurya Nigam    |
      | recepient phone  |       2345678981 |
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user enter delivery message
      | instructions | deliver fresh warm cookies |
    And user selects Payment Method as Gift card
    And user enters Gift card number
      | School cash | 1000002000015182 |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary

  
  Scenario: Verify User is able to place a Pickup order with Credit card
    Given user clicks on Order button
    When user enters the address
      | address | 140 16th St, phila pa |
    And user clicks on Pickup button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on a Six Pack
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters into your Info
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user selects Payment Method as Credit Card
    And user enters credit card details
      | cc no     | 4111111111111111 |
      | cc expiry | 12 18            |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary


  Scenario: Verify User is able to place a Pickup order with Cash
    Given user clicks on Order button
    When user enters the address
      | address | 545 S Highland St |
    And user clicks on Pickup button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Insomniac
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters into your Info
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user selects Payment Method as cash
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary


  Scenario: Verify User is able to place a Pickup order with School Cash
    Given user clicks on Order button
    When user enters the address
      | address | 421 E Beaver Ave, State College  pa |
    And user clicks on Pickup button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Insomniac
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters into your Info
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user selects Payment Method as School cash
    And user enters school cash number
      | School cash | 6020000000000000 |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary

@tag4
  Scenario: Verify User is able to place a Pickup order with Gift Card
    Given user clicks on Order button
    When user enters the address
      | address | 4319 Main St Philadelphia, PA |
    And user clicks on Pickup button
    And user select Date and Time from Calendar
    And user clicks on Continue
    And On Menu Page click on The Major Rager
    And user clicks on add product
    And user goes to the cart
    And user clicks on the checkout button
    And user enters into your Info
      | customer name    | Shaurya Nigam    |
      | customer phone   |       3457689024 |
      | customer emailID | snigam@judge.com |
    And user selects Payment Method as Gift card
    And user enters Gift card number
      | Gift Card | 9999998888877652 |
    And user clicks on Place Order
    Then Order confirmation page should appear displaying Order summary
