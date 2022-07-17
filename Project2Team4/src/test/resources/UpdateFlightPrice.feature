Feature: Update Flight Price

	Background: 
					Given the admin is on the adminSetDiscount.html Page

  Scenario Outline: A admin can update a flight price 
    #When the Admin types in the "<flightid>" and "<price>" and clicks the submit button
    When the Admin enter in the "<flight_id"> and "<price>" and clicks the submit button
    Then the Admin should be able to see the price changed in the Admin Home Page and back to AdminHomePage

    Examples: 
      | flightid | price |
      | 1        | 590 |
      | 3        |    690  |
      | 6        | 1980.88 |
      |10        | -187 |